package Vista_Controlador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.border.BevelBorder;

public class Vista_Juego extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public Vista_Juego(int pJugador, int pNPCs, int pMilis, int pPokemos) {
		setTitle("Pokemon [Charged Attack] - "+pJugador);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Panel_Jugador = new JPanel();
		Panel_Jugador.setBackground(Color.WHITE);
		Panel_Jugador.setBounds(0, 0, 200, 263);
		contentPane.add(Panel_Jugador);
		Panel_Jugador.setLayout(null);
		
		JPanel Panel_Jugador_estado = new JPanel();
		Panel_Jugador_estado.setBackground(Color.GREEN);
		Panel_Jugador_estado.setForeground(Color.WHITE);
		Panel_Jugador_estado.setBounds(0, 0, 200, 27);
		Panel_Jugador.add(Panel_Jugador_estado);
		
		JLabel lblGo = new JLabel("Go!");
		Panel_Jugador_estado.add(lblGo);
		
		JPanel Panel_Jugador_Logo = new JPanel();
		Panel_Jugador_Logo.setBackground(Color.WHITE);
		Panel_Jugador_Logo.setBounds(0, 26, 200, 237);
		Panel_Jugador.add(Panel_Jugador_Logo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/asierla/git/Pokemon/sprites/trainer1.png"));
		Panel_Jugador_Logo.add(label);
		
		JPanel Panel_Pokemons = new JPanel();
		Panel_Pokemons.setBounds(201, 0, 587, 263);
		contentPane.add(Panel_Pokemons);
		Panel_Pokemons.setLayout(new GridLayout(1, 3, 0, 0));
		
		this.generarCasillaDePokemon(pPokemos, Panel_Pokemons);
		
	}
	
	/**
	 * Este metodo crea los pokemons en la interfaz grafica mediante los valores que recibe por parametros.
	 * @param nPok El numero de Pokemos que queremos.
	 */
	public void generarCasillaDePokemon(int nPok, JPanel Panel_Pokemons) {
		
		for(int i =1; i<=nPok; i++) {
			JPanel Panel_Pokemon_jug = new JPanel();
			Panel_Pokemon_jug.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
			Panel_Pokemons.add(Panel_Pokemon_jug);
			Panel_Pokemon_jug.setLayout(new BorderLayout(0, 0));
			
			JPanel Pokemon_info = new JPanel();
			Pokemon_info.setBackground(Color.WHITE);
			Panel_Pokemon_jug.add(Pokemon_info, BorderLayout.NORTH);
			Pokemon_info.setLayout(new GridLayout(4, 2, 0, 0));
			
			JLabel lblAtt = new JLabel("att:");
			lblAtt.setHorizontalAlignment(SwingConstants.RIGHT);
			Pokemon_info.add(lblAtt);
			
			JLabel label_1 = new JLabel("15+0");
			Pokemon_info.add(label_1);
			
			JLabel lblDef = new JLabel("def: ");
			lblDef.setHorizontalAlignment(SwingConstants.RIGHT);
			Pokemon_info.add(lblDef);
			
			JLabel label_2 = new JLabel("6+0");
			Pokemon_info.add(label_2);
			
			JLabel lblHealth = new JLabel("health:");
			lblHealth.setHorizontalAlignment(SwingConstants.RIGHT);
			Pokemon_info.add(lblHealth);
			
			JLabel label_3 = new JLabel("210/210");
			Pokemon_info.add(label_3);
			
			JLabel lblType = new JLabel("type:");
			lblType.setHorizontalAlignment(SwingConstants.RIGHT);
			Pokemon_info.add(lblType);
			
			JLabel lblPsychic = new JLabel("psychic");
			Pokemon_info.add(lblPsychic);
			
			JPanel Pokemon_Img = new JPanel();
			Pokemon_Img.setBackground(Color.WHITE);
			Panel_Pokemon_jug.add(Pokemon_Img, BorderLayout.CENTER);
			
			JLabel label_4 = new JLabel("");
			label_4.setIcon(new ImageIcon("/home/asierla/git/Pokemon/sprites/Electric/0pikachu.png"));
			Pokemon_Img.add(label_4);
			
			JPanel Pokemon_health = new JPanel();
			Panel_Pokemon_jug.add(Pokemon_health, BorderLayout.SOUTH);
			Pokemon_health.setLayout(new GridLayout(2, 1, 0, 0));
			
			JPanel Pokemon_Health_bar = new JPanel();
			Pokemon_health.add(Pokemon_Health_bar);
			
			JLabel lblHealth_1 = new JLabel("Health");
			Pokemon_Health_bar.add(lblHealth_1);
			
			JPanel Pokemon_charged_attack = new JPanel();
			Pokemon_health.add(Pokemon_charged_attack);
			
			JLabel lblChargedAttack = new JLabel("Charged attack");
			Pokemon_charged_attack.add(lblChargedAttack);
		}
	}
}
