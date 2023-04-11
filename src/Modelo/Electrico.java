package Modelo;
public class Electrico extends Pokemon {

	private String tipo;

	/**
	 * 
	 * @param pTipoEfectivo
	 */
	public Electrico(int i) {
		super(i);
		tipo = "Electrico";
		
	}

	@Override
	public boolean recibeAtaqueEfectivo(String pTipo){
		System.out.println("El pokemon de tipo: " + tipo + "recibe ataque de Pokemon: " + pTipo + "y es efectivo es: " + pTipo.equals("Planta"));
		return pTipo.equals("Planta");
	}

	@Override
	public boolean recibeAtaquePocoEfectivo(String pTipo) {
		return pTipo.equals("Agua");
	}

}