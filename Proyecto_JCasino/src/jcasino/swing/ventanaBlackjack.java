package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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
				
		JButton botonJugar = new JButton("Jugar");
		botonJugar.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonJugar.setBackground(Color.yellow);
		botonJugar.setForeground(Color.black);
		botonJugar.setFocusable(false);
		
		JButton botonPedir = new JButton("Pedir carta");
		botonPedir.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonPedir.setBackground(Color.blue);
		botonPedir.setForeground(Color.white);
		botonPedir.setFocusable(false);
		
		JButton botonSalir = new JButton("Salir");
		botonSalir.setFont(new Font("Segoe UI", Font.BOLD, 16));
		botonSalir.setBackground(Color.red);
		botonSalir.setForeground(Color.white);
		botonSalir.setFocusable(false);
				
		panelBotones.add(botonJugar);
		panelBotones.add(botonPedir);
		panelBotones.add(botonSalir);
				
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
