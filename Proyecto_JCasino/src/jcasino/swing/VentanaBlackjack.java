package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import jcasino.dominio.Blackjack;
import jcasino.dominio.Casino;
import jcasino.dominio.Jugador;

public class VentanaBlackjack extends JFrame{

	private static final long serialVersionUID = 1L;
	private Blackjack blackjack;
		
	public VentanaBlackjack(Casino casino, Jugador jugador){
		this.blackjack = casino.getBlackjack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setSize(650, 500);
		setLocationRelativeTo(null);
		setTitle("Mesa de Blackjack");
		
		Color colorFondo = new Color(40, 120, 80);
		Color colorBotones = new Color(70, 70, 70);
		Font fuenteBotones = new Font("Segoe UI", Font.BOLD, 14);
		Font fuenteZona = new Font("Segoe UI", Font.BOLD, 18);
		
		//Panel Principal: Ocupa toda la ventana y nos da los márgenes
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(0, 10));
		panelPrincipal.setBackground(colorFondo);
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 35, 15, 35)); 
			
		//Panel SUuperior: saldo actual del jugador
		JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
		panelSuperior.setBackground(colorFondo);
		
		JLabel labelTitulo = new JLabel("BLACKJACK");
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		JLabel labelSaldo = new JLabel("Saldo actual: "+ jugador.getSaldo());
		labelSaldo.setForeground(Color.YELLOW);
		labelSaldo.setFont(fuenteBotones);
		
		panelSuperior.add(labelTitulo);
		panelSuperior.add(labelSaldo);
		panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		
		//Panel del Juego: zona para el crupier, el jugador y las cartas
		JPanel panelJuego = new JPanel();
		panelJuego.setLayout(new BorderLayout());
		panelJuego.setBackground(colorFondo);
		panelJuego.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); 
		
		
		//Zona del Crupier
		JPanel panelCrupier = new JPanel();
		panelCrupier.setBackground(colorFondo);
		
		JLabel labelCrupier = new JLabel("CRUPIER", SwingConstants.CENTER);
		labelCrupier.setForeground(Color.WHITE);
		labelCrupier.setFont(fuenteZona);
		labelCrupier.setBorder(BorderFactory.createEmptyBorder(8, 0, 5, 0));
		
		JPanel panelCartasCrupier = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		panelCartasCrupier.setBackground(colorFondo);
		panelCartasCrupier.setPreferredSize(new Dimension(550, 110));
		
		panelCrupier.add(labelCrupier, BorderLayout.NORTH);
		panelCrupier.add(panelCartasCrupier, BorderLayout.CENTER);
		panelJuego.add(labelCrupier, BorderLayout.NORTH);
		
		
		//Zona central para los mensajes de la partida
		JLabel labelCentral = new JLabel("ZONA DE JUEGO", SwingConstants.CENTER);
		labelCentral.setForeground(Color.YELLOW);
		labelCentral.setFont(new Font("Segoe UI", Font.BOLD, 20));
		panelJuego.add(labelCentral, BorderLayout.CENTER);
			
		
		//Zona para el Jugador
		JPanel panelJugador = new JPanel(new BorderLayout());
		panelJugador.setBackground(colorFondo);
		
		JLabel labelJugador = new JLabel("JUGADOR", SwingConstants.CENTER);
		labelJugador.setForeground(Color.WHITE);
		labelJugador.setFont(fuenteZona);
		labelJugador.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		
		JPanel panelCartasJugador = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		panelCartasJugador.setBackground(colorFondo);
		panelCartasJugador.setPreferredSize(new Dimension(550, 110));
		
		panelJugador.add(labelJugador, BorderLayout.NORTH);
		panelJugador.add(panelCartasJugador, BorderLayout.CENTER);
		panelJuego.add(panelJugador, BorderLayout.SOUTH);

		panelPrincipal.add(panelJuego, BorderLayout.CENTER);
				
		// Panel de abajo, para los botones
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(colorFondo);
		panelBotones.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0)); // Margén con la parte de arriba
				
		JButton botonJugar = new JButton("JUGAR");
		botonJugar.setFont(fuenteBotones);
		botonJugar.setBackground(colorBotones);
		botonJugar.setForeground(Color.WHITE);
		botonJugar.setFocusPainted(false);
		
		JButton botonPlantarse = new JButton("PLANTARSE");
		botonPlantarse.setFont(fuenteBotones);
		botonPlantarse.setBackground(colorBotones);
		botonPlantarse.setForeground(Color.WHITE);
		botonPlantarse.setFocusPainted(false);
		
		JButton botonPedir = new JButton("PEDIR CARTA");
		botonPedir.setFont(fuenteBotones);
		botonPedir.setBackground(colorBotones);
		botonPedir.setForeground(Color.WHITE);
		botonPedir.setFocusPainted(false);
		
		JButton botonSalir = new JButton("SALIR");
		botonSalir.setFont(fuenteBotones);
		botonSalir.setBackground(new Color(180, 50, 50));
		botonSalir.setForeground(Color.white);
		botonSalir.setFocusPainted(false);
				
		panelBotones.add(botonJugar);
		panelBotones.add(botonPlantarse);
		panelBotones.add(botonPedir);
		panelBotones.add(botonSalir);
		
		// Añadimos los botones a la parte sur del panel principal
		panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
		
		
		//Desactivamos los botones de Pedir y Plantarse hasta que empiece la ronda
		botonPedir.setEnabled(false);
		botonPlantarse.setEnabled(false);
		
		
		//Acción para el botón Jugar
		botonJugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String entrada = JOptionPane.showInputDialog(
						VentanaBlackjack.this,
						"Introduce tu apuesta (mínimo " + blackjack.getApuestaMinima()
								+ " € | Saldo: " + jugador.getSaldo() + " €):"
				);

				if(entrada == null) {
					return;
				}

				try {
					double apuesta = Double.parseDouble(entrada.trim());
					blackjack.jugar(apuesta, jugador);

					labelJugador.setText("JUGADOR: " + blackjack.getPuntosJugador());
					labelCrupier.setText("CRUPIER: " + blackjack.getPuntosCrupier());

					if(!blackjack.isRondaActiva()) {
						labelCentral.setText(blackjack.getResultado());
						botonJugar.setEnabled(true);
						botonPedir.setEnabled(false);
						botonPlantarse.setEnabled(false);
					} else {
						labelCentral.setText("¿Pides carta o te plantas?");
						botonJugar.setEnabled(false);
						botonPedir.setEnabled(true);
						botonPlantarse.setEnabled(true);
					}
					
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(VentanaBlackjack.this, "Introduce una cantidad válida.");
				} catch (IllegalArgumentException | IllegalStateException e2) {
					JOptionPane.showMessageDialog(VentanaBlackjack.this, e2.getMessage());
				}		
			}
		});
			
		//Acción para el botón Pedir Carta
		botonPedir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				blackjack.pedirCarta();
				labelJugador.setText("JUGADOR: " + blackjack.getPuntosJugador());
				
				if(!blackjack.isRondaActiva()) {
					labelCentral.setText(blackjack.getResultado());
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
				
				blackjack.plantarse(jugador);
				labelCrupier.setText("CRUPIER: "+blackjack.getPuntosCrupier());
				labelCentral.setText(blackjack.getResultado());
				
				botonJugar.setEnabled(true);
			}
		});
		
		// Añadimos la acción de volver al menú al botón de salir
		botonSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaMenuJuegos(casino, jugador);
				dispose();
			}
		});		
		
				
		// Finalmente, añadimos el panel principal a la ventana
		add(panelPrincipal);
		

		
		setVisible(true);
	}	
}
