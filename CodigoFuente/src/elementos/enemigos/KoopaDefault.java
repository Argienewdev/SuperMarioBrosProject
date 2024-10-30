package elementos.enemigos;

import java.awt.Point;

import fabricas.FabricaSprites;
import visitors.Visitante;
import visitors.VisitorKoopaDefault;

public class KoopaDefault implements EstadoKoopa {
	
	protected ContextoKoopaTroopa contexto;
	
	public void setContext(ContextoKoopaTroopa contexto) {
		this.contexto = contexto;
	}
	
	@Override
	public void invertirDireccion() {
    	Point velocidad = new Point(-this.contexto.getVelocidadDireccional().x, this.contexto.getVelocidadDireccional().y);
    	this.contexto.setVelocidadDireccional(velocidad);
    }

	@Override
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarKoopaDefault(this);
    }

	public ContextoKoopaTroopa getContext() {
		return this.contexto;
	}
	public Visitante getVisitor() {
		return new VisitorKoopaDefault(this);
	}

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if(this.contexto.getVelocidadDireccional().x < 0) {
			this.contexto.setSprite(fabricaSprites.getKoopaTroopaDefaultReversoCaminando());
		} else if(this.contexto.getVelocidadDireccional().x > 0) {
			this.contexto.setSprite(fabricaSprites.getKoopaTroopaDefaultFrontalCaminando());
		}
	}

	@Override
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {		
	}
	
	@Override
	public void mover() {
		if (this.contexto.getVelocidadDireccional().x <= 0) {
			moverIzquierda();
		} else if (this.contexto.getVelocidadDireccional().x > 0) {
			moverDerecha();
		}
	}
	
	
	private void moverDerecha() {
		Point velocidad = new Point(this.contexto.getVelocidadHorizontalEnemigo(), this.contexto.getVelocidadDireccional().y);
    	this.contexto.setVelocidadDireccional(velocidad);
    }
    
    private void moverIzquierda() {
    	Point velocidad = new Point(-this.contexto.getVelocidadHorizontalEnemigo(), this.contexto.getVelocidadDireccional().y);
    	this.contexto.setVelocidadDireccional(velocidad);
    }

}
