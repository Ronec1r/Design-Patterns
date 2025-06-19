package comportamental.br.edu.ifs.designpatterns.memento.impl;

import comportamental.br.edu.ifs.designpatterns.memento.Memento;

public class Jogo {
    private int saude=100;
    private int vida=3;

    public Memento salvar(){
        return new Memento(this.saude, this.vida);
    }

    public void restaurar(Memento memento){
        this.saude=memento.getSaude();
        this.vida= memento.getVida();;
    }

    public void causarDano(int dano){
        if(this.vida==1 && this.saude-dano<=0){
            throw new IllegalStateException("Fim de Jogo");
        }
        if(this.vida>=1){
            if(this.saude-dano<=0){
                this.saude=100;
                this.vida-=1;
            }else{
                this.saude = this.saude-dano;
            }
        }
    }

    @Override
    public String toString() {
        return "{" +
                "saúde: " + saude +
                ", vidas: " + vida +
                '}';
    }
}
