package jcasino.dominio;

import java.util.ArrayList;

public class Casino {
	
	private ArrayList<Usuario> listaUsuarios;
	private ArrayList<Juego> listaJuegos;
	
	public Casino() {
		this.listaUsuarios = new ArrayList<Usuario>();
		this.listaJuegos = new ArrayList<Juego>();
	}
	

	//Añadir funciones/métodos para crear usuarios e iniciar sesión
	
	//Método para registrar nuevos usuarios
	public boolean registrarUsuarios(Usuario nuevoUsuario) {
		
		//Recorremos la lista para comprobar si existe el usuario
		for (Usuario u : listaUsuarios) {
			//En caso de que exista devolvemos un false
			if (u.getNombreUsuario().equals(nuevoUsuario.getNombreUsuario())) {
				return false;
			}
		}
		
		//Si en el for no se ha encontrado ninguna coincidencia se devuelve un true y se añade el nuevo usuario a la lista
		listaUsuarios.add(nuevoUsuario);
		return true;
	}
	
	
	//Método para iniciar sesión
	public Usuario iniciarSesion(String nombreUsuario, String contrasenna) {
		
		//Recorremos la lista en busca del usuario y su contraseña
		for (Usuario u : listaUsuarios) {
			//Si las creedenciales coinciden devolvemos el Uusario
			if (u.getNombreUsuario().equals(nombreUsuario) && u.getContrasenna().equals(contrasenna)) {
				return u;
			}
		}
		//En caso de que no se encuentren coincidencias en los valores, devolveremos un null
		return null;
	}
	
	
}
