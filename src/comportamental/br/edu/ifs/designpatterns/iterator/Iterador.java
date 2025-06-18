package comportamental.br.edu.ifs.designpatterns.iterator;

import comportamental.br.edu.ifs.designpatterns.iterator.impl.Musica;

public interface Iterador<G> {
    public boolean temProximo();
    public Musica proximo();
}
