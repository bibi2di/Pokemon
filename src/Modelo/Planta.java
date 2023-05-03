package Modelo;

public class Planta extends Pokemon {


	/**
	 * 
	 * @param pTipoEfectivo
	 */
	public Planta(int i) {
		// TODO - implement Planta.Planta
		super(i);
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return pTipo.equals("Electrico") || pTipo.equals("Roca");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Fuego") || pTipo.equals("Volador") || pTipo.equals("Bicho");
	}

}