package Modelo;

import java.lang.reflect.Array;
import java.util.Observable;

public class CampoDeBatalla extends Observable{
	
	private static CampoDeBatalla miCampoDeBatalla;
	private Pokemon[] batalla;
	private int jugadorAtacante;
	
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
		System.out.println("juagdor"+nJug);
		System.out.println("pokemon"+nPok);
		Pokemon pPok = ListaJugadores.getListaJugadores().buscarJugador(nJug).getPokemon(nPok);
		boolean sePuedeAtacar = false;
		if(batalla[0]==null) {
			batalla[0]=pPok;
			jugadorAtacante = nJug;
			System.out.println("Ha entrado en el if 1. El id del jugador es "+ jugadorAtacante);
		}else {
			batalla[1]=pPok;
			System.out.println("Ha entrado en el if 2. El id del jugador es "+ jugadorAtacante);
		}
		if (ListaJugadores.getListaJugadores().buscarJugador(jugadorAtacante).esSuTurno() && (nJug!=jugadorAtacante)) {
			System.out.println("Ha entrado en if 3. Es su turno");
			if(batalla[0]!=null && batalla[1]!=null && !batalla[0].haAtacado()) {
				System.out.println("Ha entrado en el if 4. Va a atacar");
				realizarAtaques(batalla[0], batalla[1]);
				batalla[0].haAtacadoYa(true);
				batalla = new Pokemon[2];
				sePuedeAtacar=true;
			}
		}
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
	
	
}
