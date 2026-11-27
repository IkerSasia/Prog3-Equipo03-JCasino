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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jcasino.dominio.Casino;
import jcasino.dominio.Jugador;
import jcasino.dominio.Slot;

public class VentanaSlot extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Slot slot;
	
	public VentanaSlot (Casino casino, Jugador jugador) {
		this.slot = casino.getSlot();
		
		setTitle("Slot");
		setSize(650, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Color colorFondo = new Color(40, 120, 80);
		Color colorTexto = Color.WHITE;
		Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 20);
		Font fuenteSlot = new Font("Segoe UI", Font.BOLD, 30);
		Font fuenteBotones = new Font("Segoe UI", Font.BOLD, 14);
		
		// PANEL SUPERIOR - TITULO:
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(colorFondo);
		panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		
		JLabel labelTitulo = new JLabel("SLOT");
		labelTitulo.setFont(fuenteTitulo);
		labelTitulo.setForeground(colorTexto);
		
		JLabel labelSaldo = new JLabel("Saldo actual: " + jugador.getSaldo() + " €", JLabel.CENTER);
		labelSaldo.setFont(fuenteBotones);
		labelSaldo.setForeground(Color.YELLOW);
		
		panelSuperior.add(labelTitulo);
		panelSuperior.add(labelSaldo);
		add(panelSuperior, BorderLayout.NORTH);
			
		
		//PANEL CENTRAL - RODILLOS 
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(colorFondo);
		panelCentro.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));
		panelCentro.setLayout(new BorderLayout());
		
		JLabel labelRodillos = new JLabel("[1] - [1] - [1]", JLabel.CENTER);
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
		
		//Creamos un jtext para introducir la cantidad de apuesta deseada
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
		
		JButton botonGirar = new JButton("GIRAR SLOT");
		JButton botonVolver = new JButton("VOLVER AL MENÚ");
		
		//Aplicamos el mismo diseño de colores a los botones
		botonGirar.setBackground(new Color(70, 70, 70));
		botonGirar.setForeground(colorTexto);
		botonGirar.setFont(fuenteBotones);
		botonGirar.setFocusPainted(false);

		botonVolver.setBackground(new Color(180, 50, 50));
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
				new VentanaMenuJuegos(casino, jugador);
				dispose();
			}
		} );
		
		//Programamos la funcionalidad del boton Girar
		
		botonGirar.addActionListener(new ActionListener() {
			
			@Override
			//Colocamos el valor aleatorio a las 3 ranuras de la Slot
			public void actionPerformed(ActionEvent e) {
				try {
					double apuesta = Double.parseDouble(txtApuesta.getText().trim());
					double premio = slot.jugar(apuesta, jugador);
					
					labelRodillos.setText(
							"[ " + slot.getRanura1() + " ] - [ " + slot.getRanura2() + " ] - [ " + slot.getRanura3() + " ]"
					);
					labelSaldo.setText("Saldo actual: " + jugador.getSaldo() + " €");
					
					if (slot.esJackpot()) {
						JOptionPane.showMessageDialog(VentanaSlot.this, "¡JACKPOT! Has ganado "+premio+"€");
					}else if(premio > 0) {
						JOptionPane.showMessageDialog(VentanaSlot.this, "¡PREMIO! Has ganado "+premio+"€");
					}
					
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(VentanaSlot.this, "Introduce una cantidad valida");
				} catch (IllegalArgumentException | IllegalStateException e2) {
					JOptionPane.showMessageDialog(VentanaSlot.this, e2.getMessage());
				}
				
			}
			
		});
		setVisible(true);
	}
}
