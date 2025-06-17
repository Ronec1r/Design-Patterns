package estrutural.br.edu.ifs.designpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FabricaBlocos {
    static private Map<String, TipoBloco> mapa = new HashMap<>();

    public static TipoBloco obterTipo(String nome, boolean inflamavel, boolean quebravel, boolean empilhavel){
        TipoBloco resultado = mapa.get(nome);
        if(resultado==null){
            resultado = new TipoBloco(nome, inflamavel, quebravel, empilhavel);
            mapa.put(nome, resultado);
        }
        return resultado;
    }
}
