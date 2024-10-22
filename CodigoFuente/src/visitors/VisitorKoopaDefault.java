package visitors;
import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
public class VisitorKoopaDefault implements Visitante {
	
	protected KoopaDefault miEntidad;
	
	public VisitorKoopaDefault (KoopaDefault miEntidad) {
		this.miEntidad = miEntidad;
	}

	@Override
	public void visitar(BuzzyBeetle buzzy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Spiny spiny) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Goomba goomba) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(KoopaCaparazonEstatico koopaEstatico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(KoopaCaparazonMovil koopaMovil) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(KoopaDefault koopaDefault) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Lakitu lakitu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(PiranhaPlant planta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Fireball fireball) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(SuperChampinion superChamp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(FlorDeFuego flor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ChampinionVerde champVerde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Estrella estrella) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Monedas moneda) {
		// TODO Auto-generated method stub
		
	}

	public void visitar(MarioDefault marioNormal) {
        ContextoMario contextoMario = marioNormal.getContext();
        if (contextoMario.getVidas() == 1) {
            ContextoKoopaTroopa contextoTroopa = miEntidad.getContext();
            int perdidaPuntos = contextoTroopa.getPuntosSustraidosPorMuerteCausada();
            contextoMario.perderPuntos(perdidaPuntos);
        }
        contextoMario.perderVida();
    }

    public void visitar(MarioInvulnerable marioInv) {
    	
    }

    public void visitar(MarioFuego marioFuego) {
        ContextoMario contexto = marioFuego.getContext();
        EstadoMario estado = new SuperMario();
        contexto.cambiarEstado(estado);
    }

    public void visitar(SuperMario superMario) {
        ContextoMario contexto = superMario.getContext();
        EstadoMario estado = new MarioDefault();
        contexto.cambiarEstado(estado);
    }


	@Override
	public void visitar(BloqueDePregunta bloquePregunta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Ladrillo ladrillo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Vacio vacio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(PrincesaPeach princesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Bandera bandera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Tuberia tuberia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(BloqueSolido bloqueSolido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ContextoMario contextoMario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(ContextoKoopaTroopa contextoKoopa) {
		// TODO Auto-generated method stub
		
	}

	
}
