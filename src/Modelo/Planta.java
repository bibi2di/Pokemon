package Modelo;

public class Planta extends Pokemon {

	private String tipo;

	/**
	 * 
	 * @param pTipoEfectivo
	 */
	public Planta(int i) {
		// TODO - implement Planta.Planta
		super(i);
		tipo = "Planta";
	}

	@Override
	public boolean esEfectivo(String pTipo) {
		return pTipo.equals("Electrico");
	}

	@Override
	public boolean esPocoEfectivo(String pTipo) {
		return pTipo.equals("Fuego");
	}

}