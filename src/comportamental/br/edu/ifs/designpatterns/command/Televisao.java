package comportamental.br.edu.ifs.designpatterns.command;

public class Televisao {
    private boolean ligada=false;
    private String nome;
    private int canal=1;

    public Televisao(String nome) {
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

    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }

    public String getNome() {
        return nome;
    }
}
