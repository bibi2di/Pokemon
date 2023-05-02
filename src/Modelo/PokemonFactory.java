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
		int r = (int)(Math.random()*8); 
		String nombre = new String[] {"Agua", "Fuego", "Planta", "Electrico", "Bicho", "Volador", "Psiquico", "Roca"}[r]; //tipo aleatorio
		Pokemon pokeAct = null;
		System.out.println("El tipo de Pokemon es: " + nombre);
		if (nombre == "Agua") {pokeAct = new Agua(i);}
		else if (nombre == "Fuego") {pokeAct = new Fuego(i);}
		else if (nombre == "Planta") {pokeAct = new Planta(i);}
		else if (nombre == "Electrico") {pokeAct = new Electrico(i);}
		else if (nombre == "Bicho") {pokeAct = new Bicho(i);}
		else if (nombre == "Volador") {pokeAct = new Volador(i);}
		else if (nombre == "Psiquico") {pokeAct = new Psiquico(i);}
		else if (nombre == "Roca") {pokeAct = new Roca(i);}
		return pokeAct;
	}

}