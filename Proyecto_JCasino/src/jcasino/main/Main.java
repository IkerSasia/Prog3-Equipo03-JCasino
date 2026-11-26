package jcasino.main;


import java.sql.SQLException;
import jcasino.db.BaseDeDatos;

import javax.swing.SwingUtilities;


import jcasino.dominio.Casino;
import jcasino.dominio.Jugador;
import jcasino.swing.VentanaInicioSesion;

public class Main {

	public static void main(String[] args) {
		
BaseDeDatos bd = new BaseDeDatos();
		
		
		// Try and catch para comprobar que se establece correctamente la conexión y tratar errores 
		try {
			bd.conectar();
			System.out.println("Conexión establecida correctamente");
			
			bd.desconectar();
			System.out.println("Conexión cerrada correctamente");
		}
		catch (SQLException e) {
			System.out.println("Error de base de datos" + e.getMessage());
		}
		
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
