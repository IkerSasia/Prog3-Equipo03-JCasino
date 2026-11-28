package jcasino.dominio;

import java.util.ArrayList;
import java.util.Random;

public class Blackjack extends Juego{
	
	private Random cartas;
	private ArrayList<Carta> manoJugador;
	private ArrayList<Carta> manoCrupier;
	private double apuestaActual;
	private boolean rondaActiva;
	private String resultado;

	public Blackjack(String nombre, double apuestaMinima) {
		super(nombre, apuestaMinima);
		this.cartas = new Random();
		this.manoJugador = new ArrayList<Carta>();
		this.manoCrupier = new ArrayList<Carta>();
		this.apuestaActual = 0;
		this.rondaActiva = false;
		this.resultado = "";
	}
	
	public ArrayList<Carta> getManoJugador() {
		return manoJugador;
	}

	public ArrayList<Carta> getManoCrupier() {
		return manoCrupier;
	}

	public int getPuntosJugador() {
		return calcularPuntos(manoJugador);
	}

	public int getPuntosCrupier() {
		return calcularPuntos(manoCrupier);
	}

	public boolean isRondaActiva() {
		return rondaActiva;
	}

	public String getResultado() {
		return resultado;
	}
	
	// Método para sacar una carta aleatoria combinando valores y palos
	private Carta sacarCarta() {
		String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		String[] palos = { "♠", "♥", "♦", "♣" };
		
		String valor = valores[cartas.nextInt(valores.length)];
		String palo = palos[cartas.nextInt(palos.length)];
		
		return new Carta(valor, palo);
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
