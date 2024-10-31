package fabricas;

import elementos.Sonido;

public class FabricaSonidosModoOriginal extends FabricaSonidos{

	public FabricaSonidosModoOriginal(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	@Override
	public Sonido obtenerAplastarEnemigo() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoModoOriginal/aplastarEnemigo.wav");

	}

	@Override
	public Sonido obtenerChoqueFireball() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoModoOriginal/choqueFireball.wav");
	}

	@Override
	public Sonido obtenerDisparoBolaFuego() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoModoOriginal/disparoBolaFuego.wav");
	}

	@Override
	public Sonido obtenerGolpeBloque() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoModoOriginal/golpeBloque.wav");
	}

	@Override
	public Sonido obtenerPowerUpEmerge() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoModoOriginal/itemEmerge.wav");
	}

	@Override
	public Sonido obtenerMarioPequenioDeNuevo() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoModoOriginal/marioPequenioDeNuevo.wav");
	}

	@Override
	public Sonido obtenerMatarBolaDeFuego() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoModoOriginal/matarBolaDeFuego.wav");
	}

	@Override
	public Sonido obtenerModoInvencible() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoModoOriginal/modoInvencible.wav");
	}

	@Override
	public Sonido obtenerSonidoMoneda() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoModoOriginal/sonidoMoneda.wav");
	}
	
	public Sonido obtenerMusica(){
		return new Sonido(rutaACarpeta + "/musicaModoOriginal.wav");
	}
	
	@Override
	public Sonido obtenerPierdeJuego() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoModoOriginal/pierdeJuego.wav");
	}

	@Override
	public Sonido obtenerPierdeVida() {
		return new Sonido(rutaACarpeta + "/pierdeVida.wav");
	}

	@Override
	public Sonido obtenerPowerUpAgarrado() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoModoOriginal/powerUpAgarrado.wav");
	}

	@Override
	public Sonido obtenerRomperLadrillo() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoModoOriginal/romperLadrillo.wav");
	}

	@Override
	public Sonido obtenerSalto() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoModoOriginal/salto.wav");
	}

	@Override
	public Sonido obtenerTocarBanderaFinNivel() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoModoOriginal/tocarBanderaFinalNivel.wav");
	}

	@Override
	public Sonido obtenerRecuperarVida() {
		return new Sonido(rutaACarpeta + "/sonido/sonidoModoOriginal/recuperarVida.wav");
	}
	
}
