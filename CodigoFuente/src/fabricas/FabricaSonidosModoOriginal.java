package fabricas;

import elementos.Sonido;

public class FabricaSonidosModoOriginal extends FabricaSonidos{

	public FabricaSonidosModoOriginal(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	@Override
	public Sonido getAplastarEnemigo() {
		return new Sonido(rutaACarpeta + "/sonido/aplastarEnemigo.wav");

	}

	@Override
	public Sonido getChoqueFireball() {
		return new Sonido(rutaACarpeta + "/sonido/choqueFireball.wav");
	}

	@Override
	public Sonido getDisparoBolaFuego() {
		return new Sonido(rutaACarpeta + "/sonido/disparoBolaFuego.wav");
	}

	@Override
	public Sonido getGolpeBloque() {
		return new Sonido(rutaACarpeta + "/sonido/golpeBloque.wav");
	}

	@Override
	public Sonido getPowerUpEmerge() {
		return new Sonido(rutaACarpeta + "/sonido/itemEmerge.wav");
	}

	@Override
	public Sonido getMarioPequenioDeNuevo() {
		return new Sonido(rutaACarpeta + "/sonido/marioPequenioDeNuevo.wav");
	}

	@Override
	public Sonido getMatarBolaDeFuego() {
		return new Sonido(rutaACarpeta + "/sonido/matarBolaDeFuego.wav");
	}

	@Override
	public Sonido getModoInvencible() {
		return new Sonido(rutaACarpeta + "/sonido/modoInvencible.wav");
	}

	@Override
	public Sonido getSonidoMoneda() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoMoneda.wav");
	}

	@Override
	public Sonido getPierdeJuego() {
		return new Sonido(rutaACarpeta + "/sonido/pierdeJuego.wav");
	}

	@Override
	public Sonido getPierdeVida() {
		return new Sonido(rutaACarpeta + "/sonido/pierdeVida.wav");
	}

	@Override
	public Sonido getPowerUpAgarrado() {
		return new Sonido(rutaACarpeta + "/sonido/powerUpAgarrado.wav");
	}

	@Override
	public Sonido getRomperLadrillo() {
		return new Sonido(rutaACarpeta + "/sonido/romperLadrillo.wav");
	}

	@Override
	public Sonido getSalto() {
		return new Sonido(rutaACarpeta + "/sonido/salto.wav");
	}

	@Override
	public Sonido getTocarBanderaFinNivel() {
		return new Sonido(rutaACarpeta + "/sonido/tocarBanderaFinalNivel.wav");
	}

	@Override
	public Sonido getRecuperarVida() {
		return new Sonido(rutaACarpeta + "/sonido/recuperarVida.wav");
	}
	
}
