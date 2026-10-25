package jcasino.dominio;

import java.util.Random;

public class Slot extends Juego {

	private Random tirada;
	
	public Slot(String nombre, double apuestaMinima) {
		super(nombre, apuestaMinima);
		this.tirada = new Random();
	}

	//Llamamos al método Jugar y añadimos la funcionalidad de la Slot dentro
	@Override
	public double jugar(double cantidadApostada, Jugador jugador) {
		
		//Comprobamos que el saldo del Jugador llegue a la apuesta mínima
		if (cantidadApostada < getApuestaMinima()) {
			System.out.println("Apuesta Rechazada: No dispone del saldo suficiente");
			return 0;
		}
		
		//Cobramos el saldo de la apuesta
		if (!jugador.retirarSaldo(cantidadApostada)) {
			System.out.println("Apuesta Rechazada: Saldo insuficiente");
			return 0;
		}
		
		//Colocamos el valor aleatorio a las 3 ranuras de la Slot
		int ranura1 = tirada.nextInt(7) + 1;
		int ranura2 = tirada.nextInt(7) + 1;
		int ranura3 = tirada.nextInt(7) + 1;
		
		//Mostramos el resultado de la tirada en la consola
		System.out.println("Tirada: ["+ranura1+"]-["+ranura2+"]-["+ranura3+"]");
		
		//Si sale el Premio Grande
		if (ranura1 == 7 && ranura2 == 7 && ranura3 == 7) {
			double premio = cantidadApostada * 50;
			jugador.recargarSaldo(premio);
			System.out.println("¡JACKPOT!");
			System.out.println("Has ganado: "+premio+"€");
			return premio;
		}
		//Si sale cualquier otra combianción
		else if (ranura1 == ranura2 && ranura2 == ranura3){
			double premio = cantidadApostada * 10;
			jugador.recargarSaldo(premio);
			System.out.println("Has ganado: "+premio+"€");
			return premio;
		}
		//Cualquier otra cosa, pierdes
		else {
			System.out.println("Mala suerte, la siguiente tirada será");
			return 0;
		}
	}
	
	
}
