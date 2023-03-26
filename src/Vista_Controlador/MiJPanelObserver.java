package Vista_Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

/*
 * Clase del Observer
 */
import java.util.Observer;

import javax.swing.JPanel;

import Modelo.CampoDeBatalla;
import Modelo.Jugador;
import Modelo.ListaJugadores;
import Modelo.Pokemon;

@SuppressWarnings("deprecation")
public class MiJPanelObserver extends JPanel implements Observer {
	private Controler controler = null;
	private JPanel PanelObserver;
	/*Hace falta meter en la constructora de este panel
	 * ListaJugadores.getListaJugadores().get(nPoke).addObserver(this);
	 */
	
	public MiJPanelObserver(/*int nPok*/) {
		PanelObserver = new JPanel();
		//ListaJugadores.getListaJugadores().buscarJugador(nJug).get(nPoke).addObserver(this);
		
	}
	
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