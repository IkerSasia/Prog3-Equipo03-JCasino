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
import jcasino.dominio.Jugador;

public class VentanaSaldo extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public VentanaSaldo(Jugador jugador) {
		setTitle("Gestión de saldo");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		Color colorFondo = new Color(30, 30, 30);
		Color colorBoton = new Color(40, 120, 80);
		
		getContentPane().setBackground(colorFondo);
		
		JPanel panelSaldo = new JPanel();
		panelSaldo.setBackground(colorFondo);
		panelSaldo.setBorder(
				BorderFactory.createEmptyBorder(30, 0, 0, 0)
		);
		
		JLabel labelSaldo = new JLabel("Saldo actual: " + jugador.getSaldo() +  " €");
		labelSaldo.setForeground(Color.WHITE);
		labelSaldo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		panelSaldo.add(labelSaldo);
		add(panelSaldo, BorderLayout.NORTH);
		
		
		//Botones
		JButton botonVolver = new JButton("Volver al menu");
		botonVolver.setBackground(colorBoton);
		botonVolver.setForeground(Color.WHITE);
		botonVolver.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		botonVolver.setFocusPainted(false);
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(colorFondo);
		panelSur.add(botonVolver);
		add(panelSur, BorderLayout.SOUTH);
		
		botonVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaMenuJuegos(jugador);
				dispose();
			}
		});
	}

}
