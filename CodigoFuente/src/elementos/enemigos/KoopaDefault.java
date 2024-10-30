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
		if(this.contexto.obtenerVelocidadDireccional().x < 0) {
			this.contexto.establecerSprite(fabricaSprites.getKoopaTroopaDefaultReversoCaminando());
		} else if(this.contexto.obtenerVelocidadDireccional().x > 0) {
			this.contexto.establecerSprite(fabricaSprites.getKoopaTroopaDefaultFrontalCaminando());
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
