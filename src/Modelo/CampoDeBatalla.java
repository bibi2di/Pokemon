package Modelo;

import java.lang.reflect.Array;
import java.util.Observable;

public class CampoDeBatalla extends Observable{
	
	private static CampoDeBatalla miCampoDeBatalla;
	private Pokemon[] batalla;
	private int jugadorAtacante;
	private int jugadorAtacado;
	
	private CampoDeBatalla() {
		batalla = new Pokemon[2];
	}
	
	public static CampoDeBatalla getCampoBatalla() {
		if (miCampoDeBatalla==null) {
			miCampoDeBatalla = new CampoDeBatalla();
		}
		return miCampoDeBatalla;
	}
	
	public boolean sePuedeAtacar(int nPok, int nJug) {
		//TODO Falta comprobar si es el turno del Jugador
		System.out.println("jugador "+nJug);
		System.out.println("pokemon "+nPok);
		Pokemon pPok = ListaJugadores.getListaJugadores().buscarJugador(nJug).getPokemon(nPok);
		boolean sePuedeAtacar = false;
		//primero metemos el jugador atacante y su pokemon en batalla[0] 
		if(ListaJugadores.getListaJugadores().buscarJugador(nJug).esSuTurno() && batalla[0]==null) {
			batalla[0]=pPok; //se introduce 
			jugadorAtacante = nJug;
			System.out.println("Ha entrado en el if 1. El jugador atacante es "+ jugadorAtacante);
		//metemos el jugador atacado y su pokemon en batalla[1]
		}else if (!ListaJugadores.getListaJugadores().buscarJugador(nJug).esSuTurno() && batalla[1] == null){
			batalla[1]=pPok;
			jugadorAtacado = nJug;
			System.out.println("Ha entrado en el if 2. El id del jugador atacante es "+ jugadorAtacante + "Y el jugador atacado "
					+ jugadorAtacado);
		}
			if(batalla[0]!=null && batalla[1]!=null) {
				//si ambos pokemons son aptos, entra
				if (!batalla[0].haAtacado() && !batalla[0].seHaDebilitado() && !batalla[1].seHaDebilitado()) {
					//si el pokemon atacante no ha atacado y ninguno esta debilitado -> ataca
					System.out.println("Ha entrado en el if 4. Va a atacar");
					realizarAtaques(batalla[0], batalla[1]);
					batalla[0].haAtacadoYa(true);
					batalla = new Pokemon[2];
					sePuedeAtacar=true;
				}
				else 
				{
					//si el pokemon ha atacado con anterioridad, reestablece los valores
					batalla[0] = null;
					batalla[1] = null;
				}
			}
		if (ListaJugadores.getListaJugadores().buscarJugador(jugadorAtacante).terminarTurno())
			ListaJugadores.getListaJugadores().terminarTurno();
		setChanged();
		notifyObservers();
		return sePuedeAtacar;
		
	}
	
	public boolean realizarAtaques(Pokemon pPokemonAtaca, Pokemon pPokemonAtacado){
		boolean haRealizadoAtaque = false;
		if (!pPokemonAtaca.seHaDebilitado() && !pPokemonAtacado.seHaDebilitado()) {
			pPokemonAtacado.recibirAtaque(pPokemonAtaca);
			haRealizadoAtaque = true;
		}
		setChanged();
		notifyObservers();
		return haRealizadoAtaque;
	}
	
	
	public void teminarTurno(int pJug) {
		if (ListaJugadores.getListaJugadores().buscarJugador(pJug).terminarTurno())
			ListaJugadores.getListaJugadores().terminarTurno();
	}
	
	public void atacarBot (int id){
		if (ListaJugadores.getListaJugadores().buscarJugador(id).esBot() && ListaJugadores.getListaJugadores().buscarJugador(id).esSuTurno() ) {
			for(int i=1;i<=ListaJugadores.getListaJugadores().buscarJugador(id).tamainoLista();i++) {
				batalla[0]=ListaJugadores.getListaJugadores().buscarJugador(id).getPokemon(i);
				/*int numJug = ListaJugadores.getListaJugadores().tamainoLista();
				int jugadorAtac = (int)(Math.random()*(numJug));*/
				int jugadorAtacado = 0;
				int numPok = ListaJugadores.getListaJugadores().buscarJugador(jugadorAtacado).tamainoLista();
				int pokAtacado = (int)(Math.random()*(numPok));
				if (jugadorAtacado != id) {
					batalla[1] = ListaJugadores.getListaJugadores().buscarJugador(jugadorAtacado).getPokemon(pokAtacado);
					if (!batalla[0].haAtacado() && !batalla[0].seHaDebilitado() && !batalla[1].seHaDebilitado()) {
						realizarAtaques(batalla[0], batalla[1]);
						batalla[0].haAtacadoYa(true);
						batalla = new Pokemon[2];
					}
				}
			}
		}
	}
	
	
}
