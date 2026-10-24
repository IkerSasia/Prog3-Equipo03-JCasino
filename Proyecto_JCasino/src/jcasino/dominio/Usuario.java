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
	
	// ---MÉTODOS PARA GESTIONAR EL SALDO---
	
	// Método para recargar saldo ficticio
	public void recargarSaldo(double cantidad) {
		if (cantidad > 0) {
			this.saldoActual += cantidad;
		}
	}
	
	// Método para retirar saldo
	public boolean retirarSaldo(double cantidad) {
		if (cantidad > 0 && this.saldoActual >= cantidad) { // La segunda condición hace que no se pueda quedar en negativo
			this.saldoActual -= cantidad;
			
			return true; // Transacción completada
		}
		return false; // Transacción rechazada si la cantidad solicitada supera el saldo actual
	}

	
	// Creación de getters y setters 
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}
	
	
	
	
	
	
}
