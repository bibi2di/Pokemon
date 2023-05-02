package Modelo;
public class Fuego extends Pokemon {

	/**
	 * 
	 * @param pTipoEfectivo
	 */
	public Fuego(int i) {
		super(i);
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return pTipo.equals("Planta");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Agua");
	}

}