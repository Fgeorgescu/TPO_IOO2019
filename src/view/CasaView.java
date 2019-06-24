package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.CasaController;
import models.Habitacion;

public class CasaView extends JFrame implements InterfazVista {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Estructura del SINGLETON
	private static final CasaView instance = new CasaView();
	
	public static CasaView getInstance(){
        return instance;
    }
	
	JTextField nuevaHabitacion;
	JButton agregarHabitacion;
	JButton removerHabitacion;
	JButton prueba;
	JPanel panelBotones = new JPanel();

	JList<JButton> listaHabitaciones;
	JPanel panelPrincipal = new JPanel();

	
	private CasaView() {
		super("Bienvenido a tu casa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panelPrincipal.setLayout(new BorderLayout(10,10));
		
		nuevaHabitacion = new JTextField(25);
		nuevaHabitacion.setText("");
		nuevaHabitacion.setToolTipText("Ingrese el nombre de la habitación");
		JPanel panelaux = new JPanel(); panelaux.add(nuevaHabitacion);
		panelPrincipal.add(panelaux, BorderLayout.NORTH);
		
		agregarHabitacion = new JButton("Agregar");
		agregarHabitacion.setActionCommand(AGREGAR);
		removerHabitacion = new JButton("Remover");
		removerHabitacion.setActionCommand(REMOVER);
	
		JPanel botonera = new JPanel();
		botonera.add(agregarHabitacion); botonera.add(removerHabitacion);
		panelPrincipal.add(botonera, BorderLayout.CENTER);
		getContentPane().add(panelPrincipal);
		
		/*listaHabitaciones = new JList<>();
		listaHabitaciones.setPreferredSize(new Dimension(400, 200));
		JScrollPane sp = new JScrollPane(listaHabitaciones);
		panelPrincipal.add(listaHabitaciones, BorderLayout.SOUTH);*/
		
	}
	
	
	public String obtenerNombre() {
		return nuevaHabitacion.getText();
	}
	
	public void setController(CasaController c) {
		agregarHabitacion.addActionListener(c);
		removerHabitacion.addActionListener(c);
	}
		
	public void mostrar() {
		this.pack();
		this.setLocationRelativeTo(null);
		setVisible(true);
	}


	@Override
	public void actualizar() {		
		SwingUtilities.updateComponentTreeUI(panelPrincipal);
	}
	
	public void warning(String message) {
		JOptionPane.showMessageDialog(this,
			    message,
			    "WARNING",
			    JOptionPane.WARNING_MESSAGE);
	}
	
	public void mostrarListaDeHabitaciones(List<Habitacion> habitaciones, CasaController controller) {
		int i;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(habitaciones.size(),1));
		for (i=0; i < habitaciones.size(); i++) {
			Habitacion hab = habitaciones.get(i);
			JButton button = new JButton(hab.getNombre());
			button.addActionListener(controller);
			button.setActionCommand(NUEVAVENTANA);
			panel.add(button);
		}
		this.setLista(panel);
	}
	
	public void setLista(JPanel panel) {
		panelPrincipal.remove(panelBotones);
		
		this.panelBotones = panel;
		panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
		this.pack();
	}
	
}