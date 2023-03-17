package Modelo;
public class PokemonFactory {
	
	private static PokemonFactory miPokemonFactory;

	private PokemonFactory() {
		
	}

	public static PokemonFactory getPokemonFactory() {
		if (miPokemonFactory==null) {
			miPokemonFactory = new PokemonFactory();
		}
		return miPokemonFactory;
	}

	/**
	 * 
	 * @param tipo
	 */
	public Pokemon create() {
		Pokemon pokeAct = new Pokemon();
		return pokeAct;
	}

}