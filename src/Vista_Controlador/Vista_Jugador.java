package Vista_Controlador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista_Jugador extends JFrame {
	private JPanel Panel_Jugador;
	private MiJPanelObserver Panel_Jugador_Estado;
	private JLabel lab_Jugador_estado;
	private JLabel label;
	private JPanel PanelPokemons;
	private MiJPanelObserver PanelPokemons_Vis;
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
	private Controler controler = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_Jugador frame = new Vista_Jugador(3);
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
	public Vista_Jugador(int nPok) {
		setBounds(100, 100, 800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel_Jugador());
		getContentPane().add(getPanelPokemons(nPok));
		setResizable(false);

	}
	private JPanel getPanel_Jugador() {
		if (Panel_Jugador == null) {
			Panel_Jugador = new JPanel();
			Panel_Jugador.setBackground(new Color(255, 255, 255));
			Panel_Jugador.setBounds(0, 0, 200, 263);
			Panel_Jugador.setLayout(new BorderLayout(0, 0));
			Panel_Jugador.add(getPanel_Jugador_Estado(), BorderLayout.NORTH);
			Panel_Jugador.add(getLabel(), BorderLayout.CENTER);
		}
		return Panel_Jugador;
	}
	private JPanel getPanel_Jugador_Estado() {
		if (Panel_Jugador_Estado == null) {
			Panel_Jugador_Estado = new MiJPanelObserver();
			Panel_Jugador_Estado.setBackground(Color.RED);
			Panel_Jugador_Estado.add(getLab_Jugador_estado());
		}
		return Panel_Jugador_Estado;
	}
	private JLabel getLab_Jugador_estado() {
		if (lab_Jugador_estado == null) {
			lab_Jugador_estado = new JLabel("No atacar");
		}
		return lab_Jugador_estado;
	}
	private JLabel getLabel() {
		label = new JLabel("Foto Entrenador");
		label.setHorizontalAlignment(SwingConstants.CENTER);
			/*
			 * TODO - Implimentar un random para eleguir al entrandor
			 */
		label.setIcon(new ImageIcon(""));
		return label;
	}
	
	private JPanel getPanelPokemons(int nPok) {
		PanelPokemons = new JPanel();
		PanelPokemons.setForeground(Color.BLACK);
		PanelPokemons.setBackground(Color.WHITE);
		PanelPokemons.setBounds(201, 0, 599, 263);
		PanelPokemons.setLayout(new GridLayout(1, 3, 0, 0));
		PanelPokemons.add(getPanelPokemons_Vis(nPok, PanelPokemons));
		return PanelPokemons;
	}
	private JPanel getPanelPokemons_Vis(int nPok, JPanel panelPok) {
		for(int i=1; i<=nPok; i++) {
			PanelPokemons_Vis = new MiJPanelObserver();
			PanelPokemons_Vis.setLayout(new BorderLayout(0, 0));
			PanelPokemons_Vis.add(getPanel_Pokemons_Sup(), BorderLayout.NORTH);
			PanelPokemons_Vis.add(getPanel_Pokemons_Cen(), BorderLayout.CENTER);
			PanelPokemons_Vis.add(getPanel_Pokemons_Inf(), BorderLayout.SOUTH);
			panelPok.add(PanelPokemons_Vis);
			
		}
		return PanelPokemons_Vis;
	}
	private JPanel getPanel_Pokemons_Sup() {
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
	private JPanel getPanel_Pokemons_Inf_Health() {
		Panel_Pokemons_Inf_Health = new JPanel();
		Panel_Pokemons_Inf_Health.add(getLbl_Health_bar());
		return Panel_Pokemons_Inf_Health;
	}
	private JPanel getPanel_Pokemons_Inf_ChargedAttack() {
		Panel_Pokemons_Inf_ChargedAttack = new JPanel();
		Panel_Pokemons_Inf_ChargedAttack.add(getLblChargedAttack());
		return Panel_Pokemons_Inf_ChargedAttack;
	}
	private JLabel getLbl_Health_bar() {
		lbl_Health_bar = new JLabel("Health");
		return lbl_Health_bar;
	}
	private JLabel getLblChargedAttack() {
		lblChargedAttack = new JLabel("Charged Attack");
		return lblChargedAttack;
	}
	private JLabel getLabel_1() {
		label_1 = new JLabel("Foto del Pokemon");
		label_1.setIcon(new ImageIcon(""));
		return label_1;
	}
	private JLabel getLblAtt() {
		lblAtt = new JLabel("att: ");
		return lblAtt;
	}
	private JLabel getLab_att() {
		lab_att = new JLabel("??");
		return lab_att;
	}
	private JLabel getLblDef() {
		lblDef = new JLabel("def: ");
		return lblDef;
	}
	private JLabel getLabel_2_1() {
		lab_Def = new JLabel("??");
		return lab_Def;
	}
	private JLabel getLblHealth_1() {
		lblHealth_1 = new JLabel("Health: ");
		return lblHealth_1;
	}
	private JLabel getLab_health() {
		lab_health = new JLabel("??");
		return lab_health;
	}
	private JLabel getLblType() {
		lblType = new JLabel("type: ");
		return lblType;
	}
	private JLabel getLab_type() {
		lab_type = new JLabel("??");
		return lab_type;
	}
	 
	/*
	 * Controlador
	 */
	
	private Controler getControler() {
		if (controler==null) {
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
