package Vista_Controlador;

import java.util.Observable;

/*
 * Clase del Observer
 */
import java.util.Observer;

import javax.swing.JPanel;

import Modelo.Jugador;
import Modelo.Pokemon;

public class MiJPanelObserver extends JPanel implements Observer {

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		if (arg0 instanceof Pokemon) {
			//ataque
			
		}else if (arg0 instanceof Jugador) {
			
		}

	}

}