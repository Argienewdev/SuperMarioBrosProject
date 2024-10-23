package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public class VisitorChampinionVerde implements Visitante {
	
	protected ChampinionVerde miEntidad;
	
	public VisitorChampinionVerde (ChampinionVerde miEntidad) {
		this.miEntidad = miEntidad;
	}

    public VisitorChampinionVerde() {
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
    
    public void visitar(ContextoMario contextoMario) {
    	contextoMario.ganarVida();
    	//Se gana la misma cantidad de puntos en cualquier estado
    	contextoMario.ganarPuntos(miEntidad.obtenerPuntosPorDefault());
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
}
