package Vista_Controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;



//@SuppressWarnings("deprecation")
public class Vista_Pokemon extends JPanel /*implements Observer */{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Controler controler = null;
	private JPanel PanelPokemons;
	private JPanel PanelPokemons_Vis;
	private JPanel Panel_Pokemons_Sup;
	private JPanel Panel_Pokemons_Cen;
	private JPanel Panel_Pokemons_Inf;

	private Panel_Pokemon Panel_Pok;

	/*Hace falta meter en la constructora de este panel
	 * ListaJugadores.getListaJugadores().get(nPoke).addObserver(this);
	 */
	
	

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
			PanelPokemons_Vis = new JPanel();
			Panel_Pok = new Panel_Pokemon(i, nJug);
			PanelPokemons_Vis.setLayout(new BorderLayout(0, 0));
			PanelPokemons_Vis.add(getPanel_Pokemons_Sup(Panel_Pok), BorderLayout.NORTH);
			PanelPokemons_Vis.add(getPanel_Pokemons_Cen(Panel_Pok), BorderLayout.CENTER);
			PanelPokemons_Vis.add(getPanel_Pokemons_Inf(Panel_Pok), BorderLayout.SOUTH);
			panelPok.add(PanelPokemons_Vis);
		
			
		}
		return PanelPokemons_Vis;
	}
	private JPanel getPanel_Pokemons_Sup(Panel_Pokemon pPok) {
		
		Panel_Pokemons_Sup = new JPanel();
		Panel_Pokemons_Sup.setLayout(new GridLayout(4, 2, 0, 0));
		Panel_Pokemons_Sup.add(pPok.getLblAtt());
		Panel_Pokemons_Sup.add(pPok.getLab_att());
		Panel_Pokemons_Sup.add(pPok.getLblDef());
		Panel_Pokemons_Sup.add(pPok.getLabel_2_1());
		Panel_Pokemons_Sup.add(pPok.getLblHealth_1());
		Panel_Pokemons_Sup.add(pPok.getLab_health());
		Panel_Pokemons_Sup.add(pPok.getLblType());
		Panel_Pokemons_Sup.add(pPok.getLab_type());
		return Panel_Pokemons_Sup;
	}
	private JPanel getPanel_Pokemons_Cen(Panel_Pokemon pPok) {
		Panel_Pokemons_Cen = new JPanel();
		Panel_Pokemons_Cen.add(pPok.getLabel_1());
		return Panel_Pokemons_Cen;
	}
	private JPanel getPanel_Pokemons_Inf(Panel_Pokemon pPok) {
		Panel_Pokemons_Inf = new JPanel();
		Panel_Pokemons_Inf.setLayout(new GridLayout(2, 1, 0, 0));
		Panel_Pokemons_Inf.add(pPok.getPanel_Pokemons_Inf_Health());
		Panel_Pokemons_Inf.add(pPok.getPanel_Pokemons_Inf_ChargedAttack());
		return Panel_Pokemons_Inf;
	}
		}