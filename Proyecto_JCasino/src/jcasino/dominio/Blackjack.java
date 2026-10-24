package jcasino.dominio;

import java.util.Random;

public class Blackjack extends Juego{
	
	private Random cartas;

	public Blackjack(String nombre, double apuestaMinima) {
		super(nombre, apuestaMinima);
		this.cartas = new Random();
	}

	@Override
	public double jugar(double cantidadApostada, Jugador jugador) {
		//Función para repartir cartas, hacer la suma, y comparar con las del Crupier
		return 0;
	}
	
	
	
}
