package Modelo;

public class Evolucion2 implements Evolucion {

	@Override
	public void evolucionar(Pokemon pPokemon) {
		int ataque = pPokemon.getAtaque();
		int defensa = pPokemon.getDefensa();
		pPokemon.setAtaque(ataque+7);
		pPokemon.setDefensa(defensa+5);
		System.out.println("El pokemon ha evolucionado");
	}

}
