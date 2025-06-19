package comportamental.br.edu.ifs.designpatterns.interpreter.relational;

import comportamental.br.edu.ifs.designpatterns.interpreter.terminal.Variavel;

public class ExpressaoIgual <T extends Comparable<? super T>> extends ExpressaoRelacional<T>{
    public ExpressaoIgual(Variavel<T> termo1, Variavel<T> termo2) {
        super(termo1, termo2);
    }

    @Override
    public boolean interpretar() {
        return termo1.getValor().compareTo(termo2.getValor()) == 0;
    }

    @Override
    public String toString() {
        return termo1.toString() + " igual a " + termo2.toString();
    }
}
