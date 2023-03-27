package Modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;

@SuppressWarnings("deprecation")

public class Jugador extends Observable {
	
	protected int id;
	protected ArrayList<Pokemon> lPokemon;
	private boolean turno;

	/**
	 * 
	 * @param pNumPoke
	 */
	
	public Jugador(int pNumPoke, int pId) {
		lPokemon = new ArrayList<>();
		id = pId;
		turno = false;
		for (int i=0;i<pNumPoke;i++) {
			Pokemon pokeAct = this.createPokemon();
			lPokemon.add(pokeAct);
		}
		//setChanged();
		//notifyObservers();
	}

	
	private Iterator<Pokemon> getIterador() {
		return lPokemon.iterator();
	}
	
	public boolean tieneElMismoId(int pId) {
		return pId==this.id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setTurno(boolean pTurno) {
		this.turno = pTurno;
	}
	
	
	
	/**
	 * 
	 * @param int numPoke,Pokemon pokJuega
	 */
	
	public boolean esSuTurno() {
		return this.turno;
		
	}
	
	public boolean realizarAtaque(int numPoke,Pokemon pokJuega) { 
		Pokemon atacante = lPokemon.get(numPoke);
		boolean haRealizadoAtaque = false;
		if(atacante != null && !haRealizadoAtaque) {
			 haRealizadoAtaque = CampoDeBatalla.getCampoBatalla().realizarAtaques(atacante, pokJuega); 
		}
		return haRealizadoAtaque;
	}
	
	/*REALIZAR ATAQUES*/

	/**
	 * 
	 * @param tipo
	 */
	private Pokemon createPokemon() {
		Pokemon p = PokemonFactory.getPokemonFactory().create();
		return p;
	}
	
	public boolean haPerdido() {
		return lPokemon.stream().allMatch(p -> p.seHaDebilitado());
	}
	
	public Pokemon getPokemon(int numPok) {
		int i = 0;
		Pokemon poke = null;
		
		while (i < numPok) {
			poke = this.getIterador().next();
		}
		return poke;
	}
	

}