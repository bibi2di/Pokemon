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
			Jugador jugAct = new Jugador(pNumPoke,i);
			miListaJugadores.anadirJugador(jugAct);
		}
		for(int j=0;j<pNumBot;j++) {
			Bot botAct = new Bot(pNumPoke,j);
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
	
	
	public Jugador asignarTurnoAleatoriamente(int pNumJug, int pNumBot) {
		int numJug = pNumJug + pNumBot;
		int turno = (int)(Math.random()*(numJug-1)+1); // Num aleatorio del listado de Jugadores
		Jugador jug = null;
		Iterator<Jugador> itr = this.getIterador();
		int act = 0;
		while (act < turno) {
			act++;
			jug=itr.next();
		} 
		return jug; 		
	}

}