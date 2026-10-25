package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

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
		
		// Personalización de la ventana
		Color colorFondo = new Color(30, 30, 30);
		Color colorTexto = Color.WHITE;
		Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 14);
		Font fuenteCajas = new Font("Segoe UI", Font.PLAIN, 14);
		
		
		// Añadimos un BorderLayout a la ventana
		setLayout(new BorderLayout());
		
		// PanelCentral
		JPanel panelCentro = new JPanel();
		
		// Aplicamos un BoxLayout en el eje y 
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
		
		// Creamos un borde al panel para apilar todo en el centro
		panelCentro.setBorder(BorderFactory.createEmptyBorder(20, 80, 0, 80));
		panelCentro.setBackground(colorFondo); // Aplicar color de Fondo
		
		// Creamos un label de usuario
		JLabel labelUsuario = new JLabel("Nombre de Usuario");
		labelUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelUsuario.setFont(fuenteTitulo); // Fuente del titulo
		labelUsuario.setForeground(colorTexto);
		
		// Creamos el jtextField para el campo 
		JTextField txtUsuario = new JTextField();
		txtUsuario.setMaximumSize(new Dimension(200, 25));
		txtUsuario.setFont(fuenteCajas);
				
		
		panelCentro.add(labelUsuario);
		panelCentro.add(Box.createVerticalStrut(10)); // Espacio pequeño entre label y textfield
		panelCentro.add(txtUsuario);
		
		// Label de contraseña
		JLabel labelContrasenna = new JLabel("Contraseña");
		labelContrasenna.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelContrasenna.setForeground(colorTexto);
		labelContrasenna.setFont(fuenteTitulo);
		
		JPasswordField txtContrasenna = new JPasswordField();
		txtContrasenna.setMaximumSize(new Dimension(200, 25));
		txtContrasenna.setFont(fuenteCajas);
		
		panelCentro.add(Box.createVerticalStrut(30)); // Espacio grande para separar usuario y contraseña
		
		panelCentro.add(labelContrasenna);
		panelCentro.add(Box.createVerticalStrut(10));
		panelCentro.add(txtContrasenna);

		
		// Botones de inicio de sesion y registro
		JPanel panelSur = new JPanel(new FlowLayout()); 
		panelSur.setBackground(colorFondo);
		// Creamos los botones 
		JButton botonInicioSesion = new JButton("Iniciar Sesión");
		JButton botonRegistarse = new JButton("Registrarse");
		
		panelSur.add(botonInicioSesion);
		panelSur.add(botonRegistarse);
		
		
		// Añadimos los paneles a la ventana y hacemos que se vea
		add(panelCentro, BorderLayout.CENTER);
		add(panelSur, BorderLayout.SOUTH);
		setVisible(true);
		
	}

	
	public static void main(String[] args) {
		new VentanaInicioSesion();
	}
}
