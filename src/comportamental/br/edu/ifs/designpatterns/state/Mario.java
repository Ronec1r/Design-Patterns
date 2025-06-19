package comportamental.br.edu.ifs.designpatterns.state;

public class Mario {
    private EstadoMario estadoAtual;

    public Mario() {
        this.estadoAtual = new MarioPequeno();
    }

    public String atacar(){
        return this.estadoAtual.obterAtaque();
    }

    public void pegarCogumelo(){
        this.estadoAtual.pegarCogumelo(this);
    }

    public void pegarFlor(){
        this.estadoAtual.pegarFlor(this);
    }

    public void pegarPena(){
        this.estadoAtual.pegarPena(this);
    }

    public void sofreDano(){
        this.estadoAtual.sofrerDano(this);
    }

    public String obterEstado() {
        return estadoAtual.obterEstado();
    }

    public void setEstadoAtual(EstadoMario estadoAtual) {
        this.estadoAtual = estadoAtual;
    }
}
