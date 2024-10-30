package fabricas;

import elementos.Silueta;

public class FabricaSiluetaModoOriginal extends FabricaSilueta {

	public FabricaSiluetaModoOriginal(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	@Override
	public Silueta obtenerSilueta() {
		return new Silueta(rutaACarpeta + "/siluetaModoOriginal/silueta.png");
	}

}
