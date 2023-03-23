package Modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class Jugador extends Observable {
	
	protected int id;
	protected ArrayList<Pokemon> lPokemon;

	/**
	 * 
	 * @param pNumPoke
	 */
	
	public Jugador(int pNumPoke, int pId) {
		id = pId;
		for (int i=0;i<pNumPoke;i++) {
			Pokemon pokeAct = this.createPokemon();
			lPokemon.add(pokeAct);
		}
	}

	
	private Iterator<Pokemon> getIterador() {
		return lPokemon.iterator();
	}
	
	
	/**
	 * 
	 * @param int numPoke,Pokemon pokJuega
	 */
	
	public void realizarAtaque(int numPoke,Pokemon pokJuega) { /*Hacer con Java8*/
		// TODO - implement Jugador.realizarAtaques
		// comprobar que no ha jugado antes en su turno 
		Pokemon atacante = lPokemon.get(numPoke);
		boolean haRealizadoAtaque = false; /*DUDA*/
		if(atacante != null && !haRealizadoAtaque) {
			 haRealizadoAtaque = CampoDeBatalla.getCampoBatalla().realizarAtaques(atacante, pokJuega); /*DUDA*/
		}
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

}