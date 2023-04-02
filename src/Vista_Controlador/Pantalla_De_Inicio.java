package Vista_Controlador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import Modelo.ListaJugadores;

import javax.swing.Action;
import javax.swing.ImageIcon;
import java.awt.Color;
/*
 * alks ashdlsad
 */
@SuppressWarnings("deprecation")
public class Pantalla_De_Inicio extends JFrame implements Observer{
	private JPanel Panel_derecho;
	private JPanel panel_central;
	private JPanel Panel_derecho_sup;
	private JPanel panel_derecho_inf;
	private JLabel lblJugadores;
	private JTextField txtNjuga;
	private JLabel lblNpcs;
	private JTextField txtNnpcs;
	private JLabel lblMilisecsround;
	private JTextField txtNmilis;
	private JLabel lblPokmons;
	private JTextField txtNpokemosn;
	private JButton readme;
	private JButton cerrar;
	private JButton btnJugar;
	private JLabel label;
	private Controler controler = null;
	private JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla_De_Inicio frame = new Pantalla_De_Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//boolean fin = ListaJugadores.getListaJugadores().finJuego();
				//while(!fin) {
					//ListaJugadores.getListaJugadores().asignarTurnoAleatoriamente(, );
				//}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pantalla_De_Inicio() {
		setTitle("Pokemon");
		getContentPane().setForeground(new Color(255, 255, 255));
		setBounds(100, 100, 800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel_derecho(), BorderLayout.EAST);
		getContentPane().add(getPanel_central(), BorderLayout.CENTER);
		setResizable(false);
		ListaJugadores.getListaJugadores().addObserver(this);
	}

	private JPanel getPanel_derecho() {
		if (Panel_derecho == null) {
			Panel_derecho = new JPanel();
			Panel_derecho.setLayout(new GridLayout(2, 1, 0, 0));
			Panel_derecho.add(getPanel_derecho_sup());
			Panel_derecho.add(getPanel_derecho_inf());
		}
		return Panel_derecho;
	}
	private JPanel getPanel_central() {
		if (panel_central == null) {
			panel_central = new JPanel();
			panel_central.setBackground(new Color(255, 255, 255));
			panel_central.setForeground(new Color(255, 255, 255));
			panel_central.add(getLblTienesQueMeter());
			panel_central.add(getLabel());
		}
		return panel_central;
	}
	private JPanel getPanel_derecho_sup() {
		if (Panel_derecho_sup == null) {
			Panel_derecho_sup = new JPanel();
			Panel_derecho_sup.setLayout(new GridLayout(4, 2, 0, 0));
			Panel_derecho_sup.add(getLblJugadores());
			Panel_derecho_sup.add(getTxtNjuga());
			Panel_derecho_sup.add(getLblNpcs());
			Panel_derecho_sup.add(getTxtNnpcs());
			Panel_derecho_sup.add(getLblMilisecsround());
			Panel_derecho_sup.add(getTxtNmilis());
			Panel_derecho_sup.add(getLblPokmons());
			Panel_derecho_sup.add(getTxtNpokemosn());
		}
		return Panel_derecho_sup;
	}
	private JPanel getPanel_derecho_inf() {
		if (panel_derecho_inf == null) {
			panel_derecho_inf = new JPanel();
			panel_derecho_inf.setLayout(null);
			panel_derecho_inf.add(getBtnNewButton());
			panel_derecho_inf.add(getBtnNewButton_1());
			panel_derecho_inf.add(getBtnJugar());
		}
		return panel_derecho_inf;
	}
	private JLabel getLblJugadores() {
		if (lblJugadores == null) {
			lblJugadores = new JLabel("Jugadores");
		}
		return lblJugadores;
	}
	private JTextField getTxtNjuga() {
		if (txtNjuga == null) {
			txtNjuga = new JTextField();
			txtNjuga.setText("1");
			txtNjuga.setColumns(10);
		}
		return txtNjuga;
	}
	private JLabel getLblNpcs() {
		if (lblNpcs == null) {
			lblNpcs = new JLabel("NPCs");
		}
		return lblNpcs;
	}
	private JTextField getTxtNnpcs() {
		if (txtNnpcs == null) {
			txtNnpcs = new JTextField();
			txtNnpcs.setText("1");
			txtNnpcs.setColumns(10);
		}
		return txtNnpcs;
	}
	private JLabel getLblMilisecsround() {
		if (lblMilisecsround == null) {
			lblMilisecsround = new JLabel("miliSecs/round");
		}
		return lblMilisecsround;
	}
	private JTextField getTxtNmilis() {
		if (txtNmilis == null) {
			txtNmilis = new JTextField();
			txtNmilis.setText("2000");
			txtNmilis.setColumns(10);
		}
		return txtNmilis;
	}
	private JLabel getLblPokmons() {
		if (lblPokmons == null) {
			lblPokmons = new JLabel("PoKéMoNs");
		}
		return lblPokmons;
	}
	private JTextField getTxtNpokemosn() {
		if (txtNpokemosn == null) {
			txtNpokemosn = new JTextField();
			txtNpokemosn.setEditable(false);
			txtNpokemosn.setText("3");
			txtNpokemosn.setColumns(10);
		}
		return txtNpokemosn;
	}
	private JButton getBtnNewButton() {
		if (readme == null) {
			readme = new JButton("ReadMe");
			readme.setBounds(24, 31, 93, 25);
		}
		return readme;
	}
	private JButton getBtnNewButton_1() {
		if (cerrar == null) {
			cerrar = new JButton("Cerrar");
			cerrar.setBounds(123, 31, 93, 25);
			cerrar.addActionListener(getControler());
		}
		return cerrar;
	}
	private JButton getBtnJugar() {
		if (btnJugar == null) {
			btnJugar = new JButton("Jugar");
			btnJugar.setBounds(61, 68, 117, 51);
			btnJugar.addActionListener(getControler());
		}
		return btnJugar;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon("sprites/main.png"));
		}
		return label;
	}
	private JLabel getLblTienesQueMeter() {
		if (lblError == null) {
			lblError = new JLabel("Tienes que meter un nº de Jugadores y/o NPCs validos");
			lblError.setForeground(Color.RED);
			lblError.setVisible(false);
		}
		return lblError;
	}
	
	private Controler getControler() {
		if(controler == null) {
			controler = new Controler();
		}
		return controler;
	}
	private class Controler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnJugar)) {
				int nJug = Integer.parseInt(txtNjuga.getText());
				int nNPC = Integer.parseInt(txtNnpcs.getText());
				int nPok = Integer.parseInt(txtNpokemosn.getText());
				if((nJug>=1 && nNPC>=1) || (nJug>=2)) {
					ListaJugadores.getListaJugadores().iniciarJuego(nJug, nNPC, nPok);
					for (int i=0; i<nJug+nNPC; i++) {
						for (int j=1; j<=nPok;j++) {
							ListaJugadores.getListaJugadores().buscarJugador(i).getPokemon(j).establecerValores();
							System.out.println("Pokemon ataque "+ ListaJugadores.getListaJugadores().buscarJugador(i).getPokemon(j).getAtaque());
						}
					}
				}else {
					lblError.setVisible(true);
				}
				
			}
			if(e.getSource().equals(cerrar)) {
				System.exit(0);
			}
			if(e.getSource().equals(readme)) {
				ReadMe readme = new ReadMe();
				readme.setVisible(true);
			}
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		int nJug = Integer.parseInt(txtNjuga.getText());
		int nNPC = Integer.parseInt(txtNnpcs.getText());
		int nPok = Integer.parseInt(txtNpokemosn.getText());

		for(int i=0;i<nJug+nNPC;i++) {
			
			Vista_Jugador VistaJug;
			//VistaJug.setVisible(true);
			if (ListaJugadores.getListaJugadores().buscarJugador(i).esSuTurno())
			{
				VistaJug = new Vista_Jugador(nPok, i, true);
				System.out.println("Es true");
			}
			else {
				VistaJug = new Vista_Jugador(nPok, i, false);
				System.out.println("Es false");
			}
			VistaJug.setVisible(true);
		}
		
	}
		/*
		for(int j=nJug;j<nJug+nNPC;j++) {
			Vista_Jugador VistaJug;
			//Vista_Jugador VistaJug = new Vista_Jugador(nPok, j, false);
			//VistaJug.setVisible(true);
			if (ListaJugadores.getListaJugadores().buscarJugador(j).esSuTurno())
			{
				VistaJug = new Vista_Jugador(nPok, j, true);
			}
			else
				VistaJug = new Vista_Jugador(nPok, j, false);
				
			VistaJug.setVisible(true);
		}
		*/

}
