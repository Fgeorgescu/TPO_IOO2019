package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import models.Casa;
import models.Habitacion;
import view.CasaView;

@SuppressWarnings("static-access")
public class CasaController implements ActionListener {
	
	private Casa modelCasa;
	private CasaView casaView;
	
	public CasaController(Casa modelCasa, CasaView casaView) {
		this.modelCasa = modelCasa;
		this.casaView = casaView;
	}

	public void actionPerformed(ActionEvent evento) {
		
		String nombre = casaView.obtenerNombre();
		
		System.out.println("NOMBRE: " + nombre);
		if (evento.getActionCommand().equals(casaView.AGREGAR)) {
			modelCasa.agregarHabitación(nombre);
			
			DefaultListModel lista = new DefaultListModel(); 
			for ( String s : modelCasa.getNombreHabitaciones()) {
				lista.addElement(s);
			}
			
			casaView.actualizarLista(lista);
		} else if (evento.getActionCommand().equals(casaView.REMOVER)) {
			modelCasa.removerHabitacion(nombre);
		} else {
			//ERROR
		}
	}
	
	public DefaultListModel getLista() {
		List<String> listaDeHabitaciones = this.modelCasa.getNombreHabitaciones();
		DefaultListModel model = new DefaultListModel();
		
		for (String nombre : listaDeHabitaciones) {
			model.addElement(nombre);
		}
		
		return model;
	}
}
