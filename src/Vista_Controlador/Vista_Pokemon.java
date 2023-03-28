package Vista_Controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

/*
 * Clase del Observer
 */
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modelo.CampoDeBatalla;
import Modelo.Jugador;
import Modelo.ListaJugadores;
import Modelo.Pokemon;


@SuppressWarnings("deprecation")
public class Vista_Pokemon extends JPanel implements Observer {
	private Controler controler = null;
	private JPanel PanelPokemons;
	private JPanel PanelPokemons_Vis;
	private JPanel Panel_Pokemons_Inf_Health;
	private JPanel Panel_Pokemons_Inf_ChargedAttack;
	private JLabel lbl_Health_bar;
	private JLabel lblChargedAttack;
	private JLabel label_1;
	private JLabel lblAtt;
	private JLabel lab_att;
	private JLabel lblDef;
	private JLabel lab_Def;
	private JLabel lblHealth_1;
	private JLabel lab_health;
	private JLabel lblType;
	private JLabel lab_type;
	private JPanel Panel_Pokemons_Sup;
	private JPanel Panel_Pokemons_Cen;
	private JPanel Panel_Pokemons_Inf;

	/*Hace falta meter en la constructora de este panel
	 * ListaJugadores.getListaJugadores().get(nPoke).addObserver(this);
	 */
	
	
	public Vista_Pokemon(int nPok, int nJug) {
		ListaJugadores.getListaJugadores().buscarJugador(nJug).getPokemon(nPok).addObserver(this);

	}

	public JPanel getPanelPokemons(int nPok, int nJug) {
		PanelPokemons = new JPanel();
		PanelPokemons.setForeground(Color.BLACK);
		PanelPokemons.setBackground(Color.WHITE);
		PanelPokemons.setBounds(201, 0, 599, 263);
		PanelPokemons.setLayout(new GridLayout(1, 3, 0, 0));
		PanelPokemons.add(getPanelPokemons_Vis(nPok, nJug, PanelPokemons));
		
		return PanelPokemons;
	}
	
	private JPanel getPanelPokemons_Vis(int nPok, int nJug, JPanel panelPok) {
		for(int i=1; i<=nPok; i++) {
			PanelPokemons_Vis = new Vista_Pokemon(nPok, nJug);
			PanelPokemons_Vis.setLayout(new BorderLayout(0, 0));
			PanelPokemons_Vis.add(getPanel_Pokemons_Sup(nPok, nJug), BorderLayout.NORTH);
			PanelPokemons_Vis.add(getPanel_Pokemons_Cen(), BorderLayout.CENTER);
			PanelPokemons_Vis.add(getPanel_Pokemons_Inf(), BorderLayout.SOUTH);
			getControler().atributos(i, nJug);
			
			panelPok.add(PanelPokemons_Vis);
		
			
		}
		return PanelPokemons_Vis;
	}
	private JPanel getPanel_Pokemons_Sup(int nPok, int nJug) {
		Panel_Pokemons_Sup = new JPanel();
		Panel_Pokemons_Sup.setLayout(new GridLayout(4, 2, 0, 0));
		Panel_Pokemons_Sup.add(getLblAtt());
		Panel_Pokemons_Sup.add(getLab_att(nPok, nJug));
		Panel_Pokemons_Sup.add(getLblDef());
		Panel_Pokemons_Sup.add(getLabel_2_1());
		Panel_Pokemons_Sup.add(getLblHealth_1());
		Panel_Pokemons_Sup.add(getLab_health());
		Panel_Pokemons_Sup.add(getLblType());
		Panel_Pokemons_Sup.add(getLab_type());
		//getControler().atributos(nPok, nJug);
		return Panel_Pokemons_Sup;
	}
	private JPanel getPanel_Pokemons_Cen() {
		Panel_Pokemons_Cen = new JPanel();
		Panel_Pokemons_Cen.add(getLabel_1());
		return Panel_Pokemons_Cen;
	}
	private JPanel getPanel_Pokemons_Inf() {
		Panel_Pokemons_Inf = new JPanel();
		Panel_Pokemons_Inf.setLayout(new GridLayout(2, 1, 0, 0));
		Panel_Pokemons_Inf.add(getPanel_Pokemons_Inf_Health());
		Panel_Pokemons_Inf.add(getPanel_Pokemons_Inf_ChargedAttack());
		return Panel_Pokemons_Inf;
	}
	
