package main;

import controller.CasaController;
import models.Casa;
import view.CasaView;

public class Main {

	public static void main(String []args ) {
		System.out.println("Iniciamos el proyecto");
		
		Casa modeloCasa = new Casa();
		
		CasaView vista = new CasaView();
		
		CasaController control = new CasaController(modeloCasa, vista);
		
		vista.setController(control);
		
		vista.mostrar();
	}
}