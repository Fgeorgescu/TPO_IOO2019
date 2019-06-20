package main;

import controller.CasaController;
import models.Casa;
import view.CasaView;

public class Main {

	public static void main(String []args ) {
		
		Casa modeloCasa = new Casa();
		
		CasaView vista = CasaView.getInstance();
		
		CasaController control = new CasaController(modeloCasa, vista);
		
		vista.setController(control);
		
		vista.mostrar();
	}
}