package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaInicioSesion extends JFrame {
	
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
		panelCentro.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 20));
		
		// Panel con el nombre de usuario
		panelCentro.add(new JLabel("Nombre de Usuario"));
		panelCentro.add(new JTextField());
		
		// Panel con las contraseña
		panelCentro.add(new JLabel("Contraseña"));
		panelCentro.add(new JPasswordField());
		
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
	}

	
	public static void main(String[] args) {
		new VentanaInicioSesion();
	}
}
