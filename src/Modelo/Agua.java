package Modelo;
public class Agua extends Pokemon {

	private String tipo;

	/**
	 * 
	 * @param pTipoEfectivo
	 */
	public Agua(int i) {
		super(i);
		tipo = "Agua";
		// TODO - implement Agua.Agua
	}

	@Override
	public boolean esEfectivo(String pTipo) {
		System.out.println(pTipo);
		System.out.println(pTipo.equals("Fuego"));
		return pTipo.equals("Fuego");
	}

	@Override
	public boolean esPocoEfectivo(String pTipo) {
		return pTipo.equals("Electrico");
	}

}