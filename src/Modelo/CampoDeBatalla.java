package Modelo;

import java.lang.reflect.Array;
import java.util.Observable;

public class CampoDeBatalla extends Observable{
	
	private static CampoDeBatalla miCampoDeBatalla;
	private Pokemon[] batalla;
	
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
		int idJug = -1;
		boolean sePuedeAtacar = false;
		if(batalla[0]==null) {
			batalla[0]=pPok;
			idJug = nJug;
		}else {
			batalla[1]=pPok;
		}
		if (ListaJugadores.getListaJugadores().buscarJugador(idJug).esSuTurno()) {
			if(batalla[0]!=null && batalla[1]!=null && !batalla[0].haAtacado()) {
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
