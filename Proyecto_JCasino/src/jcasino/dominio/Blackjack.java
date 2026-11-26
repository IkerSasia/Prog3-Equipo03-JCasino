package jcasino.dominio;

import java.util.Random;

public class Blackjack extends Juego{
	
	private Random cartas;
	private int puntosJugador;
	private int puntosCrupier;
	private double apuestaActual;
	private boolean rondaActiva;
	private String resultado;

	public Blackjack(String nombre, double apuestaMinima) {
		super(nombre, apuestaMinima);
		this.cartas = new Random();
		this.puntosJugador = 0;
		this.puntosCrupier = 0;
		this.apuestaActual = 0;
		this.rondaActiva = false;
		this.resultado = "";
	}
	
	public int getPuntosJugador() {
		return puntosJugador;
	}

	public int getPuntosCrupier() {
		return puntosCrupier;
	}

	public boolean isRondaActiva() {
		return rondaActiva;
	}

	public String getResultado() {
		return resultado;
	}
	
	// Método para sacar una carta con un valor aleatorio entre 1 y 11
		private int sacarCarta() {
			return cartas.nextInt(11) + 1;
		}
	
		
	//--------------------------------------------------------------//
	//					FUNCIONAMIENTO DEL JUEGO					//
	//--------------------------------------------------------------//
	
	//Llamamos al método Jugar y añadimos la funcionalidad del Blackjack dentro
	@Override
	public double jugar(double cantidadApostada, Jugador jugador) {
		
		//Comprobamos que el saldo del Jugador llegue a la apuesta mínima
		if (cantidadApostada < getApuestaMinima()) {
			throw new IllegalArgumentException("Apuesta rechazada: la apuesta mínima es de "+getApuestaMinima()+"€");
		}
		
		//Cobramos el saldo de la apuesta
		if (!jugador.retirarSaldo(cantidadApostada)) {
			throw new IllegalStateException("Apuesta rechazada: saldo insuficiente");
		}
		
		this.apuestaActual = cantidadApostada;
		this.puntosJugador = sacarCarta() + sacarCarta();
		this.puntosCrupier = sacarCarta() + sacarCarta();
		this.rondaActiva = true;
		this.resultado = "";
		
		if (puntosJugador > 21) {
			this.rondaActiva = false;
			this.resultado = "¡Te has pasado de 21! Gana el crupier";
		}
		
		return 0;
	}
	
	//Turno del jugador: pide una carta nueva
	public int pedirCarta() {
		
		//Mensaje por pedir carta cuando no ha empezado el juego
		if(!rondaActiva) {
			throw new IllegalStateException("No hay ninguna ronda activa");
		}
		
		int nuevaCarta = sacarCarta();
		puntosJugador += nuevaCarta;
		
		if(puntosJugador > 21) {
			rondaActiva = false;
			resultado = "¡Te has pasado de 21! Gana el crupier";
		}
		return nuevaCarta;
	}
	
	public double plantarse(Jugador jugador) {
		
		//Mensaje por plantarse cuando no ha empezado la partida
		if(!rondaActiva) {
			throw new IllegalStateException("No hay ninguna ronda activa");
		}
		
		rondaActiva = false;
		
		while (puntosCrupier < 17) {
			puntosCrupier += sacarCarta();
		}

		if (puntosJugador == 21 && puntosCrupier != 21) {
			double premio = apuestaActual * 2.5;
			jugador.recargarSaldo(premio);
			resultado = "¡Blackjack! Has ganado " + premio + " €.";
			return premio;
		} else if (puntosCrupier > 21 || puntosJugador > puntosCrupier) {
			double premio = apuestaActual * 2;
			jugador.recargarSaldo(premio);
			resultado = "¡Has ganado! Premio: " + premio + " €.";
			return premio;
		} else if (puntosJugador == puntosCrupier) {
			double premio = apuestaActual;
			jugador.recargarSaldo(premio);
			resultado = "Empate. Recuperas " + premio + " €.";
			return premio;
		} else {
			resultado = "Gana el crupier.";
			return 0;
		}
	}
}
