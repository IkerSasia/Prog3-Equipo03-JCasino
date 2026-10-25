package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import jcasino.dominio.Jugador;

public class VentanaSaldo extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public VentanaSaldo(Jugador jugador) {
		setTitle("Gestión de saldo");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Color colorFondo = new Color(30, 30, 30);
		Color colorBoton = new Color(40, 120, 80);
		
		
		//Aqui escribimos cuanto queremos meter
		JPanel panelRecarga = new JPanel(new FlowLayout());
		panelRecarga.setBackground(colorFondo);
		
		JLabel labelCantidad = new JLabel("Cantidad");
		labelCantidad.setForeground(Color.WHITE);
		
		JTextField txtCantidad = new JTextField(10);
		
		JButton botonRecargar = new JButton("Recargar");
		botonRecargar.setBackground(colorBoton);
		botonRecargar.setForeground(Color.WHITE);
		botonRecargar.setFont(new Font("Sogoe UI", Font.PLAIN, 14));
		botonRecargar.setFocusPainted(false);
		
		
		panelRecarga.add(labelCantidad);
		panelRecarga.add(txtCantidad);
		panelRecarga.add(botonRecargar);
		
		
		
		add(panelRecarga, BorderLayout.CENTER);
		
		
		
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
		
		botonRecargar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//Cogemos la cantidad que ha escrito
				String texto = txtCantidad.getText().trim();
				
				if (texto.isEmpty()) {
					
					JOptionPane.showMessageDialog(VentanaSaldo.this, "Escribe una cantidad");
				} else {
					
					try {
						double cantidad = Double.parseDouble(texto);
						
						if (cantidad <= 0) {
							JOptionPane.showMessageDialog(VentanaSaldo.this, "Introduce una cantidad valida mayor que cero");
						} else {
							//Sumamos el dinero al saldo
							jugador.recargarSaldo(cantidad);
							
							labelSaldo.setText("Saldo actual: " + jugador.getSaldo() + " €");
							txtCantidad.setText("");
						}
					} catch (NumberFormatException ex) {
						
						JOptionPane.showMessageDialog(VentanaSaldo.this, "Escribe un numero. Para los decimales usa punto");
					}
				}
			}
		});
		
		botonVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaMenuJuegos(jugador);
				dispose();
			}
		});
		
		setVisible(true);
	}

}
