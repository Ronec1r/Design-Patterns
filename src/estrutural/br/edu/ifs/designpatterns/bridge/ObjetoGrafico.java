package estrutural.br.edu.ifs.designpatterns.bridge;

import estrutural.br.edu.ifs.designpatterns.bridge.obj.Ponto;
import java.util.List;

public abstract class ObjetoGrafico {
    protected Ponto posicao;
    protected Plataforma plataforma;

    public ObjetoGrafico(Plataforma plataforma) {
        this.plataforma = plataforma;
        this.posicao = new Ponto(0, 0);
    }

    public Ponto getPosicao() {
        return posicao;
    }

    public abstract List<Ponto> moverDireita(double distancia);
    public abstract List<Ponto> moverEsquerda(double distancia);

}
