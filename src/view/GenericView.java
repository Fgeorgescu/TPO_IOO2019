package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GenericView extends JFrame implements ViewInterface {

	JPanel panelPrincipal = new JPanel();

	public GenericView(String titulo) {
		super(titulo);
		
	}
	
	public void mostrar() {
		this.pack();
		this.setLocationRelativeTo(null);
		setVisible(true);		
	}

	
	public void actualizar() {
		SwingUtilities.updateComponentTreeUI(panelPrincipal);		
	}

	public void warning(String message) {
		JOptionPane.showMessageDialog(this,
			    message,
			    "WARNING",
			    JOptionPane.WARNING_MESSAGE);
	}
}
