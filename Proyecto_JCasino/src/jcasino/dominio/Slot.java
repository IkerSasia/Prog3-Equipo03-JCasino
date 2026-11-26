package jcasino.dominio;

import java.util.Random;

public class Slot extends Juego {

	private Random tirada;
	private int ranura1;
	private int ranura2;
	private int ranura3;
	
	public Slot(String nombre, double apuestaMinima) {
		super(nombre, apuestaMinima);
		this.tirada = new Random();
		this.ranura1 = 1;
		this.ranura2 = 2;
		this.ranura3 = 3;
	}

	public int getRanura1() {
		return ranura1;
	}

	public int getRanura2() {
		return ranura2;
	}

	public int getRanura3() {
		return ranura3;
	}

	public boolean esJackpot() {
		return ranura1 == 7 && ranura2 == 7 && ranura3 == 7;
	}

	
	//--------------------------------------------------------------//
	//					FUNCIONAMIENTO DEL JUEGO					//
	//--------------------------------------------------------------//

	//Llamamos al método Jugar y añadimos la funcionalidad de la Slot dentro
	@Override
	public double jugar(double cantidadApostada, Jugador jugador) {
		
		//Comprobamos que el saldo del Jugador llegue a la apuesta mínima
		if (cantidadApostada < getApuestaMinima()) {
			throw new IllegalArgumentException("Apuesta rechazada: la apuesta mínima es de " + getApuestaMinima() + " €.");
		}
		
		//Cobramos el saldo de la apuesta
		if (!jugador.retirarSaldo(cantidadApostada)) {
			throw new IllegalStateException("Apuesta rechazada: saldo insuficiente.");
		}
		
		//Colocamos el valor aleatorio a las 3 ranuras de la Slot
		ranura1 = tirada.nextInt(7) + 1;
		ranura2 = tirada.nextInt(7) + 1;
		ranura3 = tirada.nextInt(7) + 1;
		
		//Si sale el Premio Grande
		if (esJackpot()) {
			double premio = cantidadApostada * 50;
			jugador.recargarSaldo(premio);
			return premio;
		}
		//Si sale cualquier otra combianción
		else if (ranura1 == ranura2 && ranura2 == ranura3){
			double premio = cantidadApostada * 10;
			jugador.recargarSaldo(premio);
			return premio;
		}
		//Cualquier otra cosa, pierdes
		return 0;
	}
	
	
}
