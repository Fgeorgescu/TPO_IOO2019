package controller;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;

import models.Casa;
import models.Habitacion;
import view.CasaView;
import view.HabitacionVista;

@SuppressWarnings({ "rawtypes", "unchecked", "static-access"})
public class CasaController implements ActionListener {
	
	private Casa modelCasa;
	private CasaView casaView;
	private int i;
	
	public CasaController(Casa modelCasa, CasaView casaView) {
		this.modelCasa = modelCasa;
		this.casaView = casaView;
	}

	public void actionPerformed(ActionEvent evento) {
		
		String nombre = casaView.obtenerNombre();
		try {
		if (evento.getActionCommand().equals(casaView.AGREGAR)) {
			System.out.println(casaView.AGREGAR);
			modelCasa.agregarHabitación(nombre);
			casaView.setLista(convertirListaHabitacionesABotones(modelCasa.getHabitaciones()));
			
			casaView.actualizar();
		} else if (evento.getActionCommand().equals(casaView.REMOVER)) {
			System.out.println(casaView.REMOVER);

			modelCasa.removerHabitacion(nombre);
			casaView.setLista(convertirListaHabitacionesABotones(modelCasa.getHabitaciones()));
			
			casaView.actualizar();
		} else if (evento.getActionCommand().equals(casaView.NUEVAVENTANA)) {
			JButton boton = (JButton) evento.getSource();
			
			Habitacion habitacion = modelCasa.getHabitacion(boton.getText());
			HabitacionVista habVista = HabitacionVista.getInstance();
			new HabitacionController(habitacion, habVista);
			habVista.setTitulo("Bienvenido a " + boton.getText());
			
			habVista.mostrar();
		} else {
			
		}
		} catch (RuntimeException e) {
			casaView.warning(e.getMessage());
		}
	}
	
	public JPanel convertirListaHabitacionesABotones(List<Habitacion> habitaciones) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(habitaciones.size(),1));
		for (i=0; i < habitaciones.size(); i++) {
			Habitacion hab = modelCasa.getHabitaciones().get(i);
			JButton button = new JButton(hab.getNombre());
			button.addActionListener(this);
			button.setActionCommand(casaView.NUEVAVENTANA);
			panel.add(button);
		}
		return panel;
	}
	
	/*public void updateLista() {
		List<String> listaDeHabitaciones = this.modelCasa.getNombreHabitaciones();
		DefaultListModel model = new DefaultListModel();
		
		for (String nombre : listaDeHabitaciones) {
			model.addElement(nombre);
		}
		
		this.casaView.setLista(model);
	}*/ 
}
