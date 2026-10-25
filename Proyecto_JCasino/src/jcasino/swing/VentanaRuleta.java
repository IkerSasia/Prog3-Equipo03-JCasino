package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class VentanaRuleta extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public VentanaRuleta() {
		setTitle("JCasino - Ruleta");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		
		// Personalización de la ventana
		Color colorFondo = new Color(46, 139, 87);
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
		
		
		// ---ZONA CENTRAL: PANEL DE APUESTAS---
		JPanel panelApuestas = new JPanel();
		panelApuestas.setLayout(new BoxLayout(panelApuestas, BoxLayout.Y_AXIS));
		panelApuestas.setBackground(colorFondo);
		
		// Creamos un borde para el titulo con la zona de apuestas 
		TitledBorder bordeApuestas = BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.black), "Tu Apuesta");
		bordeApuestas.setTitleColor(Color.LIGHT_GRAY);
		bordeApuestas.setTitleFont(new Font("Segoe UI", Font.BOLD, 14));
		bordeApuestas.setTitleJustification(TitledBorder.CENTER); // Centramos el borde
		
		panelApuestas.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(10, 40, 10, 40), // Margen Exterior
				bordeApuestas));  // Margen interior con el titulo
		
		
		// Fila 1: Cantidad a apostar 
		JPanel panelCantidad = new JPanel(new FlowLayout());
		panelCantidad.setBackground(colorFondo);
		JLabel labelCantidad = new JLabel("Cantidad (€):");
		labelCantidad.setForeground(colorTexto);
		labelCantidad.setFont(fuenteNormal);
		JTextField txtCantidad = new JTextField(10); // Ancho de columna de 10
		
		panelCantidad.add(labelCantidad);
		panelCantidad.add(txtCantidad);
		
		
		// Fila 2: Botones de seleccion de color
		JPanel panelBotonesApuesta = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotonesApuesta.setBackground(colorFondo);
        
        // Boton rojo
        JButton botonApostarRojo = new JButton("ROJO");
        botonApostarRojo.setBackground(new Color(220, 20, 60)); // color rojo
        botonApostarRojo.setForeground(Color.WHITE);
        botonApostarRojo.setFocusable(false);
        botonApostarRojo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Boton negro
        JButton botonApostarNegro = new JButton("NEGRO");
        botonApostarNegro.setBackground(Color.BLACK);
        botonApostarNegro.setForeground(Color.WHITE);
        botonApostarNegro.setFocusable(false);
        botonApostarNegro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Boton Verde
        JButton botonApostarVerde = new JButton("VERDE (0)");
        botonApostarVerde.setBackground(new Color(0, 100, 0)); // Un verde más oscuro que el fondo
        botonApostarVerde.setForeground(Color.WHITE);
        botonApostarVerde.setFocusable(false);
        botonApostarVerde.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        panelBotonesApuesta.add(botonApostarRojo);
        panelBotonesApuesta.add(botonApostarNegro);
        panelBotonesApuesta.add(botonApostarVerde);
        
        panelApuestas.add(panelCantidad);
        panelApuestas.add(panelBotonesApuesta);
        
        // ---ZONA INFERIOR: BOTONES DE ACCIÓN---
        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        panelSur.setBackground(colorFondo);
        
        JButton botonVolver = new JButton("SALIR");
        botonVolver.setFont(new Font("Segoe UI", Font.BOLD, 16));
        botonVolver.setBackground(new Color(80, 80, 80));
        botonVolver.setForeground(Color.WHITE);
        botonVolver.setFocusable(false);
        botonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JButton botonGirar = new JButton("GIRAR RULETA");
        botonGirar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        botonGirar.setBackground(new Color(80, 80, 80)); 
        botonGirar.setForeground(Color.WHITE);
        botonGirar.setFocusable(false);
        botonGirar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // ACCION DEL BOTON VOLVER
        botonVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaMenuJuegos().setVisible(true);
				dispose();
				
			}
		});
        
        // ACCION DEL BOTON GIRAR
        botonGirar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random numRandom = new Random();
				int numero = numRandom.nextInt(37); // Genera un numero random del 0 al 36
				
				labelNumeroGanador.setText(String.valueOf(numero)); // Ponemos en el cuadrado el numero
				
				// Cambiar el color del marcador segun el numero
				
				if (numero == 0) {
					labelNumeroGanador.setBackground(new Color(46, 139, 87)); // Si toca el 0, es verde
				}
				else if (numero % 2 == 0) {
					labelNumeroGanador.setBackground(Color.RED); // Si toca par, es rojo 
				}
				else {
					labelNumeroGanador.setBackground(Color.BLACK); // El resto de numeros son negro
				}
				
			}
		});
        
        panelSur.add(botonVolver);
        panelSur.add(botonGirar);
        
        
		// Añadimos todo a la ventana principal
		add(panelMarcador, BorderLayout.NORTH);
		add(panelApuestas, BorderLayout.CENTER);
		add(panelSur, BorderLayout.SOUTH);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new VentanaRuleta();

	}

}
