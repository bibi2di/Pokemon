package Vista_Controlador;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class MiJPanelObserver extends JPanel implements Observer {
	private Controler controler = null;
	private JPanel PanelObserver;
	/*private JPanel Panel_Pokemons_Inf_Health;
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
	private JLabel lab_type;*/

	/*Hace falta meter en la constructora de este panel
	 * ListaJugadores.getListaJugadores().get(nPoke).addObserver(this);
	 */
	
	
	public MiJPanelObserver(/*int nPok*/) {
		PanelObserver = new JPanel();
		//ListaJugadores.getListaJugadores().buscarJugador(nJug).get(nPoke).addObserver(this);
		
	}

	/*public JPanel getPanel_Pokemons_Inf_Health() {
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
		label_1 = new JLabel("Foto del Pokemon");
		label_1.setIcon(new ImageIcon(""));
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
		lab_type = new JLabel("??");
		return lab_type;
	}
	*/
	
	@Override
	public void update(Observable arg0, Object arg1) { /*Este panel es solo para los Pokemon*/
		// TODO Auto-generated method stub
		if (arg0 instanceof Pokemon) {
			//actualizar valores
			
			//debilitado
			
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
		}
	}