package models;

import java.util.ArrayList;
import java.util.List;

public class Casa {

	String propietario;
	String nombre;
	List<Habitacion> habitaciones;
	
	public Casa(String propietario, String nombre) {
		this.propietario = propietario;
		this.nombre = nombre;
		this.habitaciones = new ArrayList<>();
	}
	
	
	
	public void agregarHabitación(String nombreDeHabitacion) {
		/*if (Strings.isNullOrEmpty(nombreDeLuz)) {
			throw new RuntimeException("Ingrese un nombre válido para la luz");
		}*/ 
	
		for(Habitacion habitacion : habitaciones) { //Recorre todo el array "luces" y hace lo que tengo en el body con c/elemento
			if(habitacion.getNombre().equalsIgnoreCase(nombreDeHabitacion)) {
				//throw new RuntimeException("Ya existe la luz "+ nombreDeLuz);
				return; //Cuando sume el throw no es necesario este step. Por ahora lo sumo para que no joda
			}
		}
		
		habitaciones.add(new Habitacion(nombreDeHabitacion));
	}
	
	public void removerHabitacion(String nombreDeHabitacion) {
		/*if (Strings.isNullOrEmpty(nombreDeLuz)) {
		throw new RuntimeException("Ingrese un nombre válido para la luz");
		}*/ 
		
		for(Habitacion habitacion : habitaciones) { //Recorre todo el array "luces" y hace lo que tengo en el body con c/elemento
			if(habitacion.getNombre().equalsIgnoreCase(nombreDeHabitacion)) {
				habitaciones.remove(habitacion); //Remuebo la luz. Validar si comprime el array para mantener el size correcto
			}
		}
		//throw new RuntimeException("No se encuentra la lampara "+ nombreDeLuz);
		return;
	}
}