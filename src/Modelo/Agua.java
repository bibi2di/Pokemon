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
	public boolean recibeAtaqueEfectivo(String pTipo) {
		System.out.println("El pokemon de tipo: " + tipo + "recibe ataque de Pokemon: " + pTipo + "y es efectivo es: " + pTipo.equals("Electrico"));
		return pTipo.equals("Fuego");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Electrico");
	}

}