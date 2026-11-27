package jcasino.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

import jcasino.dominio.Administrador;
import jcasino.dominio.Casino;
import jcasino.dominio.Juego;
import jcasino.dominio.Jugador;
import jcasino.dominio.Usuario;

public class VentanaAdmin extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ModeloTablaUsuarios modeloTabla;
	private JTable tablaUsuarios;
	
	
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
		
		
		
		//Creamos la tabla 
		modeloTabla = new ModeloTablaUsuarios(casino.getListaUsuarios());
		tablaUsuarios = new JTable(modeloTabla);
		tablaUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tablaUsuarios.setRowHeight(26);
		tablaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaUsuarios.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		JScrollPane scrollTabla = new JScrollPane(tablaUsuarios);
		
		JPanel panelCentro = new JPanel(new BorderLayout());
		panelCentro.setBackground(new Color(30, 30, 30));
		panelCentro.setBorder(BorderFactory.createEmptyBorder(0, 25, 0 ,25));
		panelCentro.add(scrollTabla, BorderLayout.CENTER);
		
		add(panelCentro, BorderLayout.CENTER);
		
		
		//Acción para el botón de cerrar sesión
		botonCerrarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaInicioSesion(casino);
				dispose();
			}
		});
		
		
		//Acción para el botón de eliminar el usuario seleccionado
		botonEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int fila = tablaUsuarios.getSelectedRow();
				if (fila == -1) {
					JOptionPane.showMessageDialog(VentanaAdmin.this, "Selecciona un usuario en la tabla");
					return;
				}
				
				String nombreUsuario = (String) modeloTabla.getValueAt(fila, 0);
				int confirmacion = JOptionPane.showConfirmDialog(VentanaAdmin.this, "¿Seguro que quieres eliminar a "+ nombreUsuario +"?", "Confirmar eliminación",JOptionPane.YES_NO_OPTION);
				
				if(confirmacion == JOptionPane.YES_OPTION) {
					try {
						casino.eliminarUsuario(nombreUsuario);
						modeloTabla.refrescar(casino.getListaUsuarios());
					} catch (IllegalStateException e2) {
						JOptionPane.showMessageDialog(VentanaAdmin.this, e2.getMessage());
					}
				}
			}
		});
		
		
		//Acción para el botón editar saldo de un jugador seleccionado
		botonEditarSaldo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int fila = tablaUsuarios.getSelectedRow();
				if (fila == -1) {
					JOptionPane.showMessageDialog(VentanaAdmin.this, "Selecciona un usuario de la tabla");
					return;
				}
				
				String nombreUsuario = (String) modeloTabla.getValueAt(fila, 0);
				String entrada = JOptionPane.showInputDialog(VentanaAdmin.this, "Nuevo saldo para "+nombreUsuario+":");
				
				if(entrada == null) {
					return;
				}
				
				try {
					double nuevoSaldo = Double.parseDouble(entrada.trim());
					if (casino.actualizarSaldoJugador(nombreUsuario, nuevoSaldo)) {
						modeloTabla.refrescar(casino.getListaUsuarios());
					} else {
						JOptionPane.showMessageDialog(VentanaAdmin.this, "Solo se puede editar el saldo de un Jugador.");
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(VentanaAdmin.this, "Introduce una cantidad válida.");
				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(VentanaAdmin.this, ex.getMessage());
				}
			}
		});
		
		
		//Acción para el botón cambiar apuesta mínima de cualquier juego
		botonApuestas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Juego> juegos = casino.getListaJuegos();
				String[] nombres = new String[juegos.size()];
				for (int i = 0; i < juegos.size(); i++) {
					nombres[i] = juegos.get(i).getNombre();
				}
				
				String juegoElegido = (String) JOptionPane.showInputDialog(VentanaAdmin.this, "Elige el juego que quieres modificar:", "Apuestas Mínimas", JOptionPane.QUESTION_MESSAGE, null, nombres, nombres[0]);
				
				if(juegoElegido == null) {
					return;
				}
				
				String entrada = JOptionPane.showInputDialog(VentanaAdmin.this, "Nueva apuesta mínima para "+juegoElegido+":");
				
				if(entrada == null) {
					return;
				}
				
				try {
					double nuevaApuesta = Double.parseDouble(entrada.trim());
					casino.actualizarApuestaMinima(juegoElegido, nuevaApuesta);
					JOptionPane.showMessageDialog(VentanaAdmin.this, "Apuesta mínima actualizada correctamente.");
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(VentanaAdmin.this, "Introduce una cantidad válida.");
				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(VentanaAdmin.this, ex.getMessage());
				}
			}
		});
		
		
		setVisible(true);
	}
	
	private class ModeloTablaUsuarios extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private String[] columnas = { "Usuario", "Nombre", "Apellidos", "Rol", "Saldo (€)" };
		private ArrayList<Usuario> usuarios;

		public ModeloTablaUsuarios(ArrayList<Usuario> usuarios) {
			this.usuarios = usuarios;
		}
		
		// Actualiza la lista y avisa a Swing para que repinte la tabla
			public void refrescar(ArrayList<Usuario> usuarios) {
				this.usuarios = usuarios;
				fireTableDataChanged();
			}

		@Override
		public int getRowCount() {
			return usuarios.size();
		}

		@Override
		public int getColumnCount() {
			return columnas.length;
		}

		@Override
		public String getColumnName(int column) {
			return columnas[column];
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Usuario u = usuarios.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return u.getNombreUsuario();
			case 1:
				return u.getNombre();
			case 2:
				return u.getApellidos();
			case 3:
				return (u instanceof Administrador) ? "Administrador" : "Jugador";
			case 4:
				return (u instanceof Jugador) ? ((Jugador) u).getSaldo() : "-";
			default:
				return "";
			}
		}
	}
	

	
}

