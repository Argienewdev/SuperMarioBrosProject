package elementos.enemigos;

import java.awt.Point;

import fabricas.FabricaSprites;
import visitors.Visitante;
import visitors.VisitorKoopaDefault;

public class KoopaDefault implements EstadoKoopa {
	
	protected ContextoKoopaTroopa contexto;
	
	public void establecerContexto(ContextoKoopaTroopa contexto) {
		this.contexto = contexto;
	}
	
	@Override
	public void invertirDireccion() {
    	Point velocidad = new Point(-this.contexto.obtenerVelocidadDireccional().x, this.contexto.obtenerVelocidadDireccional().y);
    	this.contexto.establecerVelocidadDireccional(velocidad);
    }

	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarKoopaDefault(this);
    }

	public ContextoKoopaTroopa getContext() {
		return this.contexto;
	}
	public Visitante obtenerVisitante() {
		return new VisitorKoopaDefault(this);
	}
	
	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(this.getContext().obtenerRemovido()) {
			this.getContext().establecerVelocidadDireccional(new Point(0, 0));
			eliminarEntidadGrafica(fabricaSprites);
		} else if(this.getContext().obtenerVelocidadDireccional().x < 0) {
			this.getContext().establecerSprite(fabricaSprites.getKoopaTroopaDefaultReversoCaminando());
		} else if(this.getContext().obtenerVelocidadDireccional().x > 0) {
			this.getContext().establecerSprite(fabricaSprites.getKoopaTroopaDefaultFrontalCaminando());
		}
	}
	
	public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
    	this.getContext().incrementarContadorTicks();
		if(this.getContext().getContadorTicks() == 1){
			this.getContext().establecerSprite(this.getContext().obtenerSpriteDeMuerte(fabricaSprites));
			this.actualizarHitboxYPosicion(fabricaSprites);
		} else if(this.getContext().getContadorTicks() == this.getContext().getTicksAnimacion()) {
			this.getContext().establecerSprite(fabricaSprites.getSpriteInvisible());
			this.getContext().eliminarDelNivel();
		}
	}

	@Override
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {		
	}
	
	@Override
	public void mover() {
		if (this.contexto.obtenerVelocidadDireccional().x <= 0) {
			moverIzquierda();
		} else if (this.contexto.obtenerVelocidadDireccional().x > 0) {
			moverDerecha();
		}
	}
	
	
	private void moverDerecha() {
		Point velocidad = new Point(this.contexto.obtenerVelocidadHorizontalEnemigo(), this.contexto.obtenerVelocidadDireccional().y);
    	this.contexto.establecerVelocidadDireccional(velocidad);
    }
    
    private void moverIzquierda() {
    	Point velocidad = new Point(-this.contexto.obtenerVelocidadHorizontalEnemigo(), this.contexto.obtenerVelocidadDireccional().y);
    	this.contexto.establecerVelocidadDireccional(velocidad);
    }

}
