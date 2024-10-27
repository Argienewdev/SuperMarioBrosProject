package fabricas;

import elementos.Sprite;

public class FabricaSpritesModoAlternativo extends FabricaSprites {

	public FabricaSpritesModoAlternativo(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	@Override
	public Sprite getMarioDefaultFrontalQuieto() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultFrontalQuieto.png");
	}

	@Override
	public Sprite getMarioDefaultFrontalCaminando() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultFrontalCaminandoPrimeraTransicion.png");
	}

	@Override
	public Sprite getMarioDefaultCayendo() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultCayendo.png");
	}

	@Override
	public Sprite getMarioDefaultFrontalSaltando() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultFrontalSaltando.png");
	}
	
	@Override
	public Sprite getMarioDefaultReversoQuieto() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultReversoQuieto.png");
	}

	@Override
	public Sprite getMarioDefaultReversoCaminando() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultReversoCaminandoPrimeraTransicion.png");
	}

	@Override
	public Sprite getMarioDefaultReversoSaltando() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultReversoSaltando.png");
	}

	@Override
	public Sprite getSuperMarioFrontalQuieto() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioFrontalQuieto.png");
	}

	@Override
	public Sprite getSuperMarioFrontalCaminando() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioFrontalCaminandoPrimeraTransicion.png");
	}

	@Override
	public Sprite getSuperMarioFrontalSaltando() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioFrontalSaltando.png");
	}

	@Override
	public Sprite getSuperMarioReversoQuieto() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioReversoQuieto.png");
	}

	@Override
	public Sprite getSuperMarioReversoCaminando() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioReversoCaminandoPrimeraTransicion.png");
	}

    @Override
    public Sprite getSuperMarioReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioReversoSaltando.png");
    }
    
	public Sprite getSuperMarioCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioReversoCayendo.png");
    }

    @Override
    public Sprite getMarioFuegoFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoFrontalQuieto.png");
    }

    @Override
    public Sprite getMarioFuegoFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoFrontalCaminandoPrimeraTransicion.png");
    }

    @Override
    public Sprite getMarioFuegoFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoFrontalSaltando.png");
    }

	@Override
	public Sprite getMarioFuegoCayendo() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoFrontalCayendo.png");
    }
	
    @Override
    public Sprite getMarioFuegoReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoReversoQuieto.png");
    }

    @Override
    public Sprite getMarioFuegoReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoReversoCaminandoPrimeraTransicion.png");
    }

    @Override
    public Sprite getMarioFuegoReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoReversoSaltando.png");
    }

    @Override
    public Sprite getMarioInvulnerableFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableFrontalQuieto.png");
    }

    @Override
    public Sprite getMarioInvulnerableFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableFrontalCaminandoPrimeraTransicion.png");
    }

    @Override
    public Sprite getMarioInvulnerableFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableFrontalSaltando.png");
    }
    
	@Override
	public Sprite getMarioInvulnerableCayendo() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableFrontalCayendo.png");
	}

    @Override
    public Sprite getMarioInvulnerableReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableReversoQuieto.png");
    }

    @Override
    public Sprite getMarioInvulnerableReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableReversoCaminandoPrimeraTransicion.png");
    }

    @Override
    public Sprite getMarioInvulnerableReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableReversoSaltando.png");
    }
    
    @Override
    public Sprite getkoopaTroopaDefaultFrontalCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/koopaTroopaDefaultFrontalCaminando.gif");
    }
    
    @Override
	public Sprite getkoopaTroopaDefaultReversoCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/koopaTroopaDefaultReversoCaminando.gif");
    }

    @Override
    public Sprite getKoopaTroopaCaparazonEstático() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/koopaTroopaCaparazonEstatico.png");
    }

    @Override
    public Sprite getGoombaCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/goombaCaminando.gif");
    }

    @Override
    public Sprite getGoombaAplastado() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/goombaAplastado.png");
    }

    @Override
    public Sprite getPiranhaPlantCerrada() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/piranhaPlantCerrada.png");
    }

    @Override
    public Sprite getPiranhaPlantAbierta() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/piranhaPlantAbierta.png");
    }

    @Override
    public Sprite getLakituFrontalFueraDeLaNube() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/lakituFrontalFueraDeLaNube.png");
    }

    @Override
    public Sprite getLakituDentroDeLaNube() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/lakituDentroDeLaNube.png");
    }

    @Override
    public Sprite getLakituReversoFueraDeLaNube() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/lakituReversoFueraDeLaNube.png");
    }

    @Override
    public Sprite getSpinyAntesDeCaerPrimeraTransicion() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spinyAntesDeCaerPrimeraTransicion.png");
    }

    @Override
    public Sprite getSpinyAntesDeCaerSegundaTransicion() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spinyAntesDeCaerSegundaTransicion.png");
    }

    @Override
    public Sprite getSpinyFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spinyFrontalQuieto.png");
    }

    @Override
    public Sprite getSpinyFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spinyFrontalCaminando.png");
    }

    @Override
    public Sprite getSpinyReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spinyReversoQuieto.png");
    }

    @Override
    public Sprite getSpinyReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spinyReversoCaminando.png");
    }

    @Override
    public Sprite getBuzzyBeetleFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/buzzyBeetleFrontalQuieto.png");
    }

    @Override
    public Sprite getBuzzyBeetleFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/buzzyBeetleFrontalCaminando.png");
    }

    @Override
    public Sprite getBuzzyBeetleReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/buzzyBeetleReversoQuieto.png");
    }

    @Override
    public Sprite getBuzzyBeetleReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/buzzyBeetleReversoCaminando.png");
    }

    @Override
    public Sprite getEstrellaApagada() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/estrellaApagada.png");
    }

    @Override
    public Sprite getEstrellaEncendida() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/estrellaEncendida.png");
    }

    @Override
    public Sprite getFlorDeFuegoSaliendoDelBloqueDePreguntas() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/florDeFuegoPrimeraTransicion.png");
    }

    @Override
    public Sprite getFlorDeFuegoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/florDeFuegoSegundaTransicion.png");
    }

    @Override
    public Sprite getChampinionVerde() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/champinionVerde.png");
    }

    @Override
    public Sprite getChampinionVerdeSaliendoDelBloqueDePreguntas() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/champinionVerdeSaliendo.png");
    }
    
    @Override
    public Sprite getSuperChampinionSaliendoDelBloqueDePreguntas() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superChampinion.gif");
    }
    
    @Override
    public Sprite getSuperChampinionQuieto() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superChampinion.png");
    }

    @Override
    public Sprite getMonedaApagada() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/monedaApagada.png");
    }

    @Override
    public Sprite getMonedaEncendida() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/monedaEncendida.png");
    }
    
	public Sprite getBolaDeFuego() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/bolaDeFuego.gif\"");
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
    public Sprite getTuberia(int altura) {
    	String rutaAux = rutaACarpeta;
    	if (altura >= 0 && altura <= 5) {
    		rutaAux += "/spritesModoAlternativo/tuberiaPequenia.png";
    	} else if (altura > 5 && altura <= 10) {
    		rutaAux += "/spritesModoAlternativo/tuberiaMediana.png";
    	} else if (altura > 10) {
    		rutaAux += "/spritesModoAlternativo/tuberiaMediana.png";
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
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/bandera.png");
    }

    @Override
    public Sprite getVacio() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/vacio.png");
    }

    @Override
    public Sprite getPrincesaPeach() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/princesaPeach.png");
    }

	public Sprite getPowerUpInactivo() {
		// TODO Auto-generated method stub
		return null;
	}
    
	public Sprite getPiso() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/piso.png");
	}

	@Override
	public Sprite getSpriteInvisible() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spriteInvisible.png");
	}


}
