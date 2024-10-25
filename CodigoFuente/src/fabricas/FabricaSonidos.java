package fabricas;

import elementos.Sonido;

public abstract class FabricaSonidos {
	
	protected String rutaACarpeta;
	
	public FabricaSonidos(String rutaACarpeta) {
		this.rutaACarpeta = rutaACarpeta;
	}
	public abstract Sonido getAplastarEnemigo();
	
	public abstract Sonido getChoqueFireball();
	
	public abstract Sonido getDisparoBolaFuego();
	
	public abstract Sonido getGolpeBloque();
	
	public abstract Sonido getPowerUpEmerge();
	
	public abstract Sonido getMarioPequenioDeNuevo();
	
	public abstract Sonido getMatarBolaDeFuego();
	
	public abstract Sonido getModoInvencible();
	
	public abstract Sonido getSonidoMoneda();
	
	public abstract Sonido getPierdeJuego();
	
	public abstract Sonido getPierdeVida();
	
	public abstract Sonido getPowerUpAgarrado();
	
	public abstract Sonido getRomperLadrillo();
	
	public abstract Sonido getSalto();
	
	public abstract Sonido getTocarBanderaFinNivel();
	
	public abstract Sonido getRecuperarVida();
	
	
}
