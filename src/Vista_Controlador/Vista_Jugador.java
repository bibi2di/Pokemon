package Vista_Controlador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Modelo.CampoDeBatalla;
import Modelo.Jugador;
import Modelo.ListaJugadores;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import java.awt.Toolkit;

@SuppressWarnings("deprecation")
public class Vista_Jugador extends JFrame implements Observer{
	private JPanel Panel_Jugador;
	private JPanel Panel_Jugador_Estado;
	private JButton btn_Jugador_estado;
	private JLabel label;
	/*private JPanel PanelPokemons;
	private JPanel PanelPokemons_Vis;
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
	private JLabel lab_type;*/
	private int idJug;
	private Controler controler = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista_Jugador frame = new Vista_Jugador(3, 2, false);
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
	public Vista_Jugador(int nPok, int nJug, boolean turno) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("sprites/pokebol.png"));
		Vista_Pokemon Vista_Pok = new Vista_Pokemon(/*nPok, nJug*/);
		idJug = nJug;
		setTitle("Pokemon - Jugador "+nJug);
		setBounds(100, 100, 800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel_Jugador(turno));
		getContentPane().add(Vista_Pok.getPanelPokemons(nPok, nJug));
		setResizable(false);
		ListaJugadores.getListaJugadores().buscarJugador(nJug).addObserver(this);

	}
	private JPanel getPanel_Jugador(boolean turno) {
		if (Panel_Jugador == null) {
			Panel_Jugador = new JPanel();
			Panel_Jugador.setBackground(new Color(255, 255, 255));
			Panel_Jugador.setBounds(0, 0, 200, 263);
			Panel_Jugador.setLayout(new BorderLayout(0, 0));
			Panel_Jugador.add(getPanel_Jugador_Estado(turno), BorderLayout.NORTH);
			Panel_Jugador.add(getLabel(), BorderLayout.CENTER);
		}
		return Panel_Jugador;
	}
	private JPanel getPanel_Jugador_Estado(boolean turno) {
		if (Panel_Jugador_Estado == null) {
		    Panel_Jugador_Estado = new JPanel();
		    if (turno) {
				Panel_Jugador_Estado.setBackground(Color.GREEN);
		    }
		    else {
				Panel_Jugador_Estado.setBackground(Color.RED);
		    }
			Panel_Jugador_Estado.add(getButton_Jugador_estado(turno));
		}
		return Panel_Jugador_Estado;
	}
	private JButton getButton_Jugador_estado(boolean turno) {
		if (btn_Jugador_estado == null) {
			if (turno == false) {
				btn_Jugador_estado = new JButton("Espera");
				System.out.println("Me toca esperar");
				}
			else
				{btn_Jugador_estado = new JButton("Ataca");
				System.out.println("Me toca atacar");
				}
			btn_Jugador_estado.setBorderPainted( false );
			btn_Jugador_estado.addActionListener(getControler());
		}
		return btn_Jugador_estado;
	}
	private JLabel getLabel() {
		String fotoEntr = "";
		int r = (int)(Math.random()*6); 
		fotoEntr = "sprites/trainer"+r+".png";
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		label.setIcon(new ImageIcon(getClass().getResource(fotoEntr)));
		return label;
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
				//CampoDeBatalla.getCampoBatalla().pasarTurno();
				if(e.getSource().equals(btn_Jugador_estado)) {
					if(btn_Jugador_estado.getText().equals("Ataca") && !esBot()) {
						asignarTurno();
					}
					
		}
		}
		private void asignarTurno() {
			ListaJugadores.getListaJugadores().asignarTurnoAleatoriamente();
		}
		public boolean esBot() {
			return ListaJugadores.getListaJugadores().buscarJugador(idJug).esBot();
		}
	}
	@Override
	public void update(Observable o, Object arg) { /*Este panel es solo para los jugadores*/
		if (o instanceof Jugador) {
			if (arg instanceof Object[]) {
				Object[] oArray = (Object[])arg;
				boolean turno = (boolean)oArray[0];
				if (turno == true) {
					btn_Jugador_estado.setText("Ataca");
					Panel_Jugador_Estado.setBackground(Color.GREEN);
				}
				else {
					btn_Jugador_estado.setText("Espera");
					Panel_Jugador_Estado.setBackground(Color.RED);
				}
			}
			if (arg instanceof boolean[]) {
				boolean[] arrayBool = (boolean[])arg;
				boolean perdido = (boolean)arrayBool[0];
				if(!perdido) {
					btn_Jugador_estado.setText("Ha Ganado");
					System.out.println("HA GANADO JUGADOR "+idJug);
					Panel_Jugador_Estado.setBackground(Color.YELLOW);
				}
				if (perdido) {
					System.out.println("El jugador: "+ idJug+ " ha perdido");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					this.setVisible(false);
				}
			}
		}		
	}
}