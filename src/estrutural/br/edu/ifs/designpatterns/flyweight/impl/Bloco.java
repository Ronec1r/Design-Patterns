package estrutural.br.edu.ifs.designpatterns.flyweight.impl;

import estrutural.br.edu.ifs.designpatterns.flyweight.TipoBloco;

public class Bloco{
    private TipoBloco tipo;
    private int x;
    private int y;
    private int z;

    public Bloco(int x, int y, int z,TipoBloco tipo) {
        this.tipo = tipo;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public TipoBloco getTipo() {
        return tipo;
    }

    public void setTipo(TipoBloco tipo) {
        this.tipo = tipo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String mostrar() {
        return "";
    }
}
