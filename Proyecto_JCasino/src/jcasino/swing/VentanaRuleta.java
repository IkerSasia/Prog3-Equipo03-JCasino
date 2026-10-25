package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
		
		// ---ZONA SUPERIOR: MARCADOR DEL NUMERO---
		JPanel panelMarcador = new JPanel();
		panelMarcador.setBackground(colorFondo);
		panelMarcador.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
		
		// Etiqueta para el numero ganador
		JLabel labelNumeroGanador = new JLabel("?");
		labelNumeroGanador.setFont(new Font("Segoe UI", Font.BOLD, 80));
		labelNumeroGanador.setForeground(Color.WHITE);
		labelNumeroGanador.setOpaque(true); // Lo ponemos para que el fondo del texto se pinte7
		labelNumeroGanador.setBackground(Color.GRAY);
		labelNumeroGanador.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumeroGanador.setPreferredSize(new Dimension(150, 150)); // Hacemos un cuadrado grande para mostrar el numero
		
		panelMarcador.add(labelNumeroGanador);
		
		add(panelMarcador, BorderLayout.NORTH);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new VentanaRuleta();

	}

}
