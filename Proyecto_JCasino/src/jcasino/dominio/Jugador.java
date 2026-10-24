package jcasino.dominio;

public class Jugador extends Usuario{

	private double saldo;
	
	public Jugador(String nombreUsuario, String nombre, String apellidos, int edad, String genero, String telefono,
			String correo, String contrasenna, double saldoActual) {
		super(nombreUsuario, nombre, apellidos, edad, genero, telefono, correo, contrasenna, saldoActual);
		
	}
	
	@Override
	public String toString() {
		return "Jugador [saldo=" + saldo + "]";
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	// ---MÉTODOS PARA GESTIONAR EL SALDO---

	// Método para recargar saldo ficticio
	public void recargarSaldo(double cantidad) {
		if (cantidad > 0) {
			this.saldo += cantidad;
		}
	}
	
	// Método para retirar saldo
		public boolean retirarSaldo(double cantidad) {
			if (cantidad > 0 && this.saldo >= cantidad) { // La segunda condición hace que no se pueda quedar en negativo
				this.saldo -= cantidad;
				
				return true; // Transacción completada
			}
			return false; // Transacción rechazada si la cantidad solicitada supera el saldo actual
		}
	
}
