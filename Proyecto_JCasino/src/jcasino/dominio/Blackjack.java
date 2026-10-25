package jcasino.dominio;

import java.util.Random;

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
		
		//Asignamos las cartas al Crupier y al Jugador
		int puntosJugador = sacarCarta() + sacarCarta();
		int puntosCrupier = sacarCarta() + sacarCarta();
		
		System.out.println("Tus cartas suman: "+puntosJugador);
		System.out.println("Las cartas del crupies suman: "+puntosCrupier);
		
		
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
