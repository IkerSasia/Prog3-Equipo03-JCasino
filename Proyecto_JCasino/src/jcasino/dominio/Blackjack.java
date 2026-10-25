package jcasino.dominio;

import java.util.Random;
import java.util.Scanner;

public class Blackjack extends Juego{
	
	private Random cartas;

	public Blackjack(String nombre, double apuestaMinima) {
		super(nombre, apuestaMinima);
		this.cartas = new Random();
	}

	//Método para sacar una carta con un valor aleatorio entre 1 y 11
	private int sacarCarta() {
		return cartas.nextInt(11) + 1;
	}
	
	//Llamamos al método Jugar y añadimos la funcionalidad del Blackjack dentro
	@Override
	public double jugar(double cantidadApostada, Jugador jugador) {
		
		//Comprobamos que el saldo del Jugador llegue a la apuesta mínima
		if (cantidadApostada < getApuestaMinima()) {
			System.out.println("Apuesta Rechazada: Saldo insuficiente");
			return 0;
		}
		
		//Cobramos el saldo de la apuesta
		if (!jugador.retirarSaldo(cantidadApostada)) {
			System.out.println("Apuesta Rechazada. Saldo insuficiente");
			return 0;
		}
		
		//Asignamos las 2 primeras cartas al Crupier y al Jugador
		int puntosJugador = sacarCarta() + sacarCarta();
		int puntosCrupier = sacarCarta() + sacarCarta();
		
		System.out.println("Tus cartas suman: "+puntosJugador);
		System.out.println("Las cartas del crupies suman: "+puntosCrupier);
		
		//Turno del Jugador: Si no está satisfecho con sus cartas pide más
		Scanner sc = new Scanner(System.in);
		
		while(puntosJugador < 21) {
			System.out.println("¿Quieres pedir una carta (P) o te plantas (S)?");
			String decision = sc.nextLine().toUpperCase();
			
			if (decision.equals("P")){
				int nuevaCarta = sacarCarta();
				puntosJugador += nuevaCarta;
				System.out.println("Te ha salido un: "+nuevaCarta);
				System.out.println("Ahora tienes: "+puntosJugador);
			}else if(decision.equals("S")){
				System.out.println("Te plantas con "+ puntosJugador+".");
				break;
			}else {
				System.out.println("Opción no valida. Escribe P o S.");
			}
		}
		
		//Turno del Crupier: Si el Crupier no llega al mínimo de 17 puntos pide más cartas
		if (puntosJugador <= 21) {
			System.out.println("Turno del crupier.");
			System.out.println("Puntuación actual: "+puntosCrupier);
			while (puntosCrupier < 17) {
				int nuevaCarta = sacarCarta();
				puntosCrupier += nuevaCarta;
				System.out.println("El crupier pide carta ("+nuevaCarta+").");
				System.out.println("Total del crupier: "+puntosCrupier);
			}
		}
		
		System.out.println();
		System.out.println("---RESULTADO FINAL---");
		if (puntosJugador == 21 && puntosCrupier < 21) {
			//Blackjack
			double premio = cantidadApostada * 2.5;
			jugador.recargarSaldo(premio);
			System.out.println("Blackjack");
			System.out.println("Has ganado: "+premio+"€");
			return premio;
			
		}else if (puntosJugador <= 21 && puntosCrupier == puntosJugador) {
			//Empate
			double premio = cantidadApostada * 1;
			jugador.recargarSaldo(premio);
			System.out.println("Empate, recuperas la cantidad apostada");
			return premio;
			
		}else if (puntosJugador < 21 && puntosJugador > puntosCrupier || puntosCrupier > 21) {
			//Ganar al Crupier
			double premio = cantidadApostada * 2;
			jugador.recargarSaldo(premio);
			System.out.println("Has ganado al Crupier, tu premio es de:"+premio+"€");
			return premio;
			
		}else if (puntosJugador > 21) {
			//Perder por suma mayor a 21
			System.out.println("¡Te has pasado de 21!, la siguiente vez será");
			return 0;
			
		}else{
			//Perder contra el Crupier
			System.out.println("El Crupier tiene mejor mano que tu, la proxima vez será");
			return 0;
		}
		
	}
	
	
	
}
