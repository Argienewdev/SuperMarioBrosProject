package fabricas;
import elementos.Sonido;

public class FabricaSonidoModoAlternativo extends FabricaSonidos{

    public FabricaSonidoModoAlternativo(String rutaACarpeta) {
        super(rutaACarpeta);
    }

    @Override
    public Sonido getAplastarEnemigo() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/aplastarEnemigo.wav");
    }

    @Override
    public Sonido getChoqueFireball() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/choqueFireball.wav");
    }

    @Override
    public Sonido getDisparoBolaFuego() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/disparoBolaFuego.wav");
    }

    @Override
    public Sonido getGolpeBloque() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/golpeBloque.wav");
    }

    @Override
    public Sonido getPowerUpEmerge() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/itemEmerge.wav");
    }

    @Override
    public Sonido getMarioPequenioDeNuevo() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/marioPequenioDeNuevo.wav");
    }

    @Override
    public Sonido getMatarBolaDeFuego() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/matarBolaDeFuego.wav");
    }

    @Override
    public Sonido getModoInvencible() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/modoInvencible.wav");
    }

    @Override
    public Sonido getSonidoMoneda() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/sonidoMoneda.wav");
    }

    @Override
    public Sonido getPierdeJuego() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/pierdeJuego.wav");
    }

    @Override
    public Sonido getPierdeVida() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/pierdeVida.wav");
    }

    @Override
    public Sonido getPowerUpAgarrado() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/powerUpAgarrado.wav");
    }

    @Override
    public Sonido getRomperLadrillo() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/romperLadrillo.wav");
    }

    @Override
    public Sonido getSalto() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/salto.wav");
    }

    @Override
    public Sonido getTocarBanderaFinNivel() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/tocarBanderaFinalNivel.wav");
    }

    @Override
    public Sonido getRecuperarVida() {
        return new Sonido(rutaACarpeta + "/sonido/sonidoModoAlternativo/recuperarVida.wav");
    }
    
}
