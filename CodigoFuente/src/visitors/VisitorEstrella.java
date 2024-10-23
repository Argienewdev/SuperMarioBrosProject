package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorEstrella implements Visitante {
	
	protected Estrella miEntidad;
	
	public VisitorEstrella (Estrella miEntidad) {
		this.miEntidad = miEntidad;
	}

    public void visitar(BuzzyBeetle buzzy) {
    }

    public void visitar(Spiny spiny) {
    }

    public void visitar(Goomba goomba) {
    }

    public void visitar(Lakitu lakitu) {
    }

    public void visitar(PiranhaPlant planta) {
    }

    public void visitar(Fireball fireball) {
    }

    public void visitar(SuperChampinion superChamp) {
    }

    public void visitar(FlorDeFuego flor) {
    }

    public void visitar(ChampinionVerde champVerde) {
    }

    public void visitar(Estrella estrella) {
    }

    public void visitar(Monedas moneda) {
    }
    
    @Override
	public void visitar(ContextoMario contextoMario) {
		contextoMario.getEstado().aceptarVisitante(this);
	}
	
	@Override
	public void visitar(MarioDefault marioDefault) {
		ContextoMario contextoMario= marioDefault.getContext();
		EstadoMario nuevoEstado=new MarioInvulnerable();
		contextoMario.cambiarEstado(nuevoEstado);
		contextoMario.ganarPuntos(miEntidad.obtenerPuntosPorDefault());
	}

	@Override
	public void visitar(SuperMario superMario) {
		ContextoMario contextoMario= superMario.getContext();
		EstadoMario nuevoEstado=new MarioInvulnerable();
		contextoMario.cambiarEstado(nuevoEstado);
		contextoMario.ganarPuntos(miEntidad.obtenerPuntosPorSuper());
	}

	@Override
	public void visitar(MarioFuego marioFuego) {
		ContextoMario contextoMario= marioFuego.getContext();
		EstadoMario nuevoEstado=new MarioInvulnerable();
		contextoMario.cambiarEstado(nuevoEstado);
		contextoMario.ganarPuntos(miEntidad.obtenerPuntosPorFuego());
	}

	@Override
	public void visitar(MarioInvulnerable marioInvulnerable) {
		ContextoMario contextoMario = marioInvulnerable.getContext();
		contextoMario.ganarPuntos(miEntidad.obtenerPuntosPorInvulnerable());
	}

    public void visitar(BloqueDePregunta bloquePregunta) {
    }

    public void visitar(Ladrillo ladrillo) {
    }

    public void visitar(Vacio vacio) {
    }

    public void visitar(PrincesaPeach princesa) {
    }

    public void visitar(Bandera bandera) {
    }

    public void visitar(Tuberia tuberia) {
    }

    public void visitar(BloqueSolido bloqueSolido) {
    }

    public void visitar(ContextoKoopaTroopa contextoKoopa) {
    }

	@Override
	public void visitar(KoopaEnCaparazon koopaEnCaparazon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(KoopaDefault koopaDefault) {
		// TODO Auto-generated method stub
		
	}
}
