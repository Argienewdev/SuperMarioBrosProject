package fabricas;

import elementos.Sprite;

public class FabricaSpritesModoOriginal extends FabricaSprites {

	public FabricaSpritesModoOriginal(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	@Override
    public Sprite obtenerMarioDefaultFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioDefaultFrontalQuieto.png");
    }

    @Override
    public Sprite obtenerMarioDefaultFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioDefaultFrontalCaminando.gif");
    }

    @Override
    public Sprite obtenerMarioDefaultCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioDefaultCayendo.png");
    }
    
    @Override
    public Sprite obtenerMarioDefaultFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioDefaultFrontalSaltando.png");
    }

    @Override
    public Sprite obtenerMarioDefaultReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioDefaultReversoQuieto.png");
    }

    @Override
    public Sprite obtenerMarioDefaultReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioDefaultReversoCaminando.gif");
    }

    @Override
    public Sprite obtenerMarioDefaultReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioDefaultReversoSaltando.png");
    }

    @Override
    public Sprite getSuperMarioFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/superMarioFrontalQuieto.png");
    }

    @Override
    public Sprite getSuperMarioFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/superMarioFrontalCaminando.gif");
    }

    @Override
    public Sprite getSuperMarioFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/superMarioFrontalSaltando.png");
    }
    
    @Override
    public Sprite getSuperMarioCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/superMarioCayendo.png");
    }

    @Override
    public Sprite getSuperMarioReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/superMarioReversoQuieto.png");
    }

    @Override
    public Sprite getSuperMarioReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/superMarioReversoCaminando.gif");
    }

    @Override
    public Sprite getSuperMarioReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/superMarioReversoSaltando.png");
    }

    @Override
    public Sprite getMarioFuegoFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioFuegoFrontalQuieto.png");
    }

    @Override
    public Sprite getMarioFuegoFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioFuegoFrontalCaminando.gif");
    }

    @Override
    public Sprite getMarioFuegoFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioFuegoFrontalSaltando.png");
    }
    
    @Override
	public Sprite getMarioFuegoCayendo() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioFuegoCayendo.png");
	}

    @Override
    public Sprite getMarioFuegoReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioFuegoReversoQuieto.png");
    }

    @Override
    public Sprite getMarioFuegoReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioFuegoReversoCaminando.gif");
    }

    @Override
    public Sprite getMarioFuegoReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioFuegoReversoSaltando.png");
    }
    
    @Override
    public Sprite getMarioInvulnerableFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioInvulnerableFrontalQuieto.gif");
    }

    @Override
    public Sprite getMarioInvulnerableFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioInvulnerableFrontalCaminando.gif");
    }

    @Override
    public Sprite getMarioInvulnerableFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioInvulnerableFrontalSaltando.gif");
    }

    @Override
    public Sprite getMarioInvulnerableCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioInvulnerableCayendo.gif");
    }
    
    @Override
    public Sprite getMarioInvulnerableReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioInvulnerableReversoQuieto.gif");
    }

    @Override
    public Sprite getMarioInvulnerableReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioInvulnerableReversoCaminando.gif");
    }

    @Override
    public Sprite getMarioInvulnerableReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioInvulnerableReversoSaltando.gif");
    }

    @Override
    public Sprite getMarioRecuperacionFrontalQuieto() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioRecuperacionFrontalQuieto.gif");
    }
    
    @Override
    public Sprite getMarioRecuperacionFrontalCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioRecuperacionFrontalCaminando.gif");
    }
    
    @Override
    public Sprite getMarioRecuperacionCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioDefaultFrontalCayendo.gif");
    }
    
    @Override
    public Sprite getMarioRecuperacionFrontalSaltando() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioRecuperacionFrontalSaltando.gif");
    }
    
    @Override
    public Sprite getMarioRecuperacionReversoQuieto() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioRecuperacionReversoQuieto.gif");
    }
    
    @Override
    public Sprite getMarioRecuperacionReversoCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioRecuperacionReversoCaminando.gif");
    }
    
    @Override
    public Sprite getMarioRecuperacionReversoSaltando() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioRecuperacionReversoSaltando.gif");
    }
    
    @Override
    public Sprite getKoopaTroopaDefaultFrontalCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/koopaTroopaDefaultFrontalCaminando.gif");
    }
    
    @Override
	public Sprite getKoopaTroopaDefaultReversoCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/koopaTroopaDefaultReversoCaminando.gif");
    }
    
    @Override
    public Sprite getKoopaTroopaCaparazonEstático() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/koopaTroopaCaparazonEstatico.png");
    }

    @Override
    public Sprite getKoopaTroopaMuerto() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/koopaTroopaMuerto.png");
    }
    
    @Override
    public Sprite getGoombaFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/goombaCaminando.gif");
    }
    
    @Override
    public Sprite getGoombaReversoCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/goombaCaminando.gif");
    }
    
    @Override
	public Sprite getGoombaMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/goombaMuerto.png");
	}

    @Override
    public Sprite getLakituFrontalFueraDeLaNube() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/lakituFrontalFueraDeLaNube.png");
    }

    @Override
    public Sprite getLakituDentroDeLaNube() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/lakituFrontalDentroDeLaNube.png");
    }

    @Override
    public Sprite getLakituReversoFueraDeLaNube() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/lakituReversoFueraDeLaNube.png");
    }

    @Override
	public Sprite getLakituMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/lakituMuerto.png");
	}
    
    @Override
    public Sprite getSpinyCayendo() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/spinyCayendo.gif");
    }

    @Override
    public Sprite getSpinyFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/spinyFrontalCaminando.gif");
    }

    @Override
    public Sprite getSpinyReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/spinyReversoCaminando.gif");
    }
    
    @Override
	public Sprite getSpinyMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/spinyMuerto.png");
	}

    @Override
    public Sprite getBuzzyBeetleFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/buzzyBeetleFrontalCaminando.gif");
    }

    @Override
    public Sprite getBuzzyBeetleReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/buzzyBeetleReversoCaminando.gif");
    }
    
    @Override
	public Sprite getBuzzyBeetleMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/buzzyBeetleMuerto.gif");
	}

	@Override
	public Sprite getPiranhaPlant() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/piranhaPlant.png");
	}

	@Override
	public Sprite getPiranhaPlantMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/koopaTroopaMuerto.png");
	}

    @Override
    public Sprite getEstrellaApagada() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/estrella.gif");
    }

    @Override
    public Sprite getEstrellaEncendida() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/estrella.gif");
    }

    @Override
    public Sprite getFlorDeFuegoSaliendoDelBloqueDePreguntas() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/florDeFuegoSaliendo.gif");
    }

    @Override
    public Sprite getFlorDeFuegoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/florDeFuegoAfuera.gif");
    }

    @Override
    public Sprite getChampinionVerde() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/champinionVerde.png");
    }

    @Override
    public Sprite getChampinionVerdeSaliendoDelBloqueDePreguntas() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/champinionVerdeSaliendo.gif");
    }
    
    @Override
    public Sprite getSuperChampinionSaliendoDelBloqueDePreguntas() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/superChampinionSaliendo.gif");
    }
    
    @Override
    public Sprite getSuperChampinionQuieto() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/superChampinionAfuera.png");
    }

    @Override
    public Sprite getMonedaApagada() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/monedaApagada.png");
    }

    @Override
    public Sprite getMonedaEncendida() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/monedaEncendida.gif");
    }

    @Override
    public Sprite getBolaDeFuego() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/bolaDeFuego.gif");
	}

    @Override
    public Sprite getLadrillo() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/ladrillo.png");
    }

    @Override
    public Sprite getBloqueSolido() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/bloqueSolido.png");
    }
    
    @Override
    public Sprite getPiso() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/piso.png");
    }

    public Sprite getTuberia(int altura) {
    	String rutaAux = rutaACarpeta;
    	if (altura== 1) {
    		rutaAux += "/spritesModoOriginal/tuberiaBaja.png";
    	} else if (altura== 2) {
    		rutaAux += "/spritesModoOriginal/tuberiaMediana.png";
    	} else if (altura== 3) {
    		rutaAux += "/spritesModoOriginal/tuberiaAlta.png";
    	}
        return new Sprite(rutaAux);
    }

    @Override
    public Sprite getBloqueDePreguntaApagado() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/bloqueDePreguntaApagado.png");
    }

    @Override
    public Sprite getBloqueDePreguntaEncendido() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/bloqueDePreguntaEncendido.gif");
    }

    @Override
    public Sprite getBandera() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/bandera.png");
    }

    @Override
    public Sprite getVacio() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/vacio.png");
    }

    @Override
    public Sprite getPrincesaPeach() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/princesaPeach.png");
    }
	
	@Override
	public Sprite getSpriteInvisible() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/spriteInvisible.png");
	}
}
