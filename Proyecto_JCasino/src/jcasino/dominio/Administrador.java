package jcasino.dominio;

public class Administrador extends Usuario{

	private int nivelPermiso;
	
	public Administrador(String nombreUsuario, String nombre, String apellidos, int edad, String genero,
			String telefono, String correo, String contrasenna) {
		super(nombreUsuario, nombre, apellidos, edad, genero, telefono, correo, contrasenna);
		this.nivelPermiso = 1;
	}

	@Override
	public String toString() {
		return super.toString() + "Administrador [nivelPermiso=" + nivelPermiso + "]";
	}

	public int getNivelPermiso() {
		return nivelPermiso;
	}
	public void setNivelPermiso(int nivelPermiso) {
		this.nivelPermiso = nivelPermiso;
	}

	//Futuro Método de Baneos
	
}
