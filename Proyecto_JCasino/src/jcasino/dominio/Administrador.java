package jcasino.dominio;

public class Administrador extends Usuario{

	private int nivelPermiso;
	
	public Administrador(String nombreUsuario, String nombre, String apellidos, int edad, String genero,
			String telefono, String correo, String contrasenna, double saldoActual) {
		super(nombreUsuario, nombre, apellidos, edad, genero, telefono, correo, contrasenna, saldoActual);
	}

	@Override
	public String toString() {
		return "Administrador [nivelPermiso=" + nivelPermiso + "]";
	}

	public int getNivelPermiso() {
		return nivelPermiso;
	}
	public void setNivelPermiso(int nivelPermiso) {
		this.nivelPermiso = nivelPermiso;
	}

	//Futuro Método de Baneos
	
}
