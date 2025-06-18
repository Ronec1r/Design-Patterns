package comportamental.br.edu.ifs.designpatterns.chain.impl;

public class RequisicaoEmprestimo {
    private double valor;
    private double renda;
    private int scoreCredito;

    public RequisicaoEmprestimo(double valor, double renda, int scoreCredito) {
        this.valor = valor;
        this.renda = renda;
        this.scoreCredito = scoreCredito;
    }

    public double getValor() {
        return valor;
    }

    public double getRenda() {
        return renda;
    }

    public int getScoreCredito() {
        return scoreCredito;
    }

}
