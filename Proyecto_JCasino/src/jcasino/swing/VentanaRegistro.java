package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		JRadioButton rbMasculino = new JRadioButton("Masculino");
		JRadioButton rbFemenino = new JRadioButton("Femenino");
		
		// Estilos para los radio Buttons
		rbMasculino.setForeground(colorTexto);
		rbMasculino.setBackground(colorFondo);
		rbFemenino.setForeground(colorTexto);
		rbFemenino.setBackground(colorFondo);
		
		
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new VentanaRegistro();

	}

}
