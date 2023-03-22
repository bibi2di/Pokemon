package Modelo;

import java.util.Collection;
import java.util.Iterator;

public class Jugador {

	private Collection<Pokemon> lPokemon;

	/**
	 * 
	 * @param pNumPoke
	 */
	
	public Jugador(int pNumPoke) {
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
	 * @param cPoke
	 */
	
	public void realizarAtaques(Pokemon pokJuega) { /*Hacer con Java8*/
		// TODO - implement Jugador.realizarAtaques
		
		// comprobar que no ha jugado antes en su turno 
		
		throw new UnsupportedOperationException();
	}



	/**
	 * 
	 * @param pPokemon
	 */
	private void anadirPokemon(Pokemon pPokemon) {
		lPokemon.add(pPokemon);
	}

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