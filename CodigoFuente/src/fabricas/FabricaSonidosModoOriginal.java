package fabricas;

import elementos.Sonido;

public class FabricaSonidosModoOriginal extends FabricaSonidos{

	public FabricaSonidosModoOriginal(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	@Override
	public Sonido obtenerAplastarEnemigo() {
		return new Sonido(rutaACarpeta + "/sonido/aplastarEnemigo.wav");

	}

	@Override
	public Sonido obtenerChoqueFireball() {
		return new Sonido(rutaACarpeta + "/sonido/choqueFireball.wav");
	}

	@Override
	public Sonido obtenerDisparoBolaFuego() {
		return new Sonido(rutaACarpeta + "/sonido/disparoBolaFuego.wav");
	}

	@Override
	public Sonido obtenerGolpeBloque() {
		return new Sonido(rutaACarpeta + "/sonido/golpeBloque.wav");
	}

	@Override
	public Sonido obtenerPowerUpEmerge() {
		return new Sonido(rutaACarpeta + "/sonido/itemEmerge.wav");
	}

	@Override
	public Sonido obtenerMarioPequenioDeNuevo() {
		return new Sonido(rutaACarpeta + "/sonido/marioPequenioDeNuevo.wav");
	}

	@Override
	public Sonido obtenerMatarBolaDeFuego() {
		return new Sonido(rutaACarpeta + "/sonido/matarBolaDeFuego.wav");
	}

	@Override
	public Sonido obtenerModoInvencible() {
		return new Sonido(rutaACarpeta + "/sonido/modoInvencible.wav");
	}

	@Override
	public Sonido obtenerSonidoMoneda() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoMoneda.wav");
	}

	@Override
	public Sonido obtenerPierdeJuego() {
		return new Sonido(rutaACarpeta + "/sonido/pierdeJuego.wav");
	}

	@Override
	public Sonido obtenerPierdeVida() {
		return new Sonido(rutaACarpeta + "/sonido/pierdeVida.wav");
	}

	@Override
	public Sonido obtenerPowerUpAgarrado() {
		return new Sonido(rutaACarpeta + "/sonido/powerUpAgarrado.wav");
	}

	@Override
	public Sonido obtenerRomperLadrillo() {
		return new Sonido(rutaACarpeta + "/sonido/romperLadrillo.wav");
	}

	@Override
	public Sonido obtenerSalto() {
		return new Sonido(rutaACarpeta + "/sonido/salto.wav");
	}

	@Override
	public Sonido obtenerTocarBanderaFinNivel() {
		return new Sonido(rutaACarpeta + "/sonido/tocarBanderaFinalNivel.wav");
	}

	@Override
	public Sonido obtenerRecuperarVida() {
		return new Sonido(rutaACarpeta + "/sonido/recuperarVida.wav");
	}
	
}
