package jcasino.dominio;

public abstract class Juego {
	
	private String nombre;
	private double apuestaMinima;
	
	public Juego(String nombre, double apuestaMinima) {
		super();
		this.nombre = nombre;
		this.apuestaMinima = apuestaMinima;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getApuestaMinima() {
		return apuestaMinima;
	}
	public void setApuestaMinima(double apuestaMinima) {
		this.apuestaMinima = apuestaMinima;
	}


	@Override
	public String toString() {
		return "Juego [nombre=" + nombre + ", apuestaMinima=" + apuestaMinima + "]";
	}
	
	
	//Método abstracto para forzar a los 3 juegos a usar el mismo formato para procesar las apuestas
	public abstract double jugar(double cantidadApostada, Jugador jugador);
	
	
	
}
