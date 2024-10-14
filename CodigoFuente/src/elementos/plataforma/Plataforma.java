package elementos.plataforma;

import elementos.ElementosDeJuego;

public abstract class Plataforma extends ElementosDeJuego {
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
