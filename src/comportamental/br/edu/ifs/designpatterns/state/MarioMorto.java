package comportamental.br.edu.ifs.designpatterns.state;

public class MarioMorto implements EstadoMario{
    @Override
    public void pegarCogumelo(Mario mario) {
        throw new IllegalStateException("Mario está sem vida!");
    }

    @Override
    public void pegarFlor(Mario mario) {
        throw new IllegalStateException("Mario está sem vida!");
    }

    @Override
    public void pegarPena(Mario mario) {
        throw new IllegalStateException("Mario está sem vida!");
    }

    @Override
    public void sofrerDano(Mario mario) {
        throw new IllegalStateException("Mario está sem vida!");
    }

    @Override
    public String obterAtaque() {
        throw new IllegalStateException("Mario está sem vida!");
    }

    @Override
    public String obterEstado() {
        return "Mario morto";
    }
}
