package Modelo;

import java.util.Observable;

@SuppressWarnings("deprecation")
public /*abstract*/ class Pokemon extends Observable {

	private int ataque;
	private int defensa;
	private int vida;
	private String tipo;
	protected String tipoEfectivo;

	/**
	 * 
	 * @param pTipo
	 */
	public Pokemon() {
		// TODO - implement Pokemon.Pokemon
		ataque = 11 + (int)(Math.random()*7+1); //11 + número aleatorio entre 1-7
		defensa = 3 + (int)(Math.random()*4+1); //11 + número aleatorio entre 1-4
		vida = 200 + (int)(Math.random()*20+1); //200 + número aleatorio entre 1-20
		int r = (int)(Math.random()*4); 
		String nombre = new String[] {"Agua", "Fuego", "Planta", "Electrico"}[r]; //tipo aleatorio
		tipo = nombre;
	
	}

	/**
	 * 
	 * @param pTipo
	 */
	public void recibirAtaque(Pokemon pPokemon) {
		int multiplicador = 1;
		this.vida = this.vida -(pPokemon.ataque*multiplicador) - this.defensa;
		setChanged();
		notifyObservers(new Object [] {this.vida,this.defensa,this.ataque,tipo});
	}

	public boolean seHaDebilitado() {
		boolean debilitado = false;
		if (vida == 0)
			debilitado = true;
		return debilitado;
		/*setChanged();
		notifyObservers(new Object[] {debilitado});*/
	}
	
	public void evolucionar() {
		
	}
	
	public void estadoEuforia() {
		
	}
	
}