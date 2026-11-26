package jcasino.dominio;

import java.util.Random;

public class Ruleta extends Juego{

	private Random giro;
	private String colorApostado;
	private int numeroGanador;
	
	public Ruleta(String nombre, double apuestaMinima) {
		super(nombre, apuestaMinima);
		this.giro = new Random();
		this.colorApostado = "";
		this.numeroGanador = -1;
	}
	

	public String getColorApostado() {
		return colorApostado;
	}
	public void setColorApostado(String colorApostado) {
		this.colorApostado = colorApostado;
	}

	public int getNumeroGanador() {
		return numeroGanador;
	}
	
	public String getColorGanador() {
		if(numeroGanador == 0) {
			return "VERDE";
		}else if (numeroGanador % 2 == 0) {
			return "ROJO";
		}else {
			return "NEGRO";
		}
	}


	//--------------------------------------------------------------//
	//					FUNCIONAMIENTO DEL JUEGO					//
	//--------------------------------------------------------------//

	//Llamamos al método Jugar y añadimos la funcionalidad de la Ruleta dentro
	@Override
	public double jugar(double cantidadApostada, Jugador jugador) {	
		
		//Comprobar si hay algún color elegido
		if(colorApostado == null || colorApostado.isEmpty()) {
			throw new IllegalStateException("Debes elegir un color antes de girar");
		}
		
		//Comprobamos que el saldo del Jugador llegue a la apuesta mínima
		if (cantidadApostada < getApuestaMinima()) {
			throw new IllegalArgumentException("Apuesta rechazada: la apuesta mínima es de "+getApuestaMinima()+"€");
		}
		
		//Cobramos el saldo de la apuesta
		if (!jugador.retirarSaldo(cantidadApostada)) {
			throw new IllegalStateException("Apuesta rechazada: saldo insuficiente");
		}
		
		numeroGanador = giro.nextInt(37);
		String colorGanador = getColorGanador();
		
		if (colorGanador.equals(colorApostado)) {
			double premio;
			if(colorGanador.equals("VERDE")){
				premio = cantidadApostada * 36;
			}else {
				premio = cantidadApostada * 2;
			}
			jugador.recargarSaldo(premio);
			return premio;
		}
		return 0;
	}
	
	
}