	public JPanel getPanel_Pokemons_Inf_Health() {
		Panel_Pokemons_Inf_Health = new JPanel();
		Panel_Pokemons_Inf_Health.add(getLbl_Health_bar());
		return Panel_Pokemons_Inf_Health;
	}
	public JPanel getPanel_Pokemons_Inf_ChargedAttack() {
		Panel_Pokemons_Inf_ChargedAttack = new JPanel();
		Panel_Pokemons_Inf_ChargedAttack.add(getLblChargedAttack());
		return Panel_Pokemons_Inf_ChargedAttack;
	}
	public JLabel getLbl_Health_bar() {
		lbl_Health_bar = new JLabel("Health");
		return lbl_Health_bar;
	}
	public JLabel getLblChargedAttack() {
		lblChargedAttack = new JLabel("Charged Attack");
		return lblChargedAttack;
	}
	public JLabel getLabel_1() {
		String imagenes[] = {"sprites/abra.png", "sprites/alakazam.png", "sprites/butterfree.png", "sprites/caterpie.png"
				,"sprites/dragonair.png", "sprites/dragonite.png", "sprites/dratini.png", "sprites/gastly.png", "sprites/gengar.png"
				,"sprites/geodude.png", "sprites/golem.png", "sprites/graveler.png", "sprites/haunter.png", "sprites/kadabra.png",
				"sprites/machamp.png", "sprites/machoke.png", "sprites/machop.png", "sprites/metapod.png", "sprites/pidgeot.png",
				"sprites/pidgeotto.png", "sprites/pidgey.png"};
		label_1 = new JLabel("");
		int r = (int)(Math.random()*21); 
		String url = imagenes[r];
		label_1.setIcon(new ImageIcon(url));
		return label_1;
	}
	public JLabel getLblAtt() {
		lblAtt = new JLabel("att: ");
		return lblAtt;
	}
	public JLabel getLab_att(int numPok, int nJug) {
		lab_att = new JLabel("??");
		
		return lab_att;
	}
	public JLabel getLblDef() {
		lblDef = new JLabel("def: ");
		return lblDef;
	}
	public JLabel getLabel_2_1() {
		lab_Def = new JLabel("??");
		return lab_Def;
	}
	public JLabel getLblHealth_1() {
		lblHealth_1 = new JLabel("Health: ");
		return lblHealth_1;
	}
	public JLabel getLab_health() {
		lab_health = new JLabel("??");
		return lab_health;
	}
	public JLabel getLblType() {
		lblType = new JLabel("type: ");
		return lblType;
	}
	public JLabel getLab_type() {
		lab_type = new JLabel("Normal");
		return lab_type;
	}
	
	

	@Override
	public void update(Observable arg0, Object arg1) { /*Este panel es solo para los Pokemon*/
		// TODO Auto-generated method stub
		if (arg0 instanceof Pokemon) {
		}
	}
	
	private Controler getControler() {
		if(controler == null) {
			controler = new Controler();
		}
		return controler;
	}
	
	private class Controler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			}
		
		
		public void atributos(int numPok, int nJug) {
				lab_att.setText(String.valueOf(ListaJugadores.getListaJugadores().buscarJugador(nJug).getPokemon(numPok).getAtaque()));
				lab_Def.setText(String.valueOf(ListaJugadores.getListaJugadores().buscarJugador(nJug).getPokemon(numPok).getDefensa()));
				lab_health.setText(String.valueOf(ListaJugadores.getListaJugadores().buscarJugador(nJug).getPokemon(numPok).getVida()));
		}
		}
	}