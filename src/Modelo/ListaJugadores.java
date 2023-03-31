package Modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable; 

public class ListaJugadores extends Observable{

	private static ListaJugadores miListaJugadores;
	//private HashMap<Integer,Jugador> lJugadores;
	private ArrayList<Jugador> lJugadores;

	private ListaJugadores() {
		this.lJugadores = new ArrayList<>();
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
		for(int j=pNumJug;j<pNumJug+pNumBot;j++) {
			Bot botAct = new Bot(pNumPoke,j);
			miListaJugadores.anadirBot(botAct);
		}
		this.asignarTurnoAleatoriamente();
		setChanged();
		notifyObservers();
	}

	/**
	 * 
	 * @param pNumJug
	 */
	private void anadirJugador(Jugador pJugador) {
		//lJugadores.put(pId,pJugador);
		lJugadores.add(pJugador);
	}

	/**
	 * 
	 * @param pNumBot
	 */
	private void anadirBot(Bot pBot) {
		//lJugadores.put(pId,pBot);
		lJugadores.add(pBot);
	}
	
	public boolean finJuego() {
		//return lJugadores.stream().filter(p->!p.haPerdido()).toList().size()==1;
		return true;
	}
	
	public int jugadorGanador() {
		int id = -1;
		if (miListaJugadores.finJuego()) {
			//id = lJugadores.stream().filter(p->!p.haPerdido()).toList().get(0).getId();
			//id =  lJugadores.stream().filter(p->!p.haPerdido()).mapToInt(p->p.getId()).toArray()[0];
		}
		return id;
	}
	
	public void /*Jugador*/ asignarTurnoAleatoriamente(/*int pNumJug, int pNumBot*/) {
		int numJug = lJugadores.size(); //2
		int turno = (int)(Math.random()*(numJug)); // Num aleatorio del listado de Jugadores del 0 al 1
		
		//Primero inicializamos los turnos de todos los jugadores a 0
		Jugador jug = null;
		Iterator<Jugador> itr = getIterador();
		while (itr.hasNext())
		{
			jug = itr.next();
			jug.setTurno(false);
		}
		//Finalmente, elegimos un jugador al azar y le ponemos el turno a true
		jug = this.buscarJugador(turno);
		jug.setTurno(true);
		System.out.println("Turno asignado");
		//return jug;
		
		
	}
	
	public Jugador buscarJugador (int pId) {
		boolean esta = false;
		Iterator<Jugador> itr = this.getIterador();
		Jugador jugador = null;
		while(itr.hasNext()&&!esta) {
		    jugador = itr.next();
			if(jugador.tieneElMismoId(pId)) {
				esta = true;
			}
		}
		return jugador;
	}
	
}