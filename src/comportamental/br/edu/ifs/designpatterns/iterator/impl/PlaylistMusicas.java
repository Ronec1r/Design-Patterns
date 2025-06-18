package comportamental.br.edu.ifs.designpatterns.iterator.impl;

import comportamental.br.edu.ifs.designpatterns.iterator.Agregador;
import comportamental.br.edu.ifs.designpatterns.iterator.Iterador;
import comportamental.br.edu.ifs.designpatterns.iterator.IteradorMusicas;
import java.util.ArrayList;
import java.util.List;

public class PlaylistMusicas implements Agregador {
    private List<Musica> musicas;

    public PlaylistMusicas() {
        this.musicas = new ArrayList<>();
    }

    @Override
    public Iterador criarIterador() {
        return new IteradorMusicas(this.musicas);
    }

    public void adicionar(Musica musica){
        this.musicas.add(musica);
    }
}
