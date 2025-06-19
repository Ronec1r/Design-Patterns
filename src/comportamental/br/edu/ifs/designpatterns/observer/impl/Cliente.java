package comportamental.br.edu.ifs.designpatterns.observer.impl;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements Observador{
    private String nome;
    private List<String> pedidos;

    public Cliente(String nome) {
        this.nome = nome;
        this.pedidos = new ArrayList<String>();
    }

    public void comprar(Produto produto){
        if(!produto.estaDisponivel()){
            throw new IllegalStateException("Produto indisponível");
        }else{
            this.pedidos.add(produto.getNome());
            produto.remover(1);
        }
    }

    @Override
    public void atualizar(Sujeito sujeito) {
        this.comprar((Produto) sujeito);
    }

    public List<String> getPedidos() {
        return pedidos;
    }
}
