package Modelo;
public class Agua extends Pokemon {

	/**
	 * 
	 * @param pTipoEfectivo
	 */
	public Agua(int i) {
		super(i);
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return pTipo.equals("Fuego") || pTipo.equals("Roca");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Electrico");
	}

}