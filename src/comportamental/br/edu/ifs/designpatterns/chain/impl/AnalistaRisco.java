package comportamental.br.edu.ifs.designpatterns.chain.impl;

import comportamental.br.edu.ifs.designpatterns.chain.Analisador;

public class AnalistaRisco extends Analisador {
    @Override
    public Emprestimo processarRequisicao(RequisicaoEmprestimo requisicao){
        if(requisicao.getScoreCredito()<700){
            throw new IllegalStateException("Analista de risco: Reprovado! Score de crédito baixo.");
        }else{
            return sucessor.processarRequisicao(requisicao);
        }
    }
}
