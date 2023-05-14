package Modelo;
public class Electrico extends Pokemon {

	/**
	 * 
	 * @param pTipoEfectivo
	 */
	public Electrico(int i) {
		super(i);
		
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo){
		return pTipo.equals("Agua") || pTipo.equals("Volador");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Planta") || pTipo.equals("Tierra");
	}

}