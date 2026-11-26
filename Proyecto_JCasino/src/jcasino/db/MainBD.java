package jcasino.db;

import java.sql.SQLException;
import jcasino.db.BaseDeDatos;

public class MainBD {

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
	}

}
