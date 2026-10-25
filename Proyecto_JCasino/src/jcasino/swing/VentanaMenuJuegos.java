package jcasino.swing;

import javax.swing.JButton;
import javax.swing.JFrame;

public class VentanaMenuJuegos extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public VentanaMenuJuegos () {
		setTitle("Menu Principal");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		
		JButton botonBlackJack = new JButton("BlackJack");
		JButton botonRuleta = new JButton("Ruleta");
		JButton botonSlots = new JButton("Slot");
		JButton botonCerrarSesion = new JButton("Cerrar Sesion");
		
		
		
		
	}

	
	public static void main(String[] args) {
		new VentanaMenuJuegos();
	}
		
}
