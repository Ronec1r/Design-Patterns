package comportamental.br.edu.ifs.designpatterns.state;

public class MarioFogo implements EstadoMario{
    @Override
    public void pegarCogumelo(Mario mario) {
    }

    @Override
    public void pegarFlor(Mario mario) {

    }

    @Override
    public void pegarPena(Mario mario) {
        mario.setEstadoAtual(new MarioVoador());
    }

    @Override
    public void sofrerDano(Mario mario) {
        mario.setEstadoAtual(new MarioSuper());
    }

    @Override
    public String obterAtaque() {
        return "Bola de fogo";
    }

    @Override
    public String obterEstado() {
        return "Mario de fogo";
    }
}
