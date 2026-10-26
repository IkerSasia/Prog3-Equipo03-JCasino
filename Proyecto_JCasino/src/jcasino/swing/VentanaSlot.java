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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		
		//Sub-panel para introducir la cantidad de apuesta
		
		JPanel panelApuesta = new  JPanel();
		panelApuesta.setBackground(colorFondo);
		JLabel labelApuesta = new JLabel("Cantidad a apostar (€):");
		labelApuesta.setForeground(colorTexto);
		labelApuesta.setFont(fuenteBotones);
		
		//Creamos un jttext para introducir la cantidad de apuesta deseada
		JTextField txtApuesta = new JTextField("10.0", 6);
		txtApuesta.setFont(fuenteBotones);
		
		//Añadimos todo al panel
		panelApuesta.add(labelApuesta);
		panelApuesta.add(txtApuesta);
		panelCentro.add(panelApuesta, BorderLayout.NORTH);
		
	
		
		//PANEL INFERIOR - BOTON DE GIRAR Y BOTON DE VOLVER
		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(colorFondo);
		panelInferior.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		
		JButton botonGirar = new JButton("Girar Slot");
		JButton botonVolver = new JButton("Volver al Menú");
		
		//Aplicamos el mismo diseño de colores a los botones
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
		
		botonVolver.addActionListener(new ActionListener() { // el boton "volver" vuelve a la ventana de menu de juegos
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaMenuJuegos menu = new VentanaMenuJuegos();
				menu.setVisible(true);
				
			}
		} );
		
		//Programamos la funcionalidad del boton Girar
		
		botonGirar.addActionListener(new ActionListener() {
			
			@Override
			//Colocamos el valor aleatorio a las 3 ranuras de la Slot
			public void actionPerformed(ActionEvent e) {
				Random tirada = new Random();
				int ranura1 = tirada.nextInt(7) + 1;
				int ranura2 = tirada.nextInt(7) + 1;
				int ranura3 = tirada.nextInt(7) + 1;
				
				// Mostrar el resultado en la interfaz
				labelRodillos.setText(("[ " + ranura1 + " ] - [ " + ranura2 + " ] - [ " + ranura3 + " ]"));
				
				// Comprobaciones del premio igual que en la clase Slot
				if (ranura1 == 7 && ranura2 == 7 && ranura3 == 7) {
					JOptionPane.showMessageDialog(VentanaSlot.this, "¡JACKPOT! Has ganado el premio gordo.");
				} else if (ranura1 == ranura2 && ranura2 == ranura3) {
					JOptionPane.showMessageDialog(VentanaSlot.this, "¡Has ganado una combinación!");
				}
				
			}
			
		});
	
		
		
		
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new VentanaSlot();
	}

}
