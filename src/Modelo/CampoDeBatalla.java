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
		Pokemon pPok = ListaJugadores.getListaJugadores().buscarJugador(nJug).getPokemon(nPok);
		boolean sePuedeAacar = false;
		if(batalla[0]==null) {
			batalla[0]=pPok;
			System.out.println("pokemon1");
		}else {
			batalla[1]=pPok;
			System.out.println("pokemon2");
		}
		if(batalla[0]!=null && batalla[1]!=null) {
			realizarAtaques(batalla[0], batalla[1]);
			batalla = new Pokemon[2];
			sePuedeAacar=true;
		}
		setChanged();
		notifyObservers();
		return sePuedeAacar;
		
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
