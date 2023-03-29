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
	
	public boolean sePuedeAtacar(Pokemon pPok) {
		//TODO Falta comprobar si es el turno del Jugador
		boolean sePuedeAacar = false;
		if(batalla[0]==null) {
			batalla[0]=pPok;
		}else {
			batalla[1]=pPok;
		}
		if(batalla[0]!=null && batalla[1]!=null) {
			realizarAtaques(batalla[0], batalla[1]);
			batalla = new Pokemon[2];
			sePuedeAacar=true;
		}
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
