package fabricas;

public class FabricaSpritesModoAlternativo extends FabricaSprites {

	public FabricaSpritesModoAlternativo(String rutaACarpeta) {
		super(rutaACarpeta);
	}
	
	public Sprite getSilueta(int numNivel) {
		return new Sprite(rutaACarpeta + "/FabricaSpritesModoAlternativo/fondo-" + numNivel + ".png");
	}
	
	public Sprite getMario() {
		return new Sprite(rutaACarpeta + "/FabricaSpritesModoAlternativo/mario.png");
	}
	
	public Sprite getLadrillo() {
		return new Sprite(rutaACarpeta + "/FabricaSpritesModoAlternativo/ladrillo.png");
	}

	public Sprite getSpiny() {
		return new Sprite(rutaACarpeta + "/FabricaSpritesModoAlternativo/spiny.png");
	}

	public Sprite getPiranhaPlant() {
		return new Sprite(rutaACarpeta + "/FabricaSpritesModoAlternativo/piranhaplant.png");
	}

	public Sprite getLakitu() {
		return new Sprite(rutaACarpeta + "/FabricaSpritesModoAlternativo/lakitu.png");
	}

	public Sprite getBuzzyBeetle() {
		return new Sprite(rutaACarpeta + "/FabricaSpritesModoAlternativo/buzzybeetle.png");
	}

	public Sprite getGoomba() {
		return new Sprite(rutaACarpeta + "/FabricaSpritesModoAlternativo/goomba.png");
	}

	public Sprite getBowser() {
		return new Sprite(rutaACarpeta + "/FabricaSpritesModoAlternativo/bowser.png");
	}

	public Sprite getEstrella() {
		return new Sprite(rutaACarpeta + "/FabricaSpritesModoAlternativo/estrella.png");
	}
	
	public Sprite getChampinionVerde() {
		return new Sprite(rutaACarpeta + "/FabricaSpritesModoAlternativo/champinionverde.png");
	}

	public Sprite getFlorDeFuego() {
		return new Sprite(rutaACarpeta + "/FabricaSpritesModoAlternativo/flordefuego.png");
	}

	public Sprite getSuperChampinion() {
		return new Sprite(rutaACarpeta + "/FabricaSpritesModoAlternativo/superchampinion.png");
	}

	public Sprite getMonedas() {
		return new Sprite(rutaACarpeta + "/FabricaSpritesModoAlternativo/monedas.png");
	}
	
}
