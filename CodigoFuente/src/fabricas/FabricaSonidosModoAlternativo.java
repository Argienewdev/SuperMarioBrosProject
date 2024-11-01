package fabricas;
import elementos.Sonido;

public class FabricaSonidosModoAlternativo extends FabricaSonidos{

    public FabricaSonidosModoAlternativo(String rutaACarpeta) {
        super(rutaACarpeta);
    }

    @Override
    public Sonido obtenerAplastarEnemigo() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/aplastarEnemigo.wav");
    }

    @Override
    public Sonido obtenerChoqueFireball() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/choqueFireball.wav");
    }

    @Override
    public Sonido obtenerDisparoBolaFuego() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/disparoBolaFuego.wav");
    }

    @Override
    public Sonido obtenerGolpeBloque() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/golpeBloque.wav");
    }

    @Override
    public Sonido obtenerPowerUpEmerge() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/powerUpEmerge.wav");
    }

    @Override
    public Sonido obtenerMarioPequenioDeNuevo() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/marioPequenioDeNuevo.wav");
    }

    @Override
    public Sonido obtenerMatarBolaDeFuego() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/matarBolaDeFuego.wav");
    }

    @Override
    public Sonido obtenerModoInvencible() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/modoInvencible.wav");
    }

    @Override
    public Sonido obtenerSonidoMoneda() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/Moneda.wav");
    }
    
    public Sonido obtenerMusica(){
		return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/musicaModoAlternativo.wav");
	}

    @Override
    public Sonido obtenerPierdeJuego() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/pierdeJuego.wav");
    }

    @Override
    public Sonido obtenerPierdeVida() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/pierdeVida.wav");
    }

    @Override
    public Sonido obtenerPowerUpAgarrado() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/powerUpAgarrado.wav");
    }

    @Override
    public Sonido obtenerRomperLadrillo() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/romperLadrillo.wav");
    }

    @Override
    public Sonido obtenerSalto() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/salto.wav");
    }

    @Override
    public Sonido obtenerTocarBanderaFinNivel() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/tocarBanderaFinalNivel.wav");
    }

    @Override
    public Sonido obtenerRecuperarVida() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/recuperarVida.wav");
    }
    
}
