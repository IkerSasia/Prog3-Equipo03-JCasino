package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VentanaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public VentanaRegistro() {
		setTitle("JCasino - Registro de Usuario");
		setSize(450, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Personalización de la ventana
		Color colorFondo = new Color(30, 30, 30);
		Color colorTexto = Color.WHITE;
		Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 14);
		Font fuenteCajas = new Font("Segoe UI", Font.PLAIN, 14);
		
		setLayout(new BorderLayout());
		
		// Creación del Formulario
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
		
		// Creamos un borde al panel para apilar todo en el centro
		panelCentro.setBorder(BorderFactory.createEmptyBorder(20, 80, 10, 80));
		panelCentro.setBackground(colorFondo); // Aplicar color de Fondo
		
		// Nombre 
		JLabel labelNombre = new JLabel("Nombre real");
		labelNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelNombre.setForeground(colorTexto);
		labelNombre.setFont(fuenteTitulo);
		
		JTextField txtNombre = new JTextField();
		txtNombre.setMaximumSize(new Dimension(250, 30));
		txtNombre.setHorizontalAlignment(JTextField.CENTER);
		
		// Apellidos 
		JLabel labelApellidos = new JLabel("Apellidos");
		labelApellidos.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelApellidos.setForeground(colorTexto);
		labelApellidos.setFont(fuenteTitulo);
		JTextField txtApellidos = new JTextField();
		txtApellidos.setMaximumSize(new Dimension(250, 30));
		txtApellidos.setHorizontalAlignment(JTextField.CENTER);
		
		// Género (Radio Buttons)
		JLabel labelGenero = new JLabel("Género");
		labelGenero.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelGenero.setForeground(colorTexto);
		labelGenero.setFont(fuenteTitulo);
		
		JPanel panelGenero = new JPanel(new FlowLayout());
		panelGenero.setBackground(colorFondo);
		panelGenero.setMaximumSize(new Dimension(250, 40));
		JRadioButton rbMasculino = new JRadioButton("Masculino");
		JRadioButton rbFemenino = new JRadioButton("Femenino");
		
		// Estilos para los radio Buttons
		rbMasculino.setForeground(colorTexto);
		rbMasculino.setBackground(colorFondo);
		rbFemenino.setForeground(colorTexto);
		rbFemenino.setBackground(colorFondo);
		
		// Solo poder marcar un boton a la vez
		ButtonGroup grupoGenero = new ButtonGroup();
		grupoGenero.add(rbFemenino);
		grupoGenero.add(rbMasculino);
		panelGenero.add(rbMasculino);
		panelGenero.add(rbFemenino);
		
		// Usuario
		JLabel labelUsuario = new JLabel("Nombre de Usuario");
		labelUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelUsuario.setForeground(colorTexto);
		labelUsuario.setFont(fuenteTitulo);
		JTextField txtUsuario = new JTextField();
		txtUsuario.setMaximumSize(new Dimension(250, 30));
		txtUsuario.setHorizontalAlignment(JTextField.CENTER);
		
		// Contraseña
        JLabel labelContrasena = new JLabel("Contraseña");
        labelContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelContrasena.setForeground(colorTexto);
        labelContrasena.setFont(fuenteTitulo);
        JPasswordField txtContrasena = new JPasswordField();
        txtContrasena.setMaximumSize(new Dimension(250, 30)); 
        txtContrasena.setHorizontalAlignment(JTextField.CENTER);
		
		
		// Añadimos todo al panel central
		panelCentro.add(labelNombre);
		panelCentro.add(Box.createVerticalStrut(5));
		panelCentro.add(txtNombre);
		panelCentro.add(Box.createVerticalStrut(15));
		
		panelCentro.add(labelApellidos);
		panelCentro.add(Box.createVerticalStrut(5));
		panelCentro.add(txtApellidos);
		panelCentro.add(Box.createVerticalStrut(15));

		
		panelCentro.add(labelGenero);
		panelCentro.add(panelGenero);
		panelCentro.add(Box.createVerticalStrut(5));
		
		panelCentro.add(labelUsuario);
		panelCentro.add(Box.createVerticalStrut(5));
		panelCentro.add(txtUsuario);
		panelCentro.add(Box.createVerticalStrut(15));
		
		panelCentro.add(labelContrasena);
		panelCentro.add(Box.createVerticalStrut(5));
		panelCentro.add(txtContrasena);
		
		
		// ZONA INFERIOR (REGISTRARSE Y VOLVER)
		JPanel panelSur = new JPanel(new FlowLayout());
		panelSur.setBackground(colorFondo);
		
		JButton botonRegistrar = new JButton("CREAR CUENTA");
		botonRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		botonRegistrar.setBackground(new Color(46, 139, 87)); // Verde Casino
		botonRegistrar.setForeground(Color.WHITE);
		botonRegistrar.setFocusPainted(false); // Quitar el recuadro que le sale al texto del boton al hacer clic
		botonRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.setFont(new Font("Segoe UI", Font.BOLD, 12));
		botonVolver.setBackground(new Color(46, 139, 87)); 
		botonVolver.setForeground(Color.WHITE);
		botonVolver.setFocusPainted(false);
		botonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar la forma del cursor al estar encima del boton
		
		
		
		
		panelSur.add(botonRegistrar);
		panelSur.add(botonVolver);
		
		
		
		
		
		// Añadimos los paneles a la ventana y hacemos que se vea
		add(panelCentro, BorderLayout.CENTER);
		add(panelSur, BorderLayout.SOUTH);
		setVisible(true);
	}

	public static void main(String[] args) {
		new VentanaRegistro();

	}

}
