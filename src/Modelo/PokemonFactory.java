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
	public Pokemon create(int i) {
		int r = (int)(Math.random()*4); 
		String nombre = new String[] {"Agua", "Fuego", "Planta", "Electrico"}[r]; //tipo aleatorio
		Pokemon pokeAct = null;
		System.out.println("El tipo de Pokemon es: " + nombre);
		if (nombre == "Agua") {pokeAct = new Agua(i);}
		else if (nombre == "Fuego") {pokeAct = new Fuego(i);}
		else if (nombre == "Planta") {pokeAct = new Planta(i);}
		else if (nombre == "Electrico") {pokeAct = new Electrico(i);}
		return pokeAct;
	}

}