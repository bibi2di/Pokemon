package Modelo;

public class Tierra extends Pokemon {

	protected Tierra(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return pTipo.equals("Electrico") || pTipo.equals("Roca") || pTipo.equals("Fuego") || pTipo.equals("Veneno") || pTipo.equals("Acero");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Planta") || pTipo.equals("Bicho") || pTipo.equals("Volador");
	}

}
