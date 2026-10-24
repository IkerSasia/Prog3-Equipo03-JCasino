package jcasino.dominio;

import java.util.Random;

public class Ruleta extends Juego{

	private Random giro;
	private int numeroApostado;
	
	public Ruleta(String nombre, double apuestaMinima) {
		super(nombre, apuestaMinima);
		this.giro = new Random();
		this.numeroApostado = -1;
	}
	
	public int getNumeroApostado() {
		return numeroApostado;
	}
	public void setNumeroApostado(int numeroApostado) {
		this.numeroApostado = numeroApostado;
	}



	//Llamamos al método Jugar y añadimos la funcionalidad de la Ruleta dentro
	@Override
	public double jugar(double cantidadApostada, Jugador jugador) {
		
		if(this.numeroApostado < 0 || this.numeroApostado > 36) {
			System.out.println("Apuesta Rechaza: Debes elegir un número entre el 0 y el 36");
			return 0;
		}
		
		if (cantidadApostada < getApuestaMinima()) {
			System.out.println("Apuesta Rechazada: Saldo insuficiente");
			return 0;
		}
		
		if (!jugador.retirarSaldo(cantidadApostada)) {
			System.out.println("Apuesta Rechazada. Saldo insuficiente");
			return 0;
		}
		
		//Generar número Aleatorio entre el 0 y el 36
		int numeroGanador = giro.nextInt(37);
		System.out.println("La ruleta gira... Y saca el número: "+numeroGanador+"!");
		
		//Comprobamos el premio
		if (numeroGanador == numeroApostado) {
			double premio = cantidadApostada * 36;
			jugador.recargarSaldo(premio);
			System.out.println("¡PREMIO GORDO!");
			System.out.println("Has ganado la friolera de: "+premio+"€");
			return premio;
		}else {
			System.out.println("Mala suerte, a la siguiente será");
			return 0;
		}

	}
	
	
}
