package comportamental.br.edu.ifs.designpatterns.chain.impl;

import comportamental.br.edu.ifs.designpatterns.chain.Analisador;

public class Gerente extends Analisador {
    @Override
    public Emprestimo processarRequisicao(RequisicaoEmprestimo requisicao){
        return new Emprestimo(requisicao.getValor());
    }
}
