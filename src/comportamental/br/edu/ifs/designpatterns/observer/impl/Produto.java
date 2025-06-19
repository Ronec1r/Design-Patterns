package comportamental.br.edu.ifs.designpatterns.observer.impl;

public class Produto extends Sujeito{
    private String nome;
    private int quantidade=0;

    public Produto(String nome) {
        this.nome = nome;
    }

    public void adicionar(int quantidade){
        this.quantidade += quantidade;
        if(this.quantidade>0){
            this.notificar();
        }
    }

    public void remover(int quantidade){
        if(this.quantidade-quantidade<0){
            throw new IllegalArgumentException("Quantidade a remover não pode ser negativa.");
        }
        this.quantidade -= quantidade;
    }

    public boolean estaDisponivel(){
        return this.quantidade > 0;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public void notificar(){
        for(int i=0; i<this.observadores.size(); i++){
            this.observadores.get(i).atualizar(this);
        }
    }

    public String getNome() {
        return nome;
    }
}
