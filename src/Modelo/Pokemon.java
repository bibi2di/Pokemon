package Modelo;
public abstract class Pokemon {

	private int ataque;
	private int defensa;
	private int vida;
	private String tipo;
	private String tipoEfectivo;

	/**
	 * 
	 * @param pTipo
	 */
	public Pokemon(String pTipo, String pTipoEfectivo, int pAtaque, int pDefensa, int pVida) {
		// TODO - implement Pokemon.Pokemon
		
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
		// TODO - implement Pokemon.seHaDebilitado
		throw new UnsupportedOperationException();
	}

}