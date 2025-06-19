package comportamental.br.edu.ifs.designpatterns.interpreter.relational;

import comportamental.br.edu.ifs.designpatterns.interpreter.ExpressaoNaoTerminal;
import comportamental.br.edu.ifs.designpatterns.interpreter.terminal.Variavel;

public abstract class ExpressaoRelacional<T extends Comparable<? super T>> extends ExpressaoNaoTerminal {
    protected Variavel<T> termo1;
    protected Variavel<T> termo2;

    public ExpressaoRelacional(Variavel<T> termo1, Variavel<T> termo2) {
        this.termo1 = termo1;
        this.termo2 = termo2;
    }
}
