package models;

public class Luz {
	
	private String nombre;
	private String id;
	private boolean prendida;
	
	public Luz(String nombre, String id) {
		this.nombre = nombre;
		this.id = id;
		this.prendida = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isPrendida() {
		return prendida;
	}
	
	/**
	 * en lugar de poder settear a más alto nivel la variable,
	 * considero que la luz debe saber prenderse y apagarse.
	 * 
	 * La habitación dará este comando a la luz, pero no puede modificar el 
	 * estado de la misma de manera indrecta con un setter. (De esta manera
	 * podemos sumar más cosas a prenderse, como seleccionar un color, o intensidad)
	 */
	public void prender() {
		this.prendida = true;
	}
	
	public void apagar() {
		this.prendida = false;
	}
	
	/**
	 * Cambia el estado de una lampara. Si está prendida (prendida = true)
	 * lo pasa a apagada (prendida=false)
	 */
	public void toggle() {
		this.prendida = !this.prendida;
	}
}
