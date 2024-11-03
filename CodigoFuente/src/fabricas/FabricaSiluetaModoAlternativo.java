package fabricas;

import elementos.Silueta;

public class FabricaSiluetaModoAlternativo extends FabricaSilueta {

	public FabricaSiluetaModoAlternativo(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	public Silueta obtenerSilueta(int numeroNivel) {
		return new Silueta(rutaACarpeta + "/siluetaModoAlternativo/siluetaNivel-" + numeroNivel + ".png");
	}

}
