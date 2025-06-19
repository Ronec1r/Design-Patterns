package comportamental.br.edu.ifs.designpatterns.visitor;

import comportamental.br.edu.ifs.designpatterns.visitor.impl.Alimento;
import comportamental.br.edu.ifs.designpatterns.visitor.impl.Cerveja;
import comportamental.br.edu.ifs.designpatterns.visitor.impl.Cigarro;
import comportamental.br.edu.ifs.designpatterns.visitor.impl.Vinho;

public interface Taxador {
    public double visitar(Alimento alimento);
    public double visitar(Cigarro cigarro);
    public double visitar(Cerveja cerveja);
    public double visitar(Vinho vinho);
}
