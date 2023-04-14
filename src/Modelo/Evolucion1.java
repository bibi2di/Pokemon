package Modelo;

public class Evolucion1 implements Evolucion {

	@Override
	public void evolucionar(Pokemon pPokemon) {
		int ataque = pPokemon.getAtaque();
		int defensa = pPokemon.getDefensa();
		pPokemon.setAtaque(ataque+5);
		pPokemon.setDefensa(defensa+3);
		System.out.println("El pokemon ha evolucionado");
	}

}
