package comportamental.br.edu.ifs.designpatterns.chain.impl;

public class Emprestimo {
    private double valor;

    public Emprestimo(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
