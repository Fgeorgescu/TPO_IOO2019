package models;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;

public class Habitacion {
	
	String nombre;
	List<Luz> luces;
	
	public Habitacion(String nombre) {
		this.nombre = nombre;
		luces = new ArrayList<>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public Luz getLuz(String name) {
		int i = 0;
		for( i=0 ; i < this.luces.size(); i++) {
			if(this.luces.get(i).getNombre().equalsIgnoreCase(name)) {
				return luces.get(i);
			}
		}
		throw new RuntimeException("No encontramos la lampara " + name);
	}
	
	public List<Luz> getLuces() {
		return this.luces;
	}
	/**
	 * para poder agregar una luz, debemos verificar que el nombre no exista.
	 * En caso de ser así se puede mostrar un mensaje de error (Exception throw)
	 * 
	 * En caso de no existir el nombre, generamos una nueva luz (new Luz()) y la agregamos al array
	 * 
	 * Es responsabilidad de la Habitación definir que ID va a tener la nueva luz ({hablitacon}_luz_{nro de la luz}
	 * @param nombreDeLuz Nombre de la nueva luz
	 */
	public void agregarLuz(String nombreDeLuz) {
		if (Utils.isStringNullOrEmpty(nombreDeLuz)) {
			throw new RuntimeException("Ingrese un nombre válido para la luz");
		}
		
		for(Luz luz : luces) { //Recorre todo el array "luces" y hace lo que tengo en el body con c/elemento
			if(luz.getNombre().equalsIgnoreCase(nombreDeLuz)) {
				throw new RuntimeException("Ya existe la luz "+ nombreDeLuz);
			}
		}
		System.out.println("Agregamos la luz" + nombreDeLuz);
		String id = nombreDeLuz; //Genero el ID con el formato deseado
		luces.add(new Luz(nombreDeLuz, id)); // Creo y sumo la luz al array en el mismo paso.
	}
	
	
	public void removerLuz(String nombreDeLuz) {
		if (Utils.isStringNullOrEmpty(nombreDeLuz)) {
			throw new RuntimeException("Ingrese un nombre válido para la luz");
		}
		int i;
		for(i = 0; i < luces.size(); i++) { //Recorre todo el array "luces" y hace lo que tengo en el body con c/elemento
			if(luces.get(i).getNombre().equalsIgnoreCase(nombreDeLuz)) {
				luces.remove(luces.get(i)); //Remuevo la luz. Validar si comprime el array para mantener el size correcto
				return;
			}
		}
		throw new RuntimeException("No se encuentra la lampara "+ nombreDeLuz);
	}
	
	
	public void prenderTodo() {
		for(Luz luz : luces) {
			luz.prender();
		}
	}
	
	public void apagarTodo() {
		for(Luz luz : luces) {
			luz.apagar();
		}
	}
}
