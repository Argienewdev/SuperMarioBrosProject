package visitors;

import elementos.enemigos.*;
import elementos.entidades.Fireball;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public interface Visitante {
	
	public void visitar(BuzzyBeetle buzzy);

	public void visitar(Spiny spiny);

	public void visitar(Goomba goomba);
	
	public void visitar(ContextoKoopaTroopa contextoKoopa);
	
	public void visitar(KoopaEnCaparazon koopaEnCaparazon);

	public void visitar(KoopaDefault koopaDefault);
	
	public void visitar(Lakitu lakitu);
	
	public void visitar(PiranhaPlant planta);
	
	public void visitar(Fireball fireball);
	
	public void visitar(SuperChampinion superChamp);
	
	public void visitar(FlorDeFuego flor);

	public void visitar(ChampinionVerde champVerde);
	
	public void visitar(Estrella estrella);
	
	public void visitar(Monedas monedas);

	public void visitar(BloqueDePregunta bloquePregunta);

	public void visitar(Ladrillo ladrillo);
	
	public void visitar(PrincesaPeach princesa);

	public void visitar(Bandera bandera);
	
	public void visitar(Tuberia tuberia);

	public void visitar(BloqueSolido bloqueSolido);

	public void visitar(Piso piso);
	
	public void visitar(ContextoMario contextoMario);
	
	public void visitar(MarioDefault marioDefault);
	
	public void visitar(SuperMario superMario);

	public void visitar(MarioFuego marioFuego);
	
	public void visitar(MarioInvulnerable marioInvulnerable);
	
}
