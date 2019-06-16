package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CasaController;
import models.Habitacion;

public class CasaView extends JFrame implements InterfazVista {

	JTextField nuevaHabitacion;
	JButton agregarHabitacion;
	JButton removerHabitacion;
	JList listaHabitaciones;
	JPanel panelPrincipal = new JPanel();
	
	public CasaView() {
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
		
		listaHabitaciones = new JList<>();
	}
	
	
	public String obtenerNombre() {
		return nuevaHabitacion.getText();
	}
	
	public void setController(CasaController c) {
		agregarHabitacion.addActionListener(c);
		removerHabitacion.addActionListener(c);
	}
	
	public void actualizarLista(DefaultListModel lista) {
		this.listaHabitaciones.setModel(lista);
		System.out.println("a");
		panelPrincipal.revalidate();
		panelPrincipal.repaint();
		System.out.println("b");
	}
		
	public void mostrar() {
		this.pack();
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
}