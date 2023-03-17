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

	public void asignarTurnoAleatoriamente() {
		// TODO - implement ListaJugadores.asignarTurnoAleatoriamente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pNumJug
	 * @param pNumBot
	 * @param pNumPoke
	 */
	public void iniciarJuego(int pNumJug, int pNumBot, int pNumPoke) {
		// TODO - implement ListaJugadores.iniciarJuego
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pNumJug
	 */
	public void anadirJugador(int pNumJug) {
		// TODO - implement ListaJugadores.anadirJugador
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pNumBot
	 */
	public void anadirBot(int pNumBot) {
		// TODO - implement ListaJugadores.anadirBot
		throw new UnsupportedOperationException();
	}

}