package fabricas;

import elementos.Sprite;

public class FabricaSpritesModoAlternativo extends FabricaSprites {

	public FabricaSpritesModoAlternativo(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	@Override
    public Sprite obtenerMarioDefaultFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultFrontalQuieto.png");
    }

    @Override
    public Sprite obtenerMarioDefaultFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultFrontalCaminando.gif");
    }

    @Override
    public Sprite obtenerMarioDefaultCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultCayendo.png");
    }
    
    @Override
    public Sprite obtenerMarioDefaultFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultFrontalSaltando.png");
    }

    @Override
    public Sprite obtenerMarioDefaultReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultReversoQuieto.png");
    }

    @Override
    public Sprite obtenerMarioDefaultReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultReversoCaminando.gif");
    }

    @Override
    public Sprite obtenerMarioDefaultReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultReversoSaltando.png");
    }

    @Override
    public Sprite getSuperMarioFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioFrontalQuieto.png");
    }

    @Override
    public Sprite getSuperMarioFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioFrontalCaminando.gif");
    }

    @Override
    public Sprite getSuperMarioFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioFrontalSaltando.png");
    }
    
    @Override
    public Sprite getSuperMarioCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioCayendo.png");
    }

    @Override
    public Sprite getSuperMarioReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioReversoQuieto.png");
    }

    @Override
    public Sprite getSuperMarioReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioReversoCaminando.gif");
    }

    @Override
    public Sprite getSuperMarioReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioReversoSaltando.png");
    }

    @Override
    public Sprite getMarioFuegoFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoFrontalQuieto.png");
    }

    @Override
    public Sprite getMarioFuegoFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoFrontalCaminando.gif");
    }

    @Override
    public Sprite getMarioFuegoFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoFrontalSaltando.png");
    }
    
    @Override
	public Sprite getMarioFuegoCayendo() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoCayendo.png");
	}

    @Override
    public Sprite getMarioFuegoReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoReversoQuieto.png");
    }

    @Override
    public Sprite getMarioFuegoReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoReversoCaminando.gif");
    }

    @Override
    public Sprite getMarioFuegoReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoReversoSaltando.png");
    }
    
    @Override
    public Sprite getMarioInvulnerableFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableFrontalQuieto.gif");
    }

    @Override
    public Sprite getMarioInvulnerableFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableFrontalCaminando.gif");
    }

    @Override
    public Sprite getMarioInvulnerableFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableFrontalSaltando.gif");
    }

    @Override
    public Sprite getMarioInvulnerableCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableCayendo.gif");
    }
    
    @Override
    public Sprite getMarioInvulnerableReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableReversoQuieto.gif");
    }

    @Override
    public Sprite getMarioInvulnerableReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableReversoCaminando.gif");
    }

    @Override
    public Sprite getMarioInvulnerableReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableReversoSaltando.gif");
    }

    @Override
    public Sprite getMarioRecuperacionFrontalQuieto() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioRecuperacionFrontalQuieto.gif");
    }
    
    @Override
    public Sprite getMarioRecuperacionFrontalCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioRecuperacionFrontalCaminando.gif");
    }
    
    @Override
    public Sprite getMarioRecuperacionCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultFrontalCayendo.gif");
    }
    
    @Override
    public Sprite getMarioRecuperacionFrontalSaltando() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioRecuperacionFrontalSaltando.gif");
    }
    
    @Override
    public Sprite getMarioRecuperacionReversoQuieto() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioRecuperacionReversoQuieto.gif");
    }
    
    @Override
    public Sprite getMarioRecuperacionReversoCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioRecuperacionReversoCaminando.gif");
    }
    
    @Override
    public Sprite getMarioRecuperacionReversoSaltando() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioRecuperacionReversoSaltando.gif");
    }
    
    @Override
    public Sprite getKoopaTroopaDefaultFrontalCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/koopaTroopaDefaultFrontalCaminando.gif");
    }
    
    @Override
	public Sprite getKoopaTroopaDefaultReversoCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/koopaTroopaDefaultReversoCaminando.gif");
    }
    
    @Override
    public Sprite getKoopaTroopaCaparazonEstático() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/koopaTroopaCaparazonEstatico.png");
    }

    @Override
    public Sprite getKoopaTroopaMuerto() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/koopaTroopaMuerto.gif");
    }
    
    @Override
    public Sprite getGoombaFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/goombaFrontalCaminando.gif");
    }
    
    @Override
    public Sprite getGoombaReversoCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/goombaReversoCaminando.gif");
    }
    
    @Override
	public Sprite getGoombaMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/goombaMuerto.gif");
	}

    @Override
    public Sprite getLakituFrontalFueraDeLaNube() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/lakituFrontalFueraDeLaNube.gif");
    }

    @Override
    public Sprite getLakituDentroDeLaNube() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/lakituFrontalDentroDeLaNube.png");
    }

    @Override
    public Sprite getLakituReversoFueraDeLaNube() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/lakituReversoFueraDeLaNube.gif");
    }

    @Override
	public Sprite getLakituMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/lakituMuerto.gif");
	}
    
    @Override
    public Sprite getSpinyCayendo() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spinyCayendo.png");
    }

    @Override
    public Sprite getSpinyFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spinyFrontalCaminando.gif");
    }

    @Override
    public Sprite getSpinyReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spinyReversoCaminando.gif");
    }
    
    @Override
	public Sprite getSpinyMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spinyMuerto.png");
	}

    @Override
    public Sprite getBuzzyBeetleFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/buzzyBeetleFrontalCaminando.gif");
    }

    @Override
    public Sprite getBuzzyBeetleReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/buzzyBeetleReversoCaminando.gif");
    }
    
    @Override
	public Sprite getBuzzyBeetleMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/buzzyBeetleMuerto.gif");
	}

	@Override
	public Sprite getPiranhaPlant() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/piranhaPlant.png");
	}

	@Override
	public Sprite getPiranhaPlantMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/koopaTroopaMuerto.png");
	}

    @Override
    public Sprite getEstrellaApagada() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/estrella.gif");
    }

    @Override
    public Sprite getEstrellaEncendida() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/estrella.gif");
    }

    @Override
    public Sprite getFlorDeFuegoSaliendoDelBloqueDePreguntas() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/florDeFuegoSaliendo.gif");
    }

    @Override
    public Sprite getFlorDeFuegoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/florDeFuegoAfuera.gif");
    }

    @Override
    public Sprite getChampinionVerde() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/champinionVerde.png");
    }

    @Override
    public Sprite getChampinionVerdeSaliendoDelBloqueDePreguntas() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/champinionVerdeSaliendo.gif");
    }
    
    @Override
    public Sprite getSuperChampinionSaliendoDelBloqueDePreguntas() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superChampinionSaliendo.gif");
    }
    
    @Override
    public Sprite getSuperChampinionQuieto() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superChampinionAfuera.png");
    }

    @Override
    public Sprite getMonedaApagada() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/monedaApagada.png");
    }

    @Override
    public Sprite getMonedaEncendida() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/monedaEncendida.gif");
    }

    @Override
    public Sprite getBolaDeFuego() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/bolaDeFuego.png");
	}

    @Override
    public Sprite getLadrillo() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/ladrillo.png");
    }

    @Override
    public Sprite getBloqueSolido() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/bloqueSolido.png");
    }
    
    @Override
    public Sprite getPiso() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/piso.png");
    }

    public Sprite getTuberia(int altura) {
    	String rutaAux = rutaACarpeta;
    	if (altura== 1) {
    		rutaAux += "/spritesModoAlternativo/tuberiaBaja.png";
    	} else if (altura== 2) {
    		rutaAux += "/spritesModoAlternativo/tuberiaMediana.png";
    	} else if (altura== 3) {
    		rutaAux += "/spritesModoAlternativo/tuberiaAlta.png";
    	}
        return new Sprite(rutaAux);
    }

    @Override
    public Sprite getBloqueDePreguntaApagado() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/bloqueDePreguntaApagado.png");
    }

    @Override
    public Sprite getBloqueDePreguntaEncendido() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/bloqueDePreguntaEncendido.png");
    }

    @Override
    public Sprite getBandera() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/bandera.gif");
    }

    @Override
    public Sprite getVacio() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/vacio.png");
    }

    @Override
    public Sprite getPrincesaPeach() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/princesaPeach.png");
    }
	
	@Override
	public Sprite getSpriteInvisible() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spriteInvisible.png");
	}
}