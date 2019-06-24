package utils;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Utils {

	public static boolean isStringNullOrEmpty(String string) {
		return (string == null) || "".equalsIgnoreCase(string);
	}
	
	//Código encontrado en https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html
	//Adaptado para ser estatico
	/**
	 * Codigo generado con fragmentos de internet. Nos permite obtener imagenes para usar como iconos, 
	 * y unificar su tamaño. Se puede sobrecargar con un int para conseguir iconos cuadtados de 
	 * tamaño custom (cambiando getScaledInstance), o totalmente custom sobrecargando con 2 ints
	 *
	 * @param path Imagen que queremos convertir en icono
	 * @param description
	 * @return
	 */
	public static ImageIcon createImageIcon(String path, String description) {
		
		ImageIcon result;
	    
		java.net.URL imgURL = ClassLoader.getSystemResource(path);
	    if (imgURL != null) {
	        result =  new ImageIcon(imgURL, description);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	    //Agregamos este fragmento de stack overflow para poder manejar el tamaño de los iconos (https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon)
	    Image image = result.getImage(); // transform it 
	    Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	    return new ImageIcon(newimg);
	}
}
