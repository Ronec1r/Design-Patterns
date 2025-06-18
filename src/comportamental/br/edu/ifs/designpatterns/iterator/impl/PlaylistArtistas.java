package comportamental.br.edu.ifs.designpatterns.iterator.impl;

import comportamental.br.edu.ifs.designpatterns.iterator.Agregador;
import comportamental.br.edu.ifs.designpatterns.iterator.Iterador;
import comportamental.br.edu.ifs.designpatterns.iterator.IteradorArtistas;

import java.util.*;

public class PlaylistArtistas implements Agregador {
    private Map<String, List<Musica>> musicas;

    public PlaylistArtistas() {
        this.musicas = new HashMap<>();
    }

    @Override
    public Iterador criarIterador() {
        List<Musica> musicasOrdenadas = new ArrayList<>();
        Set<String> artistasOrdenados = new TreeSet<>(musicas.keySet());
        for (String artista : artistasOrdenados) {
            List<Musica> musicasDoArtista = musicas.get(artista);
            if (musicasDoArtista != null) {
                musicasOrdenadas.addAll(musicasDoArtista);
            }
        }
        return new IteradorArtistas(musicasOrdenadas);
    }

    public void adicionar(Musica musica){
        String artista = musica.getArtista();
        musicas.computeIfAbsent(musica.getArtista(), k -> new ArrayList<>()).add(musica);
    }
}
