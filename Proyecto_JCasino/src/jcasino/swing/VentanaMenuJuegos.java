package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jcasino.dominio.Casino;
import jcasino.dominio.Jugador;

public class VentanaMenuJuegos extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//Para abrir el menu con un jugador que ya tenemos
	public VentanaMenuJuegos (Casino casino, Jugador jugador) {		
		setTitle("JCasino - Menu Principal");
		setSize(1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		
		//Colores y fuentes para la misma estetica de la ventana Inicio Sesion
		Color colorFondo = new Color(30, 30, 30);
		Color colorTexto = Color.WHITE;
		Color colorBoton = new Color(50, 50, 50);
		Color colorBotonRojo = new Color(180, 50, 50); // Para cerrar sesión
		Color colorBotonSaldo = new Color(40, 120, 80);
		Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 16);
		Font fuenteBotones = new Font("Segoe UI", Font.PLAIN, 14);
		
		//Panel superior con un titulo de bienvenida
		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setBackground(colorFondo);
		JLabel labelTitulo = new JLabel("Menú Principal");
		labelTitulo.setFont(fuenteTitulo);
		labelTitulo.setForeground(colorTexto);
		panelBienvenida.add(labelTitulo);
		setLayout(new BorderLayout(10,10)); // Configuramos el layout general de la ventana
		add(panelBienvenida, BorderLayout.NORTH);
		
		
		//Botones para cada juego, Saldo y Cerrar Sesion
		JButton botonBlackJack = new JButton("BlackJack");
		JButton botonRuleta = new JButton("Ruleta");
		JButton botonSlots = new JButton("Slot");
		JButton botonSaldo = new JButton("Gestión de Saldo");
		JButton botonCerrarSesion = new JButton("Cerrar Sesion");
		
		//Aplicamos el mismo estilo a los botones 
		botonBlackJack.setBackground(colorBoton);
		botonBlackJack.setForeground(colorTexto);
		botonBlackJack.setFont(fuenteBotones);
		botonBlackJack.setFocusPainted(false);
		
		botonRuleta.setBackground(colorBoton);
		botonRuleta.setForeground(colorTexto);
		botonRuleta.setFont(fuenteBotones);
		botonRuleta.setFocusPainted(false);
		
		botonSlots.setBackground(colorBoton);
		botonSlots.setForeground(colorTexto);
		botonSlots.setFont(fuenteBotones);
		botonSlots.setFocusPainted(false);
		
		botonSaldo.setBackground(colorBotonSaldo);
		botonSaldo.setForeground(colorTexto);
		botonSaldo.setFont(fuenteBotones);
		botonSaldo.setFocusPainted(false);
		
		botonCerrarSesion.setBackground(colorBotonRojo);
		
		
		//Creamos un panel para los juegos
		JPanel panelJuegos = new JPanel();
		panelJuegos.setLayout(new GridLayout(3,1,10,10));
		panelJuegos.setBackground(colorFondo);
		panelJuegos.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
		
		panelJuegos.add(botonBlackJack);
		panelJuegos.add(botonRuleta);
		panelJuegos.add(botonSlots);
		
		
		
		add(panelJuegos, BorderLayout.CENTER); // Añadir el panel de juegos al centro de la ventana
		
		//Panel para el boton de cerrar sesion
		JPanel panelCerrarSesion = new JPanel();
		panelCerrarSesion.setBackground(colorFondo);
		panelCerrarSesion.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		panelCerrarSesion.add(botonCerrarSesion);
		panelCerrarSesion.add(botonSaldo);
		add(panelCerrarSesion, BorderLayout.SOUTH);
		
		
		//Añadir acciones a los botones
		
		//BOTON BLACKJACK
		botonBlackJack.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaBlackjack(casino, jugador);
				dispose();
			}
		});
		
		//BOTON RULETA
		botonRuleta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaRuleta(casino, jugador);
				dispose();
			}
		});
		
		// BOTON SLOTS
		botonSlots.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaSlot(casino, jugador);
				dispose();
			}
		});
		
		//BOTON SALDO
		botonSaldo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaSaldo(casino, jugador);
				dispose();
			}
		});

		
		// Boton de cerrar sesion que vuelva a la ventana de inicio de sesion 
		botonCerrarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaInicioSesion(casino);
				dispose();
				
			}
		});
		setVisible(true);
		
	}
}
