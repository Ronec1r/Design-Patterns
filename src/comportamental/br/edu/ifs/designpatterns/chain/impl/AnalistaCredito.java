package comportamental.br.edu.ifs.designpatterns.chain.impl;

import comportamental.br.edu.ifs.designpatterns.chain.Analisador;

public class AnalistaCredito extends Analisador {

    @Override
    public Emprestimo processarRequisicao(RequisicaoEmprestimo requisicao){
        if(requisicao.getValor()>requisicao.getRenda()*0.3){
            throw new IllegalStateException("Analista de crédito: Reprovado! Renda insuficiente.");
        }else{
            return sucessor.processarRequisicao(requisicao);
        }
    }
}
