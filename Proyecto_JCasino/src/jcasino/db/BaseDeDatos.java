package jcasino.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatos {
	private Connection conn;
	
	public void conectar() throws SQLException{
		if (conn == null || conn.isClosed()) { // Evitar abrir otra conexion si ya hay una abierta
			conn = DriverManager.getConnection( "jdbc:sqlite:resources/db/jcasino.db");
		}
	}
	
	public void desconectar() throws SQLException{
		if (conn != null && !conn.isClosed()) {  // Comprobamos que haya una conexión abierta 
            conn.close();
		}
		
	}
}
