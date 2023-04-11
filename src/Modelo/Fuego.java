package Modelo;
public class Fuego extends Pokemon {

	private String tipo;

	/**
	 * 
	 * @param pTipoEfectivo
	 */
	public Fuego(int i) {
		super(i);
		tipo = "Fuego";
	}

	@Override
	public boolean esEfectivo(String pTipo) {
		return pTipo.equals("Planta");
	}

	@Override
	public boolean esPocoEfectivo(String pTipo) {
		return pTipo.equals("Agua");
	}

}