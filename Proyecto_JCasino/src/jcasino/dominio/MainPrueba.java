package jcasino.dominio;

public class MainPrueba {
	
	public static void main(String[] args) {
		
		//Creamos un jugador de prueba y le añadimos saldo
		Jugador jugador1 = new Jugador("Jugador1", "Iker", "Sasia", 22, "Masculino", "600123456", "ikerS@gmail.com", "1234");
		jugador1.recargarSaldo(200);
		System.out.println("Saldo inicial de "+jugador1.getNombre()+ " es: "+jugador1.getSaldo()+"€");
		System.out.println("--------------------------------");
		System.out.println();
		
		//Hacemos la Slot
		Slot pruebaSlot = new Slot("Slot Prueba", 2.0);
		
		for(int i = 1; i <= 5; i++){
			System.out.println("--- TIRADA "+i+" ---");
			pruebaSlot.jugar(2.0, jugador1);
			System.out.println("Saldo actual: "+jugador1.getSaldo()+"€");
			System.out.println();
		}
	}

}
