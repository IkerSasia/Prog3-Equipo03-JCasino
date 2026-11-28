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
	
	//Sumaro los puntos de cada mano (teniendo en cuenta el valor 1 o 11 de los Ases)
	private int calcularPuntos(ArrayList<Carta> mano) {
		int total = 0;
		int ases = 0;
		
		for (Carta c: mano) {
			total += c.getPuntos();
			if (c.getValor().equals("A")) {
				ases++;
			}
		}
		
		while (total > 21 && ases > 0) {
			total -= 10;
			ases--;
		}
		
		return total;
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
		this.manoJugador.clear();
		this.manoCrupier.clear();
		
		//Sacamos dos cartas para cada uno al empezar la ronda
		this.manoJugador.add(sacarCarta());
		this.manoJugador.add(sacarCarta());
		this.manoCrupier.add(sacarCarta());
		this.manoCrupier.add(sacarCarta());
		
		this.rondaActiva = true;
		this.resultado = "";
		
		return 0;
	}
	
	
	
	
	//Turno del jugador: pide una carta nueva
	public Carta pedirCarta() {
		
		//Mensaje por pedir carta cuando no ha empezado el juego
		if(!rondaActiva) {
			throw new IllegalStateException("No hay ninguna ronda activa");
		}
		
		Carta nuevaCarta = sacarCarta();
		manoJugador.add(nuevaCarta);
		
		if(getPuntosJugador() > 21) {
			rondaActiva = false;
			resultado = "¡Te has pasado de 21! Gana el crupier";
		}
		return nuevaCarta;
	}
	
	
	
	public double plantarse(Jugador jugador) {
		if (!rondaActiva) {
			throw new IllegalStateException("No hay ninguna ronda activa");
		}
		
		while (crupierRoba()) {
			crupierRobaCarta();
		}
		return resolverRonda(jugador);
	}
}
