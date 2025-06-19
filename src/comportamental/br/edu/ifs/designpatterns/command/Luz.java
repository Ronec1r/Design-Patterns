package comportamental.br.edu.ifs.designpatterns.command;

public class Luz {
    private boolean ligada=false;
    private String nome;

    public Luz(String nome) {
        this.nome = nome;
    }

    public void ligar(){
        this.ligada=true;
    }
    public void desligar(){
        this.ligada=false;
    }

    public boolean estaLigada(){
        return this.ligada;
    }

    public String getNome() {
        return nome;
    }
}
