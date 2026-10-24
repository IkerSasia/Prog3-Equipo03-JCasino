package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;

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
		
		
		JPanel panelCentro = new JPanel(new GridLayout(2, 2, 10, 10));
		
		// Panel con el nombre de usuario
		panelCentro.add(new JLabel("Nombre de Usuario"));
		panelCentro.add(new JTextField());
		
		// Panel con las contraseña
		panelCentro.add(new JLabel("Contraseña"));
		panelCentro.add(new JPasswordField());
		
		
		// Añadimos los paneles a la ventana y hacemos que se vea
		add(panelCentro, BorderLayout.CENTER);
		setVisible(true);
	}

	
	public static void main(String[] args) {
		new VentanaInicioSesion();
	}
}
