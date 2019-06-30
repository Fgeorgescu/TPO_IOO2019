package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import controller.HabitacionController;
import models.Luz;
import utils.Utils;

public class HabitacionVista extends GenericView {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1607368829468270126L;
	
	//Estructura del SINGLETON
	private static final HabitacionVista instance = new HabitacionVista();
	
	public static HabitacionVista getInstance(){
        return instance;
    }
	
	
	private JPanel panelPrincipal = new JPanel();
	JPanel lucesCore;
	JLabel lucesLable;
	JButton agregarLuz;
	JButton removerLuz;
	JTextField inputNuevaLuz;
	
	private HabitacionVista() {
		super("Bienvenido a la habitacion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.PAGE_AXIS));
		
		
		//JLABLE TITULO LUCES
		lucesLable = new JLabel("        Luces        ");//Los espacios son una manera simple (pero fea) de que el lable sea un poco más ancho y se vea más amigable la view
		lucesLable.setAlignmentX(CENTER_ALIGNMENT);
        lucesLable.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		panelPrincipal.add(lucesLable);
		panelPrincipal.add(Box.createVerticalStrut(3));
		
		//JLABLE PARA LOS BOTONES DE LAS LUCES
		//Inicializo vacío. un método de la vista se va a encargar de popularlo.
		lucesCore = new JPanel();
		panelPrincipal.add(lucesCore);
		panelPrincipal.add(Box.createVerticalStrut(3));
		
		//JLABEL PARA AGREGAR LUCES
		JPanel lucesManagerPanel = new JPanel();
		lucesManagerPanel.setLayout(new BorderLayout(5,5));
		inputNuevaLuz = new JTextField();
		inputNuevaLuz.setToolTipText("Ingrese el nombre de la luz a agregar");
		lucesManagerPanel.add(inputNuevaLuz, BorderLayout.NORTH);
		
		agregarLuz = new JButton("Agregar");
		agregarLuz.setActionCommand(AGREGAR);
		removerLuz = new JButton("Remover");
		removerLuz.setActionCommand(REMOVER);
		lucesManagerPanel.add(agregarLuz, BorderLayout.WEST); lucesManagerPanel.add(removerLuz, BorderLayout.EAST); 
		lucesManagerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panelPrincipal.add(lucesManagerPanel);
		
		//Si quiero agregar más elementos puedo hacerlo aquí abajo.
		
		this.getContentPane().add(panelPrincipal);
	}

	public void mostrarLuces(List<Luz> luces, HabitacionController controller) {
		int i;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(luces.size(),1));
		for (i=0; i < luces.size(); i++) {
			
			JToggleButton toggle = new JToggleButton();
			boolean isPrendida = luces.get(i).isPrendida();
			toggle.addChangeListener(controller); 
			toggle.setName(luces.get(i).getNombre());
			toggle.setToolTipText("Lampara: " + luces.get(i).getNombre());
			
			toggle.setSelected(isPrendida); //Setea el toggle en el estado que está la lámpara
			toggle.setIcon(buscarIconoDeLampara(isPrendida));
			toggle.setBackground(getToggleColor(isPrendida));
			panel.add(toggle);
		}
		this.setLista(panel);
	}

	public void setControllers(HabitacionController controller) {
		agregarLuz.addActionListener(controller);
		removerLuz.addActionListener(controller);
	}
	
	public void setLista(JPanel panel) {
		panelPrincipal.remove(lucesCore);
		
		this.lucesCore = panel;
		panelPrincipal.add(lucesCore);
		this.pack();
	}
	
	public void setTitulo(String titulo) {
		this.setTitle(titulo);
	}
	
	
	public ImageIcon buscarIconoDeLampara(boolean isPrendida) {
		return Utils.createImageIcon("resources/imagenes/" + 
										(isPrendida ? "lampara_prendida.png" : "lampara_apagada.png"), 
										"Icono de lampara " + 
												(isPrendida ? "prendida" : "apagada"));

	}
	
	public Color getToggleColor(boolean isPrendida) {
		return (isPrendida ? Color.WHITE : Color.GRAY);
	}
	
	public String obtenerNombre() {
		String response = this.inputNuevaLuz.getText();
		this.inputNuevaLuz.setText("");
		return response;
	}
}