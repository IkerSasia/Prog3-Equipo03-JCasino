package jcasino.dominio;

public class Usuario {
	
	// Atributos del Usuario 
	private String nombreUsuario;
	private String nombre;
	private String apellidos;
	private int edad;
	private String genero;
	private String telefono;
	private String correo;
	private String contrasenna;
	
	// Atributos de gestión 
	private double saldoActual;
	
	
	// Constructor para los datos de un nuevo usuario
	public Usuario(String nombreUsuario, String nombre, String apellidos, int edad, String genero, String telefono,
			String correo, String contrasenna, double saldoActual) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.genero = genero;
		this.telefono = telefono;
		this.correo = correo;
		this.contrasenna = contrasenna;
		this.saldoActual = 0.0; // Establecemos el saldo en 0 con el que empiezan todos los usuarios 
	}
	
	
	
}
