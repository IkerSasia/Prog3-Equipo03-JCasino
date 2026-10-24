package jcasino.dominio;

import java.util.Random;

public class Ruleta extends Juego{

	private Random giro;
	
	public Ruleta(String nombre, double apuestaMinima) {
		super(nombre, apuestaMinima);
		this.giro = new Random();
	}
	
	
	@Override
	public double jugar(double cantidadApostada, Jugador jugador) {
		//Función para elegir un número, y asiganar el color a cada número
		return 0;
	}
	
	
}
