package comportamental.br.edu.ifs.designpatterns.state;

public class MarioVoador implements EstadoMario{
    @Override
    public void pegarCogumelo(Mario mario) {
    }

    @Override
    public void pegarFlor(Mario mario) {
        mario.setEstadoAtual(new MarioFogo());
    }

    @Override
    public void pegarPena(Mario mario) {
    }

    @Override
    public void sofrerDano(Mario mario) {
        mario.setEstadoAtual(new MarioSuper());
    }

    @Override
    public String obterAtaque() {
        return "Capa giratória";
    }

    @Override
    public String obterEstado() {
        return "Mario voador";
    }
}
