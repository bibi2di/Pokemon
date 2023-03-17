package Modelo;
public abstract class Pokemon {

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
		ataque = 11 + (int)(Math.random()*7+1); //11 + número aleatorio entre 1-10
		defensa = 3 + (int)(Math.random()*4+1); //11 + número aleatorio entre 1-4
		vida = 200 + (int)(Math.random()*20+1); //200 + número aleatorio entre 1-20
		int r = (int)(Math.random()*5); 
		String nombre = new String[] {"Agua", "Fuego", "Planta", "Electrico"}[r]; //tipo aleatorio
		tipo = nombre;
	}

	/**
	 * 
	 * @param pTipo
	 */
	public void atacar(String pTipo) {
		// TODO - implement Pokemon.atacar
		throw new UnsupportedOperationException();
	}

	public boolean seHaDebilitado() {
		
		boolean debilitado = false;
		if (vida == 0)
			debilitado = true;
		return debilitado;
	}
	
	public void evolucionar() {
		
	}
	
	public void estadoEuforia() {
		
	}
}