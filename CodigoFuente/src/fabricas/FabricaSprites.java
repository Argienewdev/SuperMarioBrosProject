package fabricas;

public abstract class FabricaSprites {
	protected String rutaACarpeta;
	
	public FabricaSprites(String rutaACarpeta) {
		this.rutaACarpeta=rutaACarpeta;
	}
	
	public Sprite getSilueta(int numNivel) {
		return new Sprite(rutaACarpeta + "/fondo-"+numNivel+".png");
	}
	
	public Sprite getMario() {
		return new Sprite(rutaACarpeta + "/mario.png");
	}
	public Sprite getLadrillo() {
		return new Sprite(rutaACarpeta + "/ladrillo.png");
	}

	public Sprite getSpiny() {
		return new Sprite(rutaACarpeta + "/spiny.png");
	}

	public Sprite getPiranhaPlant() {
		return new Sprite(rutaACarpeta + "/piranhaplant.png");
	}

	public Sprite getLakitu() {
		return new Sprite(rutaACarpeta + "/lakitu.png");
	}

	public Sprite getBuzzyBeetle() {
		return new Sprite(rutaACarpeta + "/buzzybeetle.png");
	}

	public Sprite getGoomba() {
		return new Sprite(rutaACarpeta + "/goomba.png");
	}

	public Sprite getBowser() {
		return new Sprite(rutaACarpeta + "/bowser.png");
	}

	public Sprite getEstrella() {
		return new Sprite(rutaACarpeta + "/estrella.png");
	}
	
	public Sprite getChampinionVerde() {
		return new Sprite(rutaACarpeta + "/champinionverde.png");
	}

	public Sprite getFlorDeFuego() {
		return new Sprite(rutaACarpeta + "/flordefuego.png");
	}

	public Sprite getSuperChampinion() {
		return new Sprite(rutaACarpeta + "/superchampinion.png");
	}

	public Sprite getMonedas() {
		return new Sprite(rutaACarpeta + "/monedas.png");
	}


	


}
