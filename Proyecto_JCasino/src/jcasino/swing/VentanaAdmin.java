package jcasino.swing;

import javax.swing.JFrame;

import jcasino.dominio.Casino;

public class VentanaAdmin extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public VentanaAdmin(Casino casino) {
		setTitle("Ventana de Administrador");
		setSize(650, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		
		setVisible(true);
	}
}

