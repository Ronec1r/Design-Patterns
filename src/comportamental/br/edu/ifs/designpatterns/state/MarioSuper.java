package comportamental.br.edu.ifs.designpatterns.state;

public class MarioSuper implements EstadoMario{
    @Override
    public void pegarCogumelo(Mario mario) {

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
        mario.setEstadoAtual(new MarioPequeno());
    }

    @Override
    public String obterAtaque() {
        return "Super salto";
    }

    @Override
    public String obterEstado() {
        return "Super Mario";
    }
}
