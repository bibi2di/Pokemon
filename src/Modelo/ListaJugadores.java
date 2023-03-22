package Modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ListaJugadores {

	private static ListaJugadores miListaJugadores;
	private Collection<Jugador> lJugadores;

	private ListaJugadores() {
		this.lJugadores = new ArrayList<Jugador>();
	}

	public static ListaJugadores getListaJugadores() {
		if(miListaJugadores == null) {
			miListaJugadores = new ListaJugadores();
		}
		return miListaJugadores;
	}

	private Iterator<Jugador> getIterador() {
		return lJugadores.iterator();
	}

	
	/**
	 * 
	 * @param pNumJug
	 * @param pNumBot
	 * @param pNumPoke
	 */
	public void iniciarJuego(int pNumJug, int pNumBot, int pNumPoke) {
		for(int i=0;i<pNumJug;i++) {
			Jugador jugAct = new Jugador(pNumPoke);
			miListaJugadores.anadirJugador(jugAct);
		}
		for(int j=0;j<pNumBot;j++) {
			Bot botAct = new Bot(pNumPoke);
			miListaJugadores.anadirBot(botAct);
		}
	}

	
	/**
	 * 
	 * @param pNumJug
	 */
	private void anadirJugador(Jugador pJugador) {
		lJugadores.add(pJugador);
	}

	/**
	 * 
	 * @param pNumBot
	 */
	private void anadirBot(Bot pBot) {
		lJugadores.add(pBot);
	}
	
	private boolean pasaTurno() {
		// TODO - implement Jugador.pasarTurno
		throw new UnsupportedOperationException();
	}
	
	public Jugador asignarTurnoAleatoriamente() {
		
		// emplea pasaTurno() 
		// TODO - implement ListaJugadores.asignarTurnoAleatoriamente
		throw new UnsupportedOperationException();
	}



	private boolean finJuego() {
		throw new UnsupportedOperationException();
	}

}