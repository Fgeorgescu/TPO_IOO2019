package controller;

import models.Habitacion;
import view.HabitacionVista;
import view.InterfazVista;

public class HabitacionController {

	Habitacion model;
	HabitacionVista vista; 
	
	public HabitacionController(Habitacion model, HabitacionVista vista) {
		this.model = model;
		this.vista = vista;
	}

	
	
}
