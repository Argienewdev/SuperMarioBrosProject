package fabricas;

import elementos.Sonido;

public class FabricaSonidosModoOriginal extends FabricaSonidos{

	public FabricaSonidosModoOriginal(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	public Sonido obtenerAplastarEnemigo() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/aplastarEnemigo.wav");
	}
	
	public Sonido obtenerAplastarEnemigo2() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/aplastarEnemigo2.wav");
	}
	
	public Sonido obtenerAplastarEnemigo3() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/aplastarEnemigo3.wav");
	}

	public Sonido obtenerChoqueFireball() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/choqueFireball.wav");
	}

	public Sonido obtenerDisparoBolaFuego() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/disparoBolaFuego.wav");
	}
	
	public Sonido obtenerGolpeBloque() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/golpeBloque.wav");
	}

	public Sonido obtenerPowerUpEmerge() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/powerUpEmerge.wav");
	}
	
	public Sonido obtenerMarioPequenioDeNuevo() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/marioPequenioDeNuevo.wav");
	}
	
	public Sonido obtenerMatarBolaDeFuego() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/matarBolaDeFuego.wav");
	}

	public Sonido obtenerModoInvencible() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/modoInvencible.wav");
	}
	
	public Sonido obtenerModoRecuperacion() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/marioRecuperacion.wav");
	}
	
	public Sonido obtenerModoFuego() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/modoFuego.wav");
	}

	public Sonido obtenerSonidoMoneda() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/moneda.wav");
	}
	
	public Sonido obtenerMusica(){
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/musicaModoOriginal.wav");
	}
	
	public Sonido obtenerPierdeJuego() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/pierdeJuego.wav");
	}

	public Sonido obtenerPierdeVida() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/pierdeVida.wav");
	}
	
	public Sonido obtenerPowerUpAgarrado() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/powerUpAgarrado.wav");
	}

	public Sonido obtenerRomperLadrillo() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/romperLadrillo.wav");
	}

	public Sonido obtenerSalto() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/salto.wav");
	}

	public Sonido obtenerTocarBanderaFinNivel() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/tocarBanderaFinNivel.wav");
	}

	public Sonido obtenerRecuperarVida() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/recuperarVida.wav");
	}

	public Sonido obtenerSeAcaboElTiempo() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/seAcaboElTiempo.wav");
	}

	@Override
	public Sonido obtenerRescatePrincesa() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/rescatarPrincesa.wav");
	}
	
}
