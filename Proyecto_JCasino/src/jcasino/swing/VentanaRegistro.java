package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

public class VentanaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public VentanaRegistro() {
		setTitle("JCasino - Registro de Usuario");
		setSize(450, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Personalización de la ventana
		Color colorFondo = new Color(30, 30, 30);
		Color colorTexto = Color.WHITE;
		Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 14);
		Font fuenteCajas = new Font("Segoe UI", Font.PLAIN, 14);
		
		setLayout(new BorderLayout());
		
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
