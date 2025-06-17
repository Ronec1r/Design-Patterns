package estrutural.br.edu.ifs.designpatterns.composite.impl;

import estrutural.br.edu.ifs.designpatterns.composite.Componente;

public class Item extends Componente {
    private double valor;

    public Item(String nome, double valor) {
        super(nome);
        this.valor = valor;
    }

    @Override
    public double calcularPreco() {
        return this.valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
