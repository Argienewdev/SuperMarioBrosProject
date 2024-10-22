package fabricas;

import elementos.Silueta;

public class FabricaSiluetaModoOriginal extends FabricaSilueta {

	public FabricaSiluetaModoOriginal(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	@Override
	public Silueta getSilueta() {
		return new Silueta(rutaACarpeta + "/siluetaModoOriginal/silueta.png");
	}

}
