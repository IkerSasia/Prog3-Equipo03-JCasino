package jcasino.swing;

import javax.swing.SwingUtilities;

import jcasino.dominio.Casino;

public class Main {

	public static void main(String[] args) {
		Casino casino = new Casino();
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VentanaInicioSesion(casino);
			}
		});

	}

}
