package models;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;

public class Casa {

	private String propietario;
	private String nombre;
	private List<Habitacion> habitaciones;
	
	public Casa(String propietario, String nombre) {
		this.propietario = propietario;
		this.nombre = nombre;
		this.habitaciones = new ArrayList<>();
	}
	
	public Casa() {
		this.habitaciones = new ArrayList<>();
	}
	
	
	public List<Habitacion> getHabitaciones() {
		return this.habitaciones;
	}
	
	public void agregarHabitación(String nombreDeHabitacion) throws RuntimeException {
		if (Utils.isStringNullOrEmpty(nombreDeHabitacion)) {
			throw new RuntimeException("El nombre de la habitacion no puede ser vacío");
		}
	
		for(Habitacion habitacion : habitaciones) { //Recorre todo el array "luces" y hace lo que tengo en el body con c/elemento
			System.out.println("nombre habitacion: "+ habitacion.getNombre());
			if(habitacion.getNombre().equalsIgnoreCase(nombreDeHabitacion)) {
				throw new RuntimeException("Ya existe la habitacion: "+ habitacion.getNombre());
			}
		}
		
		habitaciones.add(new Habitacion(nombreDeHabitacion));
	}
	
	public void removerHabitacion(String nombreDeHabitacion) {
		if (Utils.isStringNullOrEmpty(nombreDeHabitacion)) {
			throw new RuntimeException("El nombre de la habitacion no puede ser vacío");
		}
		
		int i = 0;
		for(i = 0; i < habitaciones.size(); i++) { //Recorre todo el array "habitaciones" y hace lo que tengo en el body con c/elemento
			if(habitaciones.get(i).getNombre().equalsIgnoreCase(nombreDeHabitacion)) {
				habitaciones.remove(habitaciones.get(i)); //Remuebo la luz. Validar si comprime el array para mantener el size correcto
				return;
			}
		}
		throw new RuntimeException("No se encuentra la habitacion: "+ nombreDeHabitacion);
	}
	
	public List<String> getNombreHabitaciones() {
		List<String> nombres = new ArrayList<>();
		for (Habitacion hab : this.habitaciones) {
			nombres.add(hab.getNombre());
		}
		return nombres;
	}
	
	public Habitacion getHabitacion(String nombre) {
		for (Habitacion hab : this.habitaciones) {
			if (hab.getNombre().equalsIgnoreCase(nombre)) {
				return hab;
			}
		}
		return null;
	}
}