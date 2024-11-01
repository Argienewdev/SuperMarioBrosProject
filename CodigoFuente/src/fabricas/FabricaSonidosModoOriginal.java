package fabricas;

import elementos.Sonido;

public class FabricaSonidosModoOriginal extends FabricaSonidos{

	public FabricaSonidosModoOriginal(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	@Override
	public Sonido obtenerAplastarEnemigo() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/aplastarEnemigo.wav");

	}

	@Override
	public Sonido obtenerChoqueFireball() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/choqueFireball.wav");
	}

	@Override
	public Sonido obtenerDisparoBolaFuego() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/disparoBolaFuego.wav");
	}

	@Override
	public Sonido obtenerGolpeBloque() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/golpeBloque.wav");
	}

	@Override
	public Sonido obtenerPowerUpEmerge() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/itemEmerge.wav");
	}

	@Override
	public Sonido obtenerMarioPequenioDeNuevo() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/marioPequenioDeNuevo.wav");
	}

	@Override
	public Sonido obtenerMatarBolaDeFuego() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/matarBolaDeFuego.wav");
	}

	@Override
	public Sonido obtenerModoInvencible() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/modoInvencible.wav");
	}

	@Override
	public Sonido obtenerSonidoMoneda() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginalMoneda.wav");
	}
	
	public Sonido obtenerMusica(){
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/musicaModoOriginal.wav");
	}
	
	@Override
	public Sonido obtenerPierdeJuego() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/pierdeJuego.wav");
	}

	@Override
	public Sonido obtenerPierdeVida() {
		return new Sonido(rutaACarpeta + "/pierdeVida.wav");
	}

	@Override
	public Sonido obtenerPowerUpAgarrado() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/powerUpAgarrado.wav");
	}

	@Override
	public Sonido obtenerRomperLadrillo() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/romperLadrillo.wav");
	}

	@Override
	public Sonido obtenerSalto() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/salto.wav");
	}

	@Override
	public Sonido obtenerTocarBanderaFinNivel() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/tocarBanderaFinalNivel.wav");
	}

	@Override
	public Sonido obtenerRecuperarVida() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/recuperarVida.wav");
	}
	
}
