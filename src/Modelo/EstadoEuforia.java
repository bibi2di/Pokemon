package Modelo;

public class EstadoEuforia implements Estado {

	@Override
	public void estadoEuforia(Pokemon pPokemon) {
		int ataque = pPokemon.getAtaque();
		int defensa = pPokemon.getDefensa();
		if (ataque<100 && defensa<100) {
			pPokemon.setAtaque(ataque+100);
			pPokemon.setDefensa(defensa+100);
		}
	}

}
