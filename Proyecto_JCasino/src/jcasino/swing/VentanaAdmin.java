package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
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
		
		//Estilo de colores y fuentes para el Título
		Color colorFondo = new Color(30, 30, 30);
		Color colorTexto = Color.WHITE;
		Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 20);
		
		//Layout principal
		setLayout(new BorderLayout(10, 10));
		getContentPane().setBackground(colorFondo);
		
		//Panel superior para el Título
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(colorFondo);
		panelSuperior.setBorder(BorderFactory.createEmptyBorder(15, 0, 5, 0));
		
		JLabel labelTitulo = new JLabel("VENTANA DE ADMINISTRADOR");
		labelTitulo.setFont(fuenteTitulo);
		labelTitulo.setForeground(colorTexto);
		
		panelSuperior.add(labelTitulo);
		add(panelSuperior, BorderLayout.NORTH);
		
		setVisible(true);
	}
}

