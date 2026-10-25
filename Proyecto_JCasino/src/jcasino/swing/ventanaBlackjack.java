package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ventanaBlackjack extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public ventanaBlackjack(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setSize(640, 480);
		setLocationRelativeTo(null);
		setTitle("Mesa de Blackjack");
		
		Color colorFondo = new Color(46, 139, 87);
		
		//Parte de arriba, zona del crupier
		JLabel labelCrupier = new JLabel("Crupier", SwingConstants.CENTER);
		labelCrupier.setOpaque(true);
		labelCrupier.setBackground(colorFondo);
		labelCrupier.setForeground(Color.WHITE);
		labelCrupier.setFont(new Font("Arial", Font.BOLD, 24));
		add(labelCrupier, BorderLayout.NORTH);
		
		//Parte Central, zona del juego
		JLabel labelCentral = new JLabel("Mesa de juego", SwingConstants.CENTER);
		labelCentral.setOpaque(true);
		labelCentral.setBackground(colorFondo);
		labelCentral.setForeground(Color.WHITE);
		labelCentral.setFont(new Font("Arial", Font.BOLD, 24));
		add(labelCentral, BorderLayout.CENTER);
		
		
		
		//Parte de abajo
		JPanel panelSur = new JPanel();
		panelSur.setLayout(new BorderLayout());
		
		//Parte de abajo, zona del jugador
		JLabel labelJugador = new JLabel("Jugador", SwingConstants.CENTER);
		labelJugador.setOpaque(true);
		labelJugador.setBackground(colorFondo);
		labelJugador.setForeground(Color.WHITE);
		labelJugador.setFont(new Font("Arial", Font.BOLD, 24));
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(colorFondo);
		
		JButton botonJugar = new JButton("Jugar");
		JButton botonPedir = new JButton("Pedir carta");
		JButton botonSalir = new JButton("Salir");
		
		panelBotones.add(botonJugar);
		panelBotones.add(botonPedir);
		panelBotones.add(botonSalir);
		
		panelSur.add(labelJugador, BorderLayout.CENTER);
		panelSur.add(panelBotones, BorderLayout.SOUTH);
		
		add(panelSur, BorderLayout.SOUTH);
		
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ventanaBlackjack();
	}

}
