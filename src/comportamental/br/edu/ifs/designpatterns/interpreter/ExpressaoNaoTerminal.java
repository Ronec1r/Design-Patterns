package comportamental.br.edu.ifs.designpatterns.interpreter;

import java.util.ArrayList;
import java.util.List;

public abstract class ExpressaoNaoTerminal extends Expressao{
    protected List<Expressao> expressoes;

    public ExpressaoNaoTerminal() {
        this.expressoes = new ArrayList<>();
    }
}
