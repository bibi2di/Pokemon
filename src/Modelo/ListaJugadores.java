package Modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable; 

public class ListaJugadores extends Observable{

	private static ListaJugadores miListaJugadores;
	private HashMap<Integer,Jugador> lJugadores;
	//private Collection<Jugador> lJugadores;

	private ListaJugadores() {
		this.lJugadores = new HashMap<Integer,Jugador>();
	}

	public static ListaJugadores getListaJugadores() {
		if(miListaJugadores == null) {
			miListaJugadores = new ListaJugadores();
		}
		return miListaJugadores;
	}

	/*private Iterator<Integer> getIterador() {
		return lJugadores.iterator();
	}*/

	
	/**
	 * 
	 * @param pNumJug
	 * @param pNumBot
	 * @param pNumPoke
	 */
	public void iniciarJuego(int pNumJug, int pNumBot, int pNumPoke) {
		for(int i=0;i<pNumJug;i++) {
			Jugador jugAct = new Jugador(pNumPoke,i);
			miListaJugadores.anadirJugador(i,jugAct);
			//miListaJugadores.anadirJugador(jugAct);
		}
		for(int j=pNumJug;j<pNumJug+pNumBot;j++) {
			Bot botAct = new Bot(pNumPoke,j);
			miListaJugadores.anadirBot(j,botAct);
			//miListaJugadores.anadirJugador(jugAct);
		}
		setChanged();
		notifyObservers();
	}

	/**
	 * 
	 * @param pNumJug
	 */
	private void anadirJugador(int pId, Jugador pJugador) {
		lJugadores.put(pId,pJugador);
		//lJugadores.add(pJugador);
	}

	/**
	 * 
	 * @param pNumBot
	 */
	private void anadirBot(int pId, Bot pBot) {
		lJugadores.put(pId,pBot);
		//lJugadores.add(pBot);
	}
	
	
	public Jugador asignarTurnoAleatoriamente(int pNumJug, int pNumBot) {
		int numJug = pNumJug + pNumBot;
		int turno = (int)(Math.random()*(numJug-1)+1); // Num aleatorio del listado de Jugadores
		Jugador jug = null;
		//Iterator<Jugador> itr = this.getIterador();
		int act = 0;
		for (int id=0;act<turno && id<pNumJug+pNumBot;id++) {
			act++;
			jug= miListaJugadores.buscarJugador(id);
		}
		/*while (act < turno) {
			act++;
			jug=itr.next();
		} */
		return jug; 		
	}
	
	private Jugador buscarJugador (int pId) {
		return lJugadores.get(pId);
	}
}