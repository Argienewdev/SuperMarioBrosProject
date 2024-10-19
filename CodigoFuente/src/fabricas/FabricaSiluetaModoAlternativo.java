package fabricas;

import elementos.Silueta;

public class FabricaSiluetaModoAlternativo extends FabricaSilueta {

	public FabricaSiluetaModoAlternativo(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	@Override
	public Silueta getSilueta() {
		return new Silueta(rutaACarpeta + "../imagenes/siluetas/siluetaModoAlternativo/silueta.png");
	}

}
