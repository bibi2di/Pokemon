package Modelo;

public class Hielo extends Pokemon {

	protected Hielo(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		return pTipo.equals("Tierra") || pTipo.equals("Planta") || pTipo.equals("Dragon") || pTipo.equals("Volador");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Agua") || pTipo.equals("Fuego") || pTipo.equals("Acero") || pTipo.equals("Roca");
	}

}
