package Vista_Controlador;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modelo.CampoDeBatalla;
import Modelo.ListaJugadores;
import Modelo.Pokemon;

public class Panel_Pokemon extends JPanel implements Observer {

	private Controler controler;
	private JPanel Panel_Pokemons_Sup;
	private JPanel Panel_Pokemons_Cen;
	private JPanel Panel_Pokemons_Inf;
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
	private int idJug = -1;
	private int idPok = -1;
	

	@SuppressWarnings("deprecation")
	public Panel_Pokemon(int nPok, int nJug) {
		ListaJugadores.getListaJugadores().buscarJugador(nJug).getPokemon(nPok).addObserver(this);
		this.addMouseListener(getControler());
	}
	
	/*public JPanel getPanel_Pokemons_Sup() {
		
		Panel_Pokemons_Sup = new JPanel();
		Panel_Pokemons_Sup.setLayout(new GridLayout(4, 2, 0, 0));
		Panel_Pokemons_Sup.add(getLblAtt());
		Panel_Pokemons_Sup.add(getLab_att());
		Panel_Pokemons_Sup.add(getLblDef());
		Panel_Pokemons_Sup.add(getLabel_2_1());
		Panel_Pokemons_Sup.add(getLblHealth_1());
		Panel_Pokemons_Sup.add(getLab_health());
		Panel_Pokemons_Sup.add(getLblType());
		Panel_Pokemons_Sup.add(getLab_type());
		return Panel_Pokemons_Sup;
	}
	public JPanel getPanel_Pokemons_Cen() {
		Panel_Pokemons_Cen = new JPanel();
		Panel_Pokemons_Cen.add(getLabel_1());
		return Panel_Pokemons_Cen;
	}
	public JPanel getPanel_Pokemons_Inf() {
		Panel_Pokemons_Inf = new JPanel();
		Panel_Pokemons_Inf.setLayout(new GridLayout(2, 1, 0, 0));
		Panel_Pokemons_Inf.add(getPanel_Pokemons_Inf_Health());
		Panel_Pokemons_Inf.add(getPanel_Pokemons_Inf_ChargedAttack());
		return Panel_Pokemons_Inf;
	}*/
	
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
	public JLabel getLab_att() {
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
			if (arg1 instanceof Object []) {
				Object[] objecArray = (Object []) arg1;
				int vida = (Integer)objecArray[0];
				int defensa = (Integer)objecArray[1];
				int ataque = (Integer)objecArray[2];
				String tipo = (String)objecArray[3];
				lab_att.setText(String.valueOf(ataque));
				lab_Def.setText(String.valueOf(defensa));
				lab_health.setText(String.valueOf(vida));
				System.out.println("Observer actualizado");
			}
		}
	}
	
	private Controler getControler() {
		if(controler == null) {
			controler = new Controler();
		}
		return controler;
	}
	
	private class Controler implements MouseListener{


		@Override
		public void mouseClicked(MouseEvent e) {
			CampoDeBatalla.getCampoBatalla().sePuedeAtacar(idPok, idJug);
			System.out.println("a");
		}
		
		
		public void atributos(int numPok, int nJug) {
				//lab_att.setText(String.valueOf(ListaJugadores.getListaJugadores().buscarJugador(nJug).getPokemon(numPok).getAtaque()));
				//lab_Def.setText(String.valueOf(ListaJugadores.getListaJugadores().buscarJugador(nJug).getPokemon(numPok).getDefensa()));
				//lab_health.setText(String.valueOf(ListaJugadores.getListaJugadores().buscarJugador(nJug).getPokemon(numPok).getVida()));
		}


		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		}
}
