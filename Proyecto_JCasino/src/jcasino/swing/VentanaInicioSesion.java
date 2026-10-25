package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;


import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaInicioSesion extends JFrame {
	
	private static final long serialVersionUID = 1L;


	public VentanaInicioSesion() {
		// Creamos la ventana
		setTitle("Inicio de Sesión");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		
		// Añadimos un BorderLayout a la ventana
		setLayout(new BorderLayout());
		
		// PanelCentral
		JPanel panelCentro = new JPanel();
		
		// Aplicamos un BoxLayout en el eje y 
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
		
		// Creamos un borde al panel para apilar todo en el centro
		panelCentro.setBorder(BorderFactory.createEmptyBorder(20, 80, 0, 80));
		
		// Creamos un label de usuario
		JLabel labelUsuario = new JLabel("Nombre de Usuario");
		labelUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Creamos el jtextField para el campo 
		JTextField txtUsuario = new JTextField();
		txtUsuario.setMaximumSize(new Dimension(200, 25));
				
		
		panelCentro.add(labelUsuario);
		panelCentro.add(Box.createVerticalStrut(10)); // Espacio pequeño entre label y textfield
		panelCentro.add(txtUsuario);
		
		// Label de contraseña
		JLabel labelContrasenna = new JLabel("Contraseña");
		labelContrasenna.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPasswordField txtContrasenna = new JPasswordField();
		txtContrasenna.setMaximumSize(new Dimension(200, 25));
		
		panelCentro.add(Box.createVerticalStrut(30)); // Espacio grande para separar usuario y contraseña
		
		panelCentro.add(labelContrasenna);
		panelCentro.add(Box.createVerticalStrut(10));
		panelCentro.add(txtContrasenna);

		
		// Botones de inicio de sesion y registro
		JPanel panelSur = new JPanel(new FlowLayout()); 
		
		// Creamos los botones 
		JButton botonInicioSesion = new JButton("Iniciar Sesión");
		JButton botonRegistarse = new JButton("Registrarse");
		
		panelSur.add(botonInicioSesion);
		panelSur.add(botonRegistarse);
		
		
		// Añadimos los paneles a la ventana y hacemos que se vea
		add(panelCentro, BorderLayout.CENTER);
		add(panelSur, BorderLayout.SOUTH);
		setVisible(true);
		
		// Pureba pachin github
	}

	
	public static void main(String[] args) {
		new VentanaInicioSesion();
	}
}
