package fabricas;

import elementos.Sprite;

public abstract class FabricaSprites {
	
	protected String rutaACarpeta;
	
	public FabricaSprites(String rutaACarpeta) {
		this.rutaACarpeta = rutaACarpeta;
	}
	public abstract Sprite getMarioDefaultFrontalQuieto();
		
	public abstract Sprite getMarioDefaultFrontalCaminando();
	
	public abstract Sprite getMarioDefaultCayendo();

	public abstract Sprite getMarioDefaultFrontalSaltando();
	
	public abstract Sprite getMarioDefaultReversoQuieto();
	
	public abstract Sprite getMarioDefaultReversoCaminando();
	
	public abstract Sprite getMarioDefaultReversoSaltando();
	
	public abstract Sprite getSuperMarioFrontalQuieto();
	
	public abstract Sprite getSuperMarioFrontalCaminando();
		
	public abstract Sprite getSuperMarioFrontalSaltando();
	
	public abstract Sprite getSuperMarioReversoQuieto();
	
	public abstract Sprite getSuperMarioCayendo();
	
	public abstract Sprite getSuperMarioReversoCaminando();
	
	public abstract Sprite getSuperMarioReversoSaltando();
	
	public abstract Sprite getMarioFuegoFrontalQuieto();
	
	public abstract Sprite getMarioFuegoFrontalCaminando();
		
	public abstract Sprite getMarioFuegoFrontalSaltando();
	
	public abstract Sprite getMarioFuegoReversoQuieto();
	
	public abstract Sprite getMarioFuegoReversoCaminando();
	
	public abstract Sprite getMarioFuegoReversoSaltando();
	
	public abstract Sprite getMarioFuegoCayendo();
	
	public abstract Sprite getMarioInvulnerableFrontalQuieto();
	
	public abstract Sprite getMarioInvulnerableFrontalCaminando();
		
	public abstract Sprite getMarioInvulnerableFrontalSaltando();
	
	public abstract Sprite getMarioInvulnerableCayendo();
	
	public abstract Sprite getMarioInvulnerableReversoQuieto();
	
	public abstract Sprite getMarioInvulnerableReversoCaminando();
	
	public abstract Sprite getMarioInvulnerableReversoSaltando();
	
	public abstract Sprite getKoopaTroopaDefaultFrontalQuieto();
	
	public abstract Sprite getKoopaTroopaDefaultFrontalCaminando();
	
	public abstract Sprite getKoopaTroopaDefaultReversoQuieto();
	
	public abstract Sprite getKoopaTroopaDefaultReversoCaminando();
	
	public abstract Sprite getKoopaTroopaCaparazonEstático();
	
	public abstract Sprite getGoombaCaminandoPrimeraTransicion();
	
	public abstract Sprite getGoombaCaminandoSegundaTransicion();
	
	public abstract Sprite getGoombaAplastado();

	public abstract Sprite getPiranhaPlantCerrada();
	
	public abstract Sprite getPiranhaPlantAbierta();

	public abstract Sprite getLakituFrontalFueraDeLaNube();
	
	public abstract Sprite getLakituDentroDeLaNube();

	public abstract Sprite getLakituReversoFueraDeLaNube();
	
	public abstract Sprite getSpinyAntesDeCaerPrimeraTransicion();
	
	public abstract Sprite getSpinyAntesDeCaerSegundaTransicion();
	
	public abstract Sprite getSpinyFrontalQuieto();
	
	public abstract Sprite getSpinyFrontalCaminando();
	
	public abstract Sprite getSpinyReversoQuieto();
	
	public abstract Sprite getSpinyReversoCaminando();

	public abstract Sprite getBuzzyBeetleFrontalQuieto();
	
	public abstract Sprite getBuzzyBeetleFrontalCaminando();
	
	public abstract Sprite getBuzzyBeetleReversoQuieto();
	
	public abstract Sprite getBuzzyBeetleReversoCaminando();

	public abstract Sprite getEstrellaApagada();
	
	public abstract Sprite getEstrellaEncendida();
	
	public abstract Sprite getFlorDeFuegoPrimeraTransicion();
	
	public abstract Sprite getFlorDeFuegoSegundaTransicion();
	
	public abstract Sprite getChampinionVerde();

	public abstract Sprite getSuperChampinionSaliendoDelBloqueDePreguntas();
	
	public abstract Sprite getSuperChampinionQuieto();
	
	public abstract Sprite getMonedaApagada();

	public abstract Sprite getMonedaEncendida();
	
	public abstract Sprite getFireballPrimeraTransicion();
	
	public abstract Sprite getFireballSegundaTransicion();
	
	public abstract Sprite getLadrillo();
	
	public abstract Sprite getBloqueSolido();
	
	public abstract Sprite getPiso();
	
	public abstract Sprite getTuberia(int altura);
	
	public abstract Sprite getBloqueDePreguntaApagado();
	
	public abstract Sprite getBloqueDePreguntaEncendido();
	
	public abstract Sprite getBandera();
	
	public abstract Sprite getVacio();
	
	public abstract Sprite getPrincesaPeach();
	
	public abstract Sprite getSpriteInvisible();
}
