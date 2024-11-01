package elementos.entidades;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import ventanas.ConstantesGlobales;
import visitors.Visitante;

public class BolaDeFuego extends NoJugable {
	
	private static final int GRAVEDAD_BOLA_DE_FUEGO = 1;

	private static final int FUERZA_REBOTE_BOLA_DE_FUEGO = 10;
	
	protected static final int VELOCIDAD_MAXIMA_DE_CAIDA = 7;
	
	protected Jugable miJugador;
	
	public BolaDeFuego(Sprite sprite, Point posicion, Visitante visitor, Point velocidadDireccional,
					ObserverGrafico observerGrafico,Jugable jugador) {
		super(sprite, posicion, visitor, observerGrafico);
		this.velocidadDireccional = velocidadDireccional;
		this.miJugador = jugador;
	}
	
	// Metodos
	@Override
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarBolaDeFuego(this);
	}

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if (this.obtenerRemovido()) {
			this.eliminarEntidadGrafica(fabricaSprites);
			this.eliminarDelNivel();
		}
	}
	
	public void rebotar() {
		int velocidadActualEnX = this.obtenerVelocidadDireccional().x;
		Point salto = new Point(velocidadActualEnX, -FUERZA_REBOTE_BOLA_DE_FUEGO);
		this.establecerVelocidadDireccional(salto);
	}
	
	public void aplicarGravedad() {
		if (this.obtenerVelocidadDireccional().y < VELOCIDAD_MAXIMA_DE_CAIDA){
			Point nuevaVelocidad = new Point(this.obtenerVelocidadDireccional().x, this.obtenerVelocidadDireccional().y + GRAVEDAD_BOLA_DE_FUEGO);
			this.establecerVelocidadDireccional(nuevaVelocidad);
		}
	}

	public Jugable obtenerJugador() {
		return miJugador;
	}

	
	@Override
	public void mover() {
	}

	@Override
	public void invertirDireccion() {
	}

	@Override
	public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
		this.establecerSprite(fabricaSprites.obtenerSpriteInvisible());
		this.obtenerNivel().agregarEntidadesAEliminar(this);
	}	
}
