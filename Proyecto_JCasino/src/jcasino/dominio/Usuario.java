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

	// Creacion de toString, salvo contraseña por motivos de seguridad
	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad="
				+ edad + ", genero=" + genero + ", telefono=" + telefono + ", correo=" + correo +"]";
	}
	
	
	
	
	
	
}
