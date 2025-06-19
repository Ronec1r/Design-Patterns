package comportamental.br.edu.ifs.designpatterns.state;

public interface EstadoMario {
    public void pegarCogumelo(Mario mario);
    public void pegarFlor(Mario mario);
    public void pegarPena(Mario mario);
    public void sofrerDano(Mario mario);
    public String obterAtaque();
    public String obterEstado();
}
