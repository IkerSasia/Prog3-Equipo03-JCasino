package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jcasino.dominio.Casino;

public class VentanaAdmin extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public VentanaAdmin(Casino casino) {
		setTitle("Ventana de Administrador");
		setSize(650, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		
		
		//Layout principal
		setLayout(new BorderLayout(10, 10));
		getContentPane().setBackground(new Color(30, 30, 30));
		
		//Panel superior para el Título
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(30, 30, 30));
		panelSuperior.setBorder(BorderFactory.createEmptyBorder(15, 0, 5, 0));
		
		JLabel labelTitulo = new JLabel("VENTANA DE ADMINISTRADOR");
		labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
		labelTitulo.setForeground(Color.WHITE);
		
		panelSuperior.add(labelTitulo);
		add(panelSuperior, BorderLayout.NORTH);
		
		
		
		//Panel inferior para los botones
		JPanel panelInferior = new JPanel();
		panelInferior.setBackground(new Color(30, 30, 30));
		
		//1º Botón: Editar Saldo
		JButton botonEditarSaldo = new JButton("Editar Saldo");
		botonEditarSaldo.setBackground(new Color(40, 120, 80));
		botonEditarSaldo.setForeground(Color.WHITE);
		botonEditarSaldo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonEditarSaldo.setFocusPainted(false);
		
		//2º Botón: Eliminar Usuario
		JButton botonEliminar = new JButton("Eliminar Usuario");
		botonEliminar.setBackground(new Color(180, 50, 50));
		botonEliminar.setForeground(Color.WHITE);
		botonEliminar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonEliminar.setFocusPainted(false);
		
		//3º Botón: Apuesta Mínima
		JButton botonApuestas = new JButton("Apuestas Mínimas");
		botonApuestas.setBackground(new Color(70, 70, 70));
		botonApuestas.setForeground(Color.WHITE);
		botonApuestas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonApuestas.setFocusPainted(false);
		
		//4º Botón: Cerrar Sesión
		JButton botonCerrarSesion = new JButton("Cerrar Sesión");
		botonCerrarSesion.setBackground(new Color(70, 70, 70));
		botonCerrarSesion.setForeground(Color.WHITE);
		botonCerrarSesion.setFont(new Font("Segoe UI", Font.BOLD, 14));
		botonCerrarSesion.setFocusPainted(false);
		
		//Añadir botones al panel, y el panel a la ventana
		panelInferior.add(botonEditarSaldo);
		panelInferior.add(botonEliminar);
		panelInferior.add(botonApuestas);
		panelInferior.add(botonCerrarSesion);
		add(panelInferior, BorderLayout.SOUTH);
		
		
		
		
		
		
		setVisible(true);
	}
}

