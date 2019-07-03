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
import view.ViewInterface;

public class CasaController implements ActionListener {
	
	private Casa modelCasa;
	private CasaView casaView;
	
	public CasaController(Casa modelCasa, CasaView casaView) {
		this.modelCasa = modelCasa;
		this.casaView = casaView;
	}

	public void actionPerformed(ActionEvent evento) {
		
		String nombre = casaView.obtenerNombre();
		try {
		if (evento.getActionCommand().equals(ViewInterface.AGREGAR)) {
			System.out.println(ViewInterface.AGREGAR);
			modelCasa.agregarHabitacion(nombre);
			casaView.mostrarListaDeHabitaciones(modelCasa.getHabitaciones(), this);
			
			casaView.actualizar();
		} else if (evento.getActionCommand().equals(ViewInterface.REMOVER)) {
			System.out.println(ViewInterface.REMOVER);

			modelCasa.removerHabitacion(nombre);
			casaView.mostrarListaDeHabitaciones(modelCasa.getHabitaciones(), this);
			
			casaView.actualizar();
		} else if (evento.getActionCommand().equals(ViewInterface.NUEVAVENTANA)) {
			JButton boton = (JButton) evento.getSource();
			
			Habitacion habitacion = modelCasa.getHabitacion(boton.getText());
			HabitacionVista habVista = HabitacionVista.getInstance();
			HabitacionController controller = new HabitacionController(habitacion, habVista);
			habVista.setControllers(controller);
			habVista.setTitulo("Bienvenido a " + boton.getText());
			
			habVista.mostrar();
		} else {
			
		}
		} catch (RuntimeException e) {
			casaView.warning(e.getMessage());
		}
	} 
}
