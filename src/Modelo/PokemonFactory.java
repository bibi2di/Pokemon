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
		/*int r = (int)(Math.random()*5); 
		String nombre = new String[] {"Agua", "Fuego", "Planta", "Electrico"}[r]; //tipo aleatorio
		if (nombre == "Agua") {Pokemon pokeAct = new Agua();}
		else if (nombre == "Fuego") {Pokemon pokeAct = new Fuego();}
		else if (nombre == "Planta") {Pokemon pokeAct = new Planta();}
		else if (nombre == "Electrico") {Pokemon pokeAct = new Electrico();}*/
		return pokeAct;
	}

}