package jcasino.swing;

import javax.swing.SwingUtilities;

import jcasino.dominio.Casino;
import jcasino.dominio.Jugador;

public class Main {

	public static void main(String[] args) {
		Casino casino = new Casino();
		cargarDatosPrueba(casino);
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VentanaInicioSesion(casino);
			}
		});

	}
	
	private static void cargarDatosPrueba(Casino casino) {
		Jugador jugador1 = new Jugador("iker", "Iker", "Sasia", 22, "Masculino", "600123456", "iker@jcasino.com", "1234");
		jugador1.recargarSaldo(200);
		
		casino.registrarUsuarios(jugador1);
	}

}
