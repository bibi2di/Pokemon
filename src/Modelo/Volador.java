package Modelo;
public class Volador extends Pokemon {
	/**
	 * 
	 * @param pTipoEfectivo
	 */
	public Volador(int i) {
		super(i);
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return (pTipo.equals("Planta") || pTipo.equals("Bicho"));
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return (pTipo.equals("Roca"));
	}

}