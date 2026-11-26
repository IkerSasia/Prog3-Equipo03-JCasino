package jcasino.dominio;

import java.util.ArrayList;

public class Casino {
	
	private ArrayList<Usuario> listaUsuarios;
	private ArrayList<Juego> listaJuegos;
	
	public Casino() {
		this.listaUsuarios = new ArrayList<Usuario>();
		this.listaJuegos = new ArrayList<Juego>();
		cargarJuegosPorDefecto();
		
	}
	
	private void cargarJuegosPorDefecto() {
		this.listaJuegos.add(new Slot("Tragaperras", 2.0));
		this.listaJuegos.add(new Ruleta("Ruleta", 5.0));
		this.listaJuegos.add(new Blackjack("Blackjack", 2.0));
	}
	
	public ArrayList<Juego> getListaJuegos() {
		return listaJuegos;
	}

	public void agregarJuego(Juego juego) {
		if (juego != null) {
			this.listaJuegos.add(juego);
		}
	}

	public Slot getSlot() {
		for (Juego j : listaJuegos) {
			if (j instanceof Slot) {
				return (Slot) j;
			}
		}
		return null;
	}

	public Ruleta getRuleta() {
		for (Juego j : listaJuegos) {
			if (j instanceof Ruleta) {
				return (Ruleta) j;
			}
		}
		return null;
	}

	public Blackjack getBlackjack() {
		for (Juego j : listaJuegos) {
			if (j instanceof Blackjack) {
				return (Blackjack) j;
			}
		}
		return null;
	}
	
	
	
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
