package estrutural.br.edu.ifs.designpatterns.adapter.impl;
import estrutural.br.edu.ifs.designpatterns.adapter.Repositorio;
import estrutural.br.edu.ifs.designpatterns.adapter.RepositorioLista;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdaptadorLista implements Repositorio {
    private RepositorioLista repositorio;

    public AdaptadorLista(RepositorioLista repositorio) {
        this.repositorio=repositorio;
    }

    private Map<String, String> listToMap(List<String> lista){
        Map<String,String> novoMapa = new HashMap();
        for (String line : lista) {
            String[] partes = line.trim().split("\\t", 2);
            if (partes.length == 2) {
                String matricula = partes[0];
                String nomeAluno = partes[1];
                novoMapa.put(matricula, nomeAluno);
            }
        }
        return novoMapa;
    }

    @Override
    public Map<String, String> obterAlunos() {
        return this.listToMap(repositorio.recuperarDados());
    }

}
