package Modelo;
public class Roca extends Pokemon {

	/**
	 * 
	 * @param pTipoEfectivo
	 */
	public Roca(int i) {
		super(i);
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return pTipo.equals("Volador") || pTipo.equals("Bicho") || pTipo.equals("Fuego") || pTipo.equals("Hielo");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Planta") || pTipo.equals("Lucha") || pTipo.equals("Acero");
	}

}