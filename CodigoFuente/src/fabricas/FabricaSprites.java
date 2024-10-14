package fabricas;
import elementos.*;
import juego.Silueta;
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
	

}
