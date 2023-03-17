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

	/**
	 * 
	 * @param cPoke
	 */
	public void realizarAtaques(Collection<Pokemon> cPoke) { /*Hacer con Java8*/
		// TODO - implement Jugador.realizarAtaques
		throw new UnsupportedOperationException();
	}

	public boolean pasarTurno() {
		// TODO - implement Jugador.pasarTurno
		throw new UnsupportedOperationException();
	}

	public Iterator<Pokemon> getIterador() {
		return lPokemon.iterator();
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

}