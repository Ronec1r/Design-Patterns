package comportamental.br.edu.ifs.designpatterns.strategy;

public class Ingresso {
    private double valor;
    private EstrategiaDesconto estrategia;

    public Ingresso(double valor, EstrategiaDesconto estrategia) {
        this.valor = valor;
        this.estrategia = estrategia;
    }

    public double calcularValor(){
        return this.estrategia.calculcarDesconto(this.valor);
    }
}
