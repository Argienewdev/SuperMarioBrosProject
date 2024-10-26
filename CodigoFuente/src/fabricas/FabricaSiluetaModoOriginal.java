package fabricas;

import elementos.Silueta;

public class FabricaSiluetaModoOriginal extends FabricaSilueta {

	public FabricaSiluetaModoOriginal(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	@Override
	public Silueta getSilueta() {
		System.out.println("Entre a la fabrica siluetas modo original");
		return new Silueta(rutaACarpeta + "/siluetaModoOriginal/silueta.png");
	}

}
