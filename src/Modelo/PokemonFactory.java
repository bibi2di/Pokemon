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
		int r = (int)(Math.random()*/*18*/13); 
		String nombre = new String[] {"Agua", "Fuego", "Planta", "Electrico", "Bicho", "Volador", "Psiquico", "Roca", "Fantasma", "Lucha", "Acero", "Dragon",/* "Hada", "Siniestro", "Normal",*/ "Veneno"/*, "Tierra", "Hielo"*/ }[r]; //tipo aleatorio
		Pokemon pokeAct = null;
		//System.out.println("El tipo de Pokemon es: " + nombre);
		if (nombre == "Agua") {pokeAct = new Agua(i);}
		else if (nombre == "Fuego") {pokeAct = new Fuego(i);}
		else if (nombre == "Planta") {pokeAct = new Planta(i);}
		else if (nombre == "Electrico") {pokeAct = new Electrico(i);}
		else if (nombre == "Bicho") {pokeAct = new Bicho(i);}
		else if (nombre == "Volador") {pokeAct = new Volador(i);}
		else if (nombre == "Psiquico") {pokeAct = new Psiquico(i);}
		else if (nombre == "Roca") {pokeAct = new Roca(i);}
		else if (nombre == "Fantasma") {pokeAct = new Fantasma(i);}
		else if (nombre == "Lucha") {pokeAct = new Lucha(i);}
		else if (nombre == "Acero") {pokeAct = new Acero(i);}
		else if (nombre == "Dragon") {pokeAct = new Dragon(i);}
		else if (nombre == "Hada") {pokeAct = new Hada(i);}
		else if (nombre == "Siniestro") {pokeAct = new Siniestro(i);}
		else if (nombre == "Normal") {pokeAct = new Normal(i);}
		else if (nombre == "Veneno") {pokeAct = new Veneno(i);}
		else if (nombre == "Tierra") {pokeAct = new Tierra(i);}
		else if (nombre == "Hielo") {pokeAct = new Hielo(i);}
		return pokeAct;
	}

}