package fabricas;
import elementos.Sonido;

public class FabricaSonidosModoAlternativo extends FabricaSonidos{

    public FabricaSonidosModoAlternativo(String rutaACarpeta) {
        super(rutaACarpeta);
    }

    public Sonido obtenerAplastarEnemigo() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/aplastarEnemigo.wav");
    }
    
    public Sonido obtenerAplastarEnemigo2() {
    	return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/aplastarEnemigo2.wav");
    }
    
    public Sonido obtenerAplastarEnemigo3() {
    	return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/aplastarEnemigo3.wav");
    }

    public Sonido obtenerChoqueFireball() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/choqueFireball.wav");
    }

    public Sonido obtenerDisparoBolaFuego() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/disparoBolaFuego.wav");
    }

    public Sonido obtenerGolpeBloque() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/golpeBloque.wav");
    }

    public Sonido obtenerPowerUpEmerge() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/powerUpEmerge.wav");
    }

    public Sonido obtenerMarioPequenioDeNuevo() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/marioPequenioDeNuevo.wav");
    }

    public Sonido obtenerMatarBolaDeFuego() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/matarBolaDeFuego.wav");
    }

    public Sonido obtenerModoInvencible() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/modoInvencible.wav");
    }
    
    public Sonido obtenerModoRecuperacion() {
    	return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/modoRecuperacion.wav");
    }
    
    public Sonido obtenerModoFuego() {
    	return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/modoFuego.wav");
    }

    public Sonido obtenerSonidoMoneda() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/moneda.wav");
    }
    
    public Sonido obtenerMusica(){
		return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/musicaModoAlternativo.wav");
	}

    public Sonido obtenerPierdeJuego() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/pierdeJuego.wav");
    }

    public Sonido obtenerPierdeVida() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/pierdeVida.wav");
    }

    public Sonido obtenerPowerUpAgarrado() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/powerUpAgarrado.wav");
    }

    public Sonido obtenerRomperLadrillo() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/romperLadrillo.wav");
    }

    public Sonido obtenerSalto() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/salto.wav");
    }

    public Sonido obtenerTocarBanderaFinNivel() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/tocarBanderaFinNivel.wav");
    }

    public Sonido obtenerRecuperarVida() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/recuperarVida.wav");
    }
    
	public Sonido obtenerSeAcaboElTiempo() {
    	return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/pierdeVida.wav");
	}

	@Override
	public Sonido obtenerRescatePrincesa() {
		return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/rescatarPrincesa.wav");
	}
    
}
