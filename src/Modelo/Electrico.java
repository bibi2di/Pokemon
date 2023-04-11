package Modelo;
public class Electrico extends Pokemon {

	private String tipo;

	/**
	 * 
	 * @param pTipoEfectivo
	 */
	public Electrico(int i) {
		super(i);
		tipo = "Electrico";
		
	}

	@Override
	public boolean esEfectivo(String pTipo) {
		return pTipo.equals("Agua");
	}

	@Override
	public boolean esPocoEfectivo(String pTipo) {
		return pTipo.equals("Planta");
	}

}