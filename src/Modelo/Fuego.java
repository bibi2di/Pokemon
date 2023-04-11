package Modelo;
public class Fuego extends Pokemon {

	private String tipo;

	/**
	 * 
	 * @param pTipoEfectivo
	 */
	public Fuego(int i) {
		super(i);
		tipo = "Fuego";
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo) {
		System.out.println("El pokemon de tipo: " + tipo + "recibe ataque de Pokemon: " + pTipo + "y es efectivo es: " + pTipo.equals("Agua"));
		return pTipo.equals("Agua");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Planta");
	}

}