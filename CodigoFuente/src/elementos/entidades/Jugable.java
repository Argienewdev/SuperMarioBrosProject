package elementos.entidades;

import java.util.Vector;

public abstract class Jugable extends Entidad {
    //Atributos de instancia
    protected int vidas;

    //Operaciones
    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
    public int getVidas() {
        return vidas;
    }
    public void saltar (Vector<Integer> dir) {
        move(dir);
    }
    public void detenerse (Vector<Integer> dir) {
        posicion = dir;
    }
    public void caer (Vector<Integer> dir){
        move(dir);
    }
    public void ganarVida () {
        vidas++;
    }
    public void perderVida () {
        if (vidas > 0)
            vidas--;
    }
    public void actualizarHud() {}
}
