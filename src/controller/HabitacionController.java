package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import models.Habitacion;
import models.Luz;
import view.HabitacionVista;
import view.ViewInterface;

public class HabitacionController implements ActionListener, ChangeListener {

	Habitacion model;
	HabitacionVista vista; 
	
	public HabitacionController(Habitacion model, HabitacionVista vista) {
		this.model = model;
		this.vista = vista;
	}
	@Override
	public void actionPerformed(ActionEvent evento) {
		
		String nombre = vista.obtenerNombre();
		try {
			if (evento.getActionCommand().equals(ViewInterface.AGREGAR)) {
				model.agregarLuz(nombre);
				vista.mostrarLuces(model.getLuces(), this);
				
				vista.actualizar();
			} else if (evento.getActionCommand().equals(ViewInterface.REMOVER)) {
				model.removerLuz(nombre);
				vista.mostrarLuces(model.getLuces(), this);
				
				vista.actualizar();
			}
		} catch (RuntimeException e) {
			vista.warning(e.getMessage());
		}
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		
		JToggleButton surce = (JToggleButton) e.getSource();
		String nombre = surce.getName();
		Luz luz = model.getLuz(nombre);
		if (surce.isSelected() == true && !luz.isPrendida()) {
			luz.prender();
			vista.mostrarLuces(model.getLuces(), this);

		} else if (surce.isSelected()==false && luz.isPrendida()){
			luz.apagar();
			vista.mostrarLuces(model.getLuces(), this);
		}
	}	
}