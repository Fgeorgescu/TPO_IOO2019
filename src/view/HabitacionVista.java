package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HabitacionVista extends JFrame implements InterfazVista {
	
	private static final HabitacionVista instance = new HabitacionVista();
	
	public static HabitacionVista getInstance(){
        return instance;
    }
	
	
	private JPanel panelPrincipal;
	private JLabel prueba;
	
	private HabitacionVista() {
		super("Bienvenido a la habitacion");
		this.setSize(400,400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panelPrincipal = new JPanel();
		
		
		panelPrincipal.setLayout(new BorderLayout(10,10));
		prueba = new JLabel();
		prueba.setText("Bienvenido a la habitacion");
		JPanel panelaux = new JPanel();
		panelaux.add(prueba);
		panelPrincipal.add(panelaux, BorderLayout.NORTH);
	}

	@Override
	public void mostrar() {
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}


	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
	}
	
	public void setTitulo(String titulo) {
		this.setTitle(titulo);
	}
}