package visitors;

public interface Visitante {
	public void visitarBowser(Bowser bowser);
	
	public void visitarVisitorBuzzyBeetle(BuzzyBeetle buzzy);
	
	public void visitarSpiny(Spiny spiny);
	
	public void visitarGoomba(Goomba goomba);
	
	public void visitarKoopaCaparazonEstatico(KoopaCaparazonEstatico koopaEstatico);
	
	public void visitarKoopaCaparazonMovil(KoopaCaparazonMovil koopaMovil);
	
	public void visitarKoopaDefault(KoopaDefault koopaDefault);
	
	public void visitarLakitu(Lakitu lakitu);
	
	public void visitarPiranhaPlant(PiranhaPlant planta);
	
	public void visitarFireball(Fireball fireball);
	
	public void visitarSuperChampinion(SuperChampinion superChamp);
	
	public void visitarFlorDeFuego(FlorDeFuego flor);
	
	public void visitarChampinionVerde(ChampinionVerde champVerde);
	
	public void visitarEstrella(Estrella estrella);
	
	public void visitarMonedas(Monedas monedas);
	
	public void visitarMarioDefault(MarioDefault marioNormal);
	
	public void visitarMarioInvulnerable(MarioInvulnerable marioInv);
	
	public void visitarMarioFuego(MarioFuego marioFuego);
	
	public void visitarSuperMario(SuperMario superMario);
	
	public void visitarBloqueDePregunta(BloqueDePregunta bloquePregunta);
	
	public void visitarLadrillo(Ladrillo ladrillo);
	
	public void visitarVacio(Vacio vacio);
	
	public void visitarPrincesaPeach(PrincesaPeach princesa);
	
	public void visitarBandera(Bandera bandera);
	
	public void visitarTuberia(Tuberia tuberia);
	
	public void visitarPiso(Piso piso);
}
