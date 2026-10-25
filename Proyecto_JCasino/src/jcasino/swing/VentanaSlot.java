package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaSlot extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public VentanaSlot () {
		
		setTitle("ICasino - Slot / Tragaperras");
		setSize(450, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Color colorFondo = new Color(30, 30, 30);
		Color colorTexto = Color.WHITE;
		Color colorBoton = new Color(50, 50, 50);
		Color colorBotonAccion = new Color(40, 120, 80); // Verde para girar
		Color colorBotonRojo = new Color(180, 50, 50); // Para volver
		Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 16);
		Font fuenteSlot = new Font("Segoe UI", Font.BOLD, 22);
		Font fuenteBotones = new Font("Segoe UI", Font.PLAIN, 14);
		
		// PANEL SUPERIOR - TITULO:
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(colorFondo);
		panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		
		JLabel labelTitulo = new JLabel("Tragaperras (Slot)");
		labelTitulo.setFont(fuenteTitulo);
		labelTitulo.setForeground(colorTexto);
		panelSuperior.add(labelTitulo);
		
		add(panelSuperior, BorderLayout.NORTH);
		
		//PANEL CENTRAL - RODILLOS 
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(colorFondo);
		panelCentro.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));
		panelCentro.setLayout(new BorderLayout());
		
		
	}
	public static void main(String[] args) {
		new VentanaSlot();
	}

}
