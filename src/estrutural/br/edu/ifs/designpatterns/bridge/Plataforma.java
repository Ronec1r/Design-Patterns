package estrutural.br.edu.ifs.designpatterns.bridge;

import estrutural.br.edu.ifs.designpatterns.bridge.obj.Ponto;
import java.util.List;

public interface Plataforma {
    public List<Ponto> animar(Ponto ponto1, Ponto ponto2);
}
