package estrutural.br.edu.ifs.designpatterns.adapter.impl;

import estrutural.br.edu.ifs.designpatterns.adapter.Repositorio;
import estrutural.br.edu.ifs.designpatterns.adapter.RepositorioString;

import java.util.HashMap;
import java.util.Map;

public class AdaptadorString implements Repositorio {
    private RepositorioString repositorio;

    public AdaptadorString(RepositorioString repositorio) {
        this.repositorio=repositorio;
    }

    private Map<String, String> stringToMap(){
        Map<String,String> novoMapa = new HashMap();
        String dados = repositorio.recuperarDados();
        String[] linhas = dados.split("\\s*;\\s*");
        for (String linha : linhas) {
            String linhaTratada = linha.trim();
            String[] partes = linhaTratada.split("\\t", 2);
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
        return this.stringToMap();
    }
}
