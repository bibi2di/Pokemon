package Vista_Controlador;
/*
 * A
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import Modelo.CampoDeBatalla;
import Modelo.Evolucion;
import Modelo.Evolucion1;
import Modelo.Evolucion2;
import Modelo.ListaJugadores;
import Modelo.Pokemon;

@SuppressWarnings("deprecation")
public class Panel_Pokemon extends JPanel implements Observer {
	private Controler controler;
	private JPanel Panel_Pokemons_Inf_Health;
	private JPanel Panel_Pokemons_Inf_ChargedAttack;
	private JLabel lbl_Health_bar;
	private JProgressBar progCharBar;
	private JLabel label_1;
	private JLabel lblAtt;
	private JLabel lab_att;
	private JLabel lblDef;
	private JLabel lab_Def;
	private JLabel lblHealth_1;
	private JLabel lab_health;
	private JLabel lblType;
	private JLabel lab_type;
	private JProgressBar progressBar; // Barra de progreso
	private int idJug = -1;
	private int idPok = -1;
	private int primeraVida;
	private int cont;
	private boolean pVidaBool = false;
	
	public Panel_Pokemon(int nPok, int nJug) {
		ListaJugadores.getListaJugadores().buscarJugador(nJug).getPokemon(nPok).addObserver(this);
		this.addMouseListener(getControler());
		idJug = nJug;
		idPok = nPok;
	}
	
	public int getIdPok() {
		return this.idPok;
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
		Panel_Pokemons_Inf_Health.setBackground(Color.GRAY);
		return Panel_Pokemons_Inf_Health;
	}
	
	public JPanel getPanel_Pokemons_Inf_ChargedAttack() {
		Panel_Pokemons_Inf_ChargedAttack = new JPanel();
		Panel_Pokemons_Inf_ChargedAttack.add(getLblChargedAttack());
		Panel_Pokemons_Inf_ChargedAttack.setBackground(Color.GRAY);
		return Panel_Pokemons_Inf_ChargedAttack;
	}
	public JProgressBar getLbl_Health_bar() {
		progressBar = new JProgressBar();
		return progressBar;
	}
	public JProgressBar getLblChargedAttack() {
		progCharBar = new JProgressBar();
		return progCharBar;
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
		label_1.addMouseListener(getControler());
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
	private JProgressBar getProgressBar() {
		progressBar = new JProgressBar();
		return progressBar;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) { /*Este panel es solo para los Pokemon*/
		// TODO Auto-generated method stub
		//this.vidaIni = ListaJugadores.getListaJugadores().buscarJugador(idJug).getPokemon(idPok).getVidaIni();
		if (arg0 instanceof Pokemon) {
			if (arg1 instanceof int[]) {
				int[] intArray = (int []) arg1;
				int vida = (Integer)intArray[0];
				int defensaPokAtacado = (Integer)intArray[1];
				int ataquePokAtacado = (Integer)intArray[2];
				int turnosEuforiaTotales = (Integer)intArray[3];
				int turnosEuforiaActuales = (Integer)intArray[4];
				lab_att.setText(String.valueOf(ataquePokAtacado));
				lab_Def.setText(String.valueOf(defensaPokAtacado));
				lab_health.setText(String.valueOf(vida));
				progCharBar.setValue(turnosEuforiaActuales);
				progressBar.setValue(vida);
				progCharBar.setMaximum(turnosEuforiaTotales);
				progCharBar.setValue(turnosEuforiaActuales);
				progCharBar.setForeground(Color.BLUE);
				progCharBar.setString("Charged Attack");
				progCharBar.setStringPainted(true);
				double porcentajeVida = 0;
				porcentajeVida = ((double) vida / (double) primeraVida);
				if (porcentajeVida<=0.2) {
					progressBar.setForeground(Color.RED);
				}else if(porcentajeVida<=0.5) {
					progressBar.setForeground(Color.ORANGE);
				}
				double porcentajeEuforia = 0;
				porcentajeEuforia = ((double) turnosEuforiaActuales / (double) turnosEuforiaTotales);
				
				
				//System.out.println("Ataque realizado");
				Panel_Pokemons_Inf_ChargedAttack.setBackground(Color.GRAY);
				if(vida==0) {
					System.out.println("COLOR CAMBIADO PORQUE ESTÁ ELIMINADO");
					Panel_Pokemons_Inf_ChargedAttack.setBackground(Color.RED);
					
				}
			}
			else if (arg1 instanceof boolean[]) {
				boolean[] boolArray = (boolean[])arg1;
				boolean ataqueEuforico = boolArray[0];
				System.out.println("Ha ejecutado el instanceof boolean[]");
				System.out.println(" El ataqueEuforico es? " + ataqueEuforico);
				if (ataqueEuforico) {
					String ataqueS = lab_att.getText();
					int ataque = Integer.parseInt(ataqueS);
					String defensaS = lab_Def.getText();
					int defensa = Integer.parseInt(defensaS);
					if (ataque>=100 && defensa>=100) {
						ataque = ataque -100;
						defensa = defensa-100;
						lab_att.setText(String.valueOf(ataque));
						lab_Def.setText(String.valueOf(defensa));
						progCharBar.setValue(0);
					}
				}
			}
			else if (arg1 instanceof Evolucion[]) {
				Evolucion[] evArray = (Evolucion[]) arg1;
				Evolucion ev = evArray[0];
				if (ev!= null) {
					if (lab_type.getText().equals("Planta") && (ev instanceof Evolucion1)){
						label_1.setIcon(new ImageIcon("sprites/Grass/1ivysaur.png"));
					}
					else if(lab_type.getText().equals("Planta") && (ev instanceof Evolucion2)) {
						label_1.setIcon(new ImageIcon("sprites/Grass/2venusaur.png"));
					}
					else if(lab_type.getText().equals("Fuego") && (ev instanceof Evolucion1)) {
						label_1.setIcon(new ImageIcon("sprites/Fire/1charmeleon.png"));
					}
					else if(lab_type.getText().equals("Fuego") && (ev instanceof Evolucion2)) {
						label_1.setIcon(new ImageIcon("sprites/Fire/2charizard.png"));
					}
					else if(lab_type.getText().equals("Agua") && (ev instanceof Evolucion1)) {
						label_1.setIcon(new ImageIcon("sprites/Water/1wartortle.png"));
					}
					else if(lab_type.getText().equals("Agua") && (ev instanceof Evolucion2)) {
						label_1.setIcon(new ImageIcon("sprites/Water/2blastoise.png"));
					}
					else if(lab_type.getText().equals("Electrico") && (ev instanceof Evolucion1)) {
						label_1.setIcon(new ImageIcon("sprites/Electric/1raichu.png"));
					}
					else if(lab_type.getText().equals("Electrico") && (ev instanceof Evolucion2)) {
						label_1.setIcon(new ImageIcon("sprites/Electric/2raichu2.png"));
					}
				}
			}
			
			else if (arg1 instanceof Object []) {
				Object[] objecArray = (Object []) arg1;
				int vida = (Integer)objecArray[0];
				int defensa = (Integer)objecArray[1];
				int ataque = (Integer)objecArray[2];
				String tipo = (String)objecArray[3];
				lab_att.setText(String.valueOf(ataque));
				lab_Def.setText(String.valueOf(defensa));
				lab_health.setText(String.valueOf(vida));
				lab_type.setText(tipo);
				if (tipo.equals("Planta")) {
					label_1.setIcon(new ImageIcon("sprites/Grass/0bulbasaur.png"));
				}
				else if (tipo.equals("Fuego")) {
					label_1.setIcon(new ImageIcon("sprites/Fire/0charmander.png"));
				}
				else if (tipo.equals("Agua")) {
					label_1.setIcon(new ImageIcon("sprites/Water/0squirtle.png"));
				}
				else if(tipo.equals("Electrico")) {
					label_1.setIcon(new ImageIcon("sprites/Electric/0pikachu.png"));
				}
				//System.out.println("Observer actualizado");
				if(!pVidaBool) {
					pVidaBool = true;
					primeraVida = vida;
					progressBar.setMaximum(vida);
					progressBar.setValue(vida);
					progressBar.setForeground(Color.GREEN);
					progressBar.setString("Health");
					progressBar.setStringPainted(true);
					
				}
			}
		}
	}
	
	private Controler getControler() {
		if(controler == null) {
			controler = new Controler();
		}
		return controler;
	}
	
	private class Controler implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			//if(e.getSource().equals(this)) {
				CampoDeBatalla.getCampoBatalla().sePuedeAtacar(idPok, idJug);
				System.out.println(" Se ha clickado el pokemon" + idPok + "del jugador" + idJug);
				//ListaJugadores.getListaJugadores().buscarJugador(idJug).getPokemon(idPok).haAtacadoEuforico();
				cont++;
				System.out.println("El valor de cont es" + cont);
				if (cont==1 && idJug!=1) /*El bot lo gestiona de otra manera*/ {
					System.out.println("Entra en el if vista 1 y el id del jugador atacante es: " + idJug + " y el id del pokemon atacante es: " + idPok);
					ListaJugadores.getListaJugadores().buscarJugador(idJug).getPokemon(idPok).estaEuforico();
				}
				else if (cont==2) {
					cont = 0;
				}
		}
			
		

		@Override
		public void mousePressed(MouseEvent e) {
			int vida = Integer.parseInt(lab_health.getText());
			if(vida!=0) {
				Panel_Pokemons_Inf_ChargedAttack.setBackground(Color.YELLOW);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			int vida = Integer.parseInt(lab_health.getText());
			if(vida!=0) {
				Panel_Pokemons_Inf_ChargedAttack.setBackground(Color.GRAY);	
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		}
		
		
		public void atributos(int numPok, int nJug) {
				//lab_att.setText(String.valueOf(ListaJugadores.getListaJugadores().buscarJugador(nJug).getPokemon(numPok).getAtaque()));
				//lab_Def.setText(String.valueOf(ListaJugadores.getListaJugadores().buscarJugador(nJug).getPokemon(numPok).getDefensa()));
				//lab_health.setText(String.valueOf(ListaJugadores.getListaJugadores().buscarJugador(nJug).getPokemon(numPok).getVida()));
		}
}