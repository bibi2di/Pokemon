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
	public boolean recibeAtaqueEfectivo(String pTipo) {
		System.out.println("El pokemon de tipo: " + tipo + "recibe ataque de Pokemon: " + pTipo + "y es efectivo es: " + pTipo.equals("Fuego"));
		return pTipo.equals("Electrico");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Fuego");
	}

}