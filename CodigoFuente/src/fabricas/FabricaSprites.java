package fabricas;

public abstract class FabricaSprites {
	protected String rutaACarpeta;
	
	public FabricaSprites(String rutaACarpeta) {
		this.rutaACarpeta=rutaACarpeta;
	}
	
	public abstract Sprite getSilueta(int numNivel); 
	
	public abstract Sprite getMario();
	
	public abstract Sprite getSuperMario();
	
	public abstract Sprite getMarioInvulnerable();
	
	public abstract Sprite getMarioFuego();
	
	public abstract Sprite getSpiny();
	
	public abstract Sprite getLakitu();
	
	public abstract Sprite getGoomba();
	
	public abstract Sprite getPiranhaPlant();
	
	public abstract Sprite getBuzzyBeetle();
	
	public abstract Sprite getKoopa();
	
	public abstract Sprite getKoopaCaparazonEstatico();
	
	public abstract Sprite getKoopaCaparazonMovil();
	
	public abstract Sprite getBowser();
	
	public abstract Sprite getChampinionVerde();
	
	public abstract Sprite getSuperChampinion();
	
	public abstract Sprite getEstrella();
	
	public abstract Sprite getFlorDeFuego();
	
	public abstract Sprite getFireball();
	
	public abstract Sprite getTuberia();
	
	public abstract Sprite getLadrillo();
	
	public abstract Sprite getVacio();
	
	public abstract Sprite getBloqueSolido();
	
	public abstract Sprite getBloqueDePregunta();
	
	public abstract Sprite getBandera();
	
	public abstract Sprite getPrincesaPeach();
	
	public abstract Sprite getPiso();
	
	
	
	
}
