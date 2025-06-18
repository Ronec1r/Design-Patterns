package comportamental.br.edu.ifs.designpatterns.iterator;

import comportamental.br.edu.ifs.designpatterns.iterator.impl.Musica;
import java.util.List;

public class IteradorArtistas implements Iterador {
    private List<Musica> playlist;
    private int posicao=0;

    public IteradorArtistas(List<Musica> playlist) {
        this.playlist = playlist;
    }

    @Override
    public Musica proximo(){
        if(this.temProximo()){
            return playlist.get(posicao++);
        }
        return null;
    }

    @Override
    public boolean temProximo(){
        return posicao<playlist.size();
    }
}
