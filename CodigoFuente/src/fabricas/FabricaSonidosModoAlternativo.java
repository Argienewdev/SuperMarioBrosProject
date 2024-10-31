package fabricas;
import elementos.Sonido;

public class FabricaSonidosModoAlternativo extends FabricaSonidos{

    public FabricaSonidosModoAlternativo(String rutaACarpeta) {
        super(rutaACarpeta);
    }

    @Override
    public Sonido obtenerAplastarEnemigo() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/aplastarEnemigo.wav");
    }

    @Override
    public Sonido obtenerChoqueFireball() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/choqueFireball.wav");
    }

    @Override
    public Sonido obtenerDisparoBolaFuego() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/disparoBolaFuego.wav");
    }

    @Override
    public Sonido obtenerGolpeBloque() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/golpeBloque.wav");
    }

    @Override
    public Sonido obtenerPowerUpEmerge() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/itemEmerge.wav");
    }

    @Override
    public Sonido obtenerMarioPequenioDeNuevo() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/marioPequenioDeNuevo.wav");
    }

    @Override
    public Sonido obtenerMatarBolaDeFuego() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/matarBolaDeFuego.wav");
    }

    @Override
    public Sonido obtenerModoInvencible() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/modoInvencible.wav");
    }

    @Override
    public Sonido obtenerSonidoMoneda() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/sonidoMoneda.wav");
    }
    
    public Sonido obtenerMusica(){
		return new Sonido(rutaACarpeta + "/musicaModoAlternativo.wav");
	}

    @Override
    public Sonido obtenerPierdeJuego() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/pierdeJuego.wav");
    }

    @Override
    public Sonido obtenerPierdeVida() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/pierdeVida.wav");
    }

    @Override
    public Sonido obtenerPowerUpAgarrado() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/powerUpAgarrado.wav");
    }

    @Override
    public Sonido obtenerRomperLadrillo() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/romperLadrillo.wav");
    }

    @Override
    public Sonido obtenerSalto() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/salto.wav");
    }

    @Override
    public Sonido obtenerTocarBanderaFinNivel() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/tocarBanderaFinalNivel.wav");
    }

    @Override
    public Sonido obtenerRecuperarVida() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/recuperarVida.wav");
    }
    
}
