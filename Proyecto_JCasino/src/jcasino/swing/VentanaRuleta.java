package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

public class VentanaRuleta extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public VentanaRuleta() {
		setTitle("JCasino - Ruleta");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		
		// Personalización de la ventana
		Color colorFondo = new Color(30, 30, 30);
		Color colorTexto = Color.WHITE;
		Font fuenteNormal = new Font("Segoe UI", Font.BOLD, 14);
		
		setLayout(new BorderLayout()); // Creamos el borderLayout
		getContentPane().setBackground(colorFondo); // Poner el color de arriba del marco de la ventana del mismo color que el fondo
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new VentanaRuleta();

	}

}
