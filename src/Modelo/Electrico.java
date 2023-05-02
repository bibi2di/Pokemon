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
		return pTipo.equals("Agua");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Planta");
	}

}