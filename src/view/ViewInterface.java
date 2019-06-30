package view;

public interface ViewInterface {

	public void mostrar();
	public void actualizar();
	public void warning(String mensaje);
	
	static final String AGREGAR = "Agregar elemento";
	static final String REMOVER = "remover elemento";
	static final String NUEVAVENTANA = "Abre una nueva ventana";

}
