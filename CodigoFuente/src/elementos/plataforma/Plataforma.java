package elementos.plataforma;

import elementos.ElementoDeJuego;

public abstract class Plataforma extends ElementoDeJuego {
    //Atributos de instancia
    protected boolean solido;

    //Operaciones
    public void setSolido (boolean sol) {
        solido = sol;
    }
    public  boolean esSolida() {
        return solido;
    }
}
