package comportamental.br.edu.ifs.designpatterns.state;

public class MarioPequeno implements EstadoMario{
    @Override
    public void pegarCogumelo(Mario mario) {
        mario.setEstadoAtual(new MarioSuper());
    }

    @Override
    public void pegarFlor(Mario mario) {
        mario.setEstadoAtual(new MarioFogo());
    }

    @Override
    public void pegarPena(Mario mario) {
        mario.setEstadoAtual(new MarioVoador());
    }

    @Override
    public void sofrerDano(Mario mario) {
        mario.setEstadoAtual(new MarioMorto());
    }

    @Override
    public String obterAtaque() {
        return "Salto";
    }

    @Override
    public String obterEstado() {
        return "Mario pequeno";
    }
}
