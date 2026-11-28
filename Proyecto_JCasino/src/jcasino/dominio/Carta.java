package jcasino.dominio;

public class Carta {
	
	private String valor;
	private String palo;
	
	public Carta(String valor, String palo) {
		this.valor = valor;
		this.palo = palo;
	}

	public String getValor() {
		return valor;
	}
	
	public String getPalo() {
		return palo;
	}

	
	//Asignamos valores a las cartas con letras
	public int getPuntos() {
		if(valor.equals("A")) {
			return 11;
		}else if(valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
			return 10;
		}else {
			return Integer.parseInt(valor);
		}
	}

}
