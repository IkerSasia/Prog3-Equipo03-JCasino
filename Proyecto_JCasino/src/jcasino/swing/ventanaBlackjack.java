package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ventanaBlackjack extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	private int puntosJugador = 0;
	private int puntosCrupier = 0;
	private Random cartas = new Random();
	
	// Generador de cartas del 1 al 11
	private int sacarCarta() {
		return cartas.nextInt(11) + 1;
	}
	
	
	public ventanaBlackjack(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setSize(640, 480);
		setLocationRelativeTo(null);
		setTitle("Mesa de Blackjack");
		
		Color colorFondo = new Color(46, 139, 87);
		
		
		//Panel Principal: Ocupa toda la ventana y nos da los márgenes
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		panelPrincipal.setBackground(colorFondo);
		// EmptyBorder(Arriba, Izquierda, Abajo, Derecha). Le damos 40px de margen lateral
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40)); 
			
		
		//Panel del Juego: zona para el crupier, el jugador y el las cartas
		JPanel panelJuego = new JPanel();
		panelJuego.setLayout(new BorderLayout());
		panelJuego.setBackground(colorFondo);
		// Le pintamos la línea negra alrededor a todo este bloque
		panelJuego.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); 
				
				
		//Zona del Crupier
		JLabel labelCrupier = new JLabel("CRUPIER", SwingConstants.CENTER);
		labelCrupier.setForeground(Color.WHITE);
		labelCrupier.setFont(new Font("Arial", Font.BOLD, 24));
		
		labelCrupier.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); //Margen para que no se pegue a la línea negra
		panelJuego.add(labelCrupier, BorderLayout.NORTH);
				
				
		//Zona para las cartas
		JLabel labelCentral = new JLabel("ZONA DE JUEGO", SwingConstants.CENTER);
		labelCentral.setForeground(Color.WHITE);
		labelCentral.setFont(new Font("Arial", Font.BOLD, 24));
		panelJuego.add(labelCentral, BorderLayout.CENTER);
				
				
		//Zona para el Jugador
		JLabel labelJugador = new JLabel("JUGADOR", SwingConstants.CENTER);
		labelJugador.setForeground(Color.WHITE);
		labelJugador.setFont(new Font("Arial", Font.BOLD, 24));
		
		labelJugador.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		panelJuego.add(labelJugador, BorderLayout.SOUTH);
				
				
		// Añadimos el crupier, el jugador y la zona de juego al centro de la interfaz
		panelPrincipal.add(panelJuego, BorderLayout.CENTER);
				
				
		// Panel de abajo, para los botones
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(colorFondo);
		panelBotones.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0)); // Margén con la parte de arriba
				
		JButton botonJugar = new JButton("JUGAR");
		botonJugar.setFont(new Font("Segoe UI", Font.BOLD, 16));

		botonJugar.setBackground(Color.yellow);
		botonJugar.setForeground(Color.black);

		botonJugar.setBackground(new Color(80, 80, 80));
		botonJugar.setForeground(Color.white);

		botonJugar.setFocusable(false);
		
		JButton botonPlantarse = new JButton("PLANTARSE");
		botonPlantarse.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonPlantarse.setBackground(new Color(80, 80, 80));
		botonPlantarse.setForeground(Color.white);
		botonPlantarse.setFocusable(false);
		
		JButton botonPedir = new JButton("PEDIR CARTA");
		botonPedir.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonPedir.setBackground(new Color(80, 80, 80));
		botonPedir.setForeground(Color.white);
		botonPedir.setFocusable(false);
		
		JButton botonSalir = new JButton("SALIR");
		botonSalir.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonSalir.setBackground(new Color(80, 80, 80));
		botonSalir.setForeground(Color.white);
		botonSalir.setFocusable(false);
				
		panelBotones.add(botonJugar);
		panelBotones.add(botonPlantarse);
		panelBotones.add(botonPedir);
		panelBotones.add(botonSalir);
		
		
		//Acción para el botón Jugar
		botonJugar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Reparto inicial
				puntosJugador = sacarCarta() + sacarCarta();
				puntosCrupier = sacarCarta() + sacarCarta();
				
				labelJugador.setText("JUGADOR: " + puntosJugador);
				labelCrupier.setText("CRUPIER: " + puntosCrupier);
				labelCentral.setText("¿Pides carta o te plantas?");
				
				botonJugar.setEnabled(false); // Bloqueamos el botón jugar
				botonPedir.setEnabled(true);  // Activamos los de acción
				botonPlantarse.setEnabled(true);
			}
		});
		
		
		//Acción para el botón Pedir Carta
		botonPedir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				puntosJugador += sacarCarta();
				labelJugador.setText("JUGADOR: " + puntosJugador);
				
				if(puntosJugador > 21) {
					labelCentral.setText("¡Te has pasado! Gana el crupier.");
					botonPedir.setEnabled(false);
					botonPlantarse.setEnabled(false);
					botonJugar.setEnabled(true); // Al pasarse de 21, la ronda acaba y le permitimos volver a jugar
				}
			}
		});
		
		//Acción para Plantarse
		botonPlantarse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				botonPedir.setEnabled(false);
				botonPlantarse.setEnabled(false);
				
				// Turno automático del crupier
				while (puntosCrupier < 17) {
					puntosCrupier += sacarCarta();
				}
				labelCrupier.setText("CRUPIER: " + puntosCrupier);
				
				// Comprobar ganador
				if(puntosCrupier > 21 || puntosJugador > puntosCrupier) {
					labelCentral.setText("¡Has ganado!");
				} else if (puntosJugador == puntosCrupier) {
					labelCentral.setText("Empate.");
				} else {
					labelCentral.setText("Gana el crupier.");
				}
				
				botonJugar.setEnabled(true); // Permitimos volver a jugar
			}
		});
		
		
		//Acción para el botón salir
        botonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaMenuJuegos().setVisible(true);
				dispose();
				
			}
		});
				
		// Añadimos los botones a la parte sur del panel principal
		panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
				
				
		// Finalmente, añadimos el panel principal a la ventana
		add(panelPrincipal);
		
		
		
		
		
		
		
		botonSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaMenuJuegos volver = new VentanaMenuJuegos();
				volver.setVisible(true);
				
			}
		});
		
		setVisible(true);
	}	

	
	public static void main(String[] args) {
		new ventanaBlackjack();
	}

}
