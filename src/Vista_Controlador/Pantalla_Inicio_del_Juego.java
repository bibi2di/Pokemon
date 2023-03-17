package Vista_Controlador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataEvent;

import Modelo.ListaJugadores;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla_Inicio_del_Juego extends JFrame {

	private JPanel contentPane;
	private JTextField textJugadores;
	private JTextField txtNPCs;
	private JTextField textMiliSec;
	private JTextField textPokemon;
	//private Controlador controlador;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla_Inicio_del_Juego frame = new Pantalla_Inicio_del_Juego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pantalla_Inicio_del_Juego() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("sprites/pokebol.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Pokemon - Charged Attack");
		setBounds(100, 100, 800, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel Panel_derecho = new JPanel();
		contentPane.add(Panel_derecho, BorderLayout.EAST);
		Panel_derecho.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel Panel_dech_superior = new JPanel();
		Panel_derecho.add(Panel_dech_superior);
		Panel_dech_superior.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Jugadores");
		Panel_dech_superior.add(lblNewLabel_1);
		
		textJugadores = new JTextField();
		textJugadores.setText("");
		Panel_dech_superior.add(textJugadores);
		textJugadores.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("NPCs");
		Panel_dech_superior.add(lblNewLabel_2);
		
		txtNPCs = new JTextField();
		Panel_dech_superior.add(txtNPCs);
		txtNPCs.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("niliSecs/round");
		Panel_dech_superior.add(lblNewLabel_3);
		
		textMiliSec = new JTextField();
		textMiliSec.setText("2000");
		Panel_dech_superior.add(textMiliSec);
		textMiliSec.setColumns(10);
		
		JLabel lblPokemons = new JLabel("Pokemons");
		Panel_dech_superior.add(lblPokemons);
		
		textPokemon = new JTextField();
		Panel_dech_superior.add(textPokemon);
		textPokemon.setColumns(10);
		
		JPanel Panel_dech_inf = new JPanel();
		Panel_derecho.add(Panel_dech_inf);
		Panel_dech_inf.setLayout(null);
		
		JButton btnReadme = new JButton("ReadMe");
		btnReadme.setBounds(117, 33, 99, 25);
		Panel_dech_inf.add(btnReadme);
		
		JButton btnFree4all = new JButton("Free4all");
		btnFree4all.setBounds(12, 33, 99, 25);
		Panel_dech_inf.add(btnFree4all);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(/*getControlador());*/new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Pasar de String a int
				
				int jugadores = Integer.parseInt(textJugadores.getText());
				int npc = Integer.parseInt(txtNPCs.getText());
				int mili = Integer.parseInt(textMiliSec.getText());
				int pokemon = Integer.parseInt(textPokemon.getText());
				
				for(int i=1; i<=jugadores; i++) {
					Vista_Juego jug = new Vista_Juego(i, npc, mili, pokemon);
					jug.setVisible(true);
				}
				
				
			}
			
		});
		btnJugar.setBounds(56, 89, 117, 25);
		Panel_dech_inf.add(btnJugar);
		
		JPanel Panel_centro = new JPanel();
		Panel_centro.setForeground(SystemColor.control);
		Panel_centro.setBackground(new Color(255, 255, 255));
		contentPane.add(Panel_centro, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("sprites/main.png"));
		Panel_centro.add(lblNewLabel);
		System.out.println("a");
		
		/*private Controlador getControlador() {
			if(miControlador == null) {
				miControlador = new Controlador();
			}
			return miControlador;
		}
		
		private class Controlador implements ActionListener {
			private static Controlador miControlador = null;
			
			private Controlador() {
				
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnJugar)) {
					int jugadores = Integer.parseInt(textJugadores.getText());
					int npc = Integer.parseInt(txtNPCs.getText());
					int mili = Integer.parseInt(textMiliSec.getText());
					int pokemon = Integer.parseInt(textPokemon.getText());
					
					ListaJugadores.getListaJugadores().iniciarJuego(jugadores, npc, pokemon);
					Vista_Juego jug = new Vista_Juego(jugadores, npc, mili, pokemon);
					jug.setVisible(true);
				}
				
			}
			
		}*/
	}
}
