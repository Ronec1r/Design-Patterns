package comportamental.br.edu.ifs.designpatterns.chain;

import comportamental.br.edu.ifs.designpatterns.chain.impl.Emprestimo;
import comportamental.br.edu.ifs.designpatterns.chain.impl.RequisicaoEmprestimo;

public abstract class Analisador {
    protected Analisador sucessor;

    public abstract Emprestimo processarRequisicao(RequisicaoEmprestimo requisicao);

    public void definirSucessor(Analisador sucessor){
        this.sucessor=sucessor;
    }
}
