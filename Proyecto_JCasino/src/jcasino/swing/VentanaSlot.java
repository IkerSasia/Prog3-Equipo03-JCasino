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

public class VentanaSlot extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public VentanaSlot () {
		
		setTitle("ICasino - Slot / Tragaperras");
		setSize(450, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Color colorFondo = new Color(46, 139, 87);
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
		
		JLabel labelRodillos = new JLabel("[1], [1], [1]", JLabel.CENTER);
		labelRodillos.setFont(fuenteSlot);
		labelRodillos.setForeground(Color.YELLOW);
		labelRodillos.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 80), 2));
		
		panelCentro.add(labelRodillos, BorderLayout.CENTER);
		add(panelCentro, BorderLayout.CENTER);
		
		//PANEL INFERIOR - BOTON DE GIRAR Y BOTON DE VOLVER
		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(colorFondo);
		panelInferior.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		
		JButton botonGirar = new JButton("Girar Slot");
		JButton botonVolver = new JButton("Volver al Menú");
		
		botonGirar.setBackground(colorBotonAccion);
		botonGirar.setForeground(colorTexto);
		botonGirar.setFont(fuenteBotones);
		botonGirar.setFocusPainted(false);

		botonVolver.setBackground(colorBotonRojo);
		botonVolver.setForeground(colorTexto);
		botonVolver.setFont(fuenteBotones);
		botonVolver.setFocusPainted(false);
		
		panelInferior.add(botonGirar);
		panelInferior.add(botonVolver);
		
		add(panelInferior, BorderLayout.SOUTH);
		
		
		// ACCIONES DE LOS BOTONES
		
		botonVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaMenuJuegos menu = new VentanaMenuJuegos();
				menu.setVisible(true);
				
			}
		} );
		
		
		
		
		
		
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new VentanaSlot();
	}

}
