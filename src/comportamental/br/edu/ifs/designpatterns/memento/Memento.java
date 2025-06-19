package comportamental.br.edu.ifs.designpatterns.memento;

public class Memento {
    private int saude;
    private int vida;

    public Memento(int saude, int vida) {
        this.saude = saude;
        this.vida = vida;
    }

    public int getSaude() {
        return saude;
    }

    public int getVida() {
        return vida;
    }
}
