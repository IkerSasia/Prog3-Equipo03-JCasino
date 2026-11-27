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
	
	public ArrayList<Usuario> getLisUsuarios(){
		return listaUsuarios;
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
	
	
	//Método para eliminar usuarios siendo Admin(excepto usuarios administradores)
	public boolean eliminarUsuario(String nombreUsuario){
		for (int i = 0; i < listaUsuarios.size(); i++) {
			Usuario u = listaUsuarios.get(i);
			if(u.getNombreUsuario().equals(nombreUsuario)) {
				if(u instanceof Administrador) {
					throw new IllegalStateException("No se puede eliminar una cuenta de Administrador");
				}
				listaUsuarios.remove(i);
				return true;
			}
		}	
		return false;
	}
	
	
	//Método para actualizar el saldo de los jugadores siendo Admin
	public boolean actualizarSaldoJugador(String nombreUsuario, double nuevoSaldo) {
		if (nuevoSaldo < 0) {
			throw new IllegalArgumentException("El saldo no puede ser negativo");
		}
		for (Usuario u: listaUsuarios) {
			if(u.getNombreUsuario().equals(nombreUsuario) && u instanceof Jugador) {
				((Jugador) u).setSaldo(nuevoSaldo);
				return true;
			}
		}
		return false;
	}
	
	
	//Método para actualizar las apuestas mínimas siendo Admin
	public boolean actualizarApuestaMinima(String nombreJuego, double nuevaApuesta) {
		if(nuevaApuesta <= 0) {
			throw new IllegalArgumentException("La apuesta no puede ser 0 o menor");
		}
		for (Juego j: listaJuegos) {
			if(j.getNombre().equals(nombreJuego)) {
				j.setApuestaMinima(nuevaApuesta);
				return true;
			}
		}
		return false;
	}
	
	
	
}
