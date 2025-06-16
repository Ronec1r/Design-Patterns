package criacao.br.edu.ifs.designpatterns.factorymethod;

import criacao.br.edu.ifs.designpatterns.factorymethod.impl.*;

public class FabricaPersonagens {
    public static Personagem criarPersonagem(String nome){
        return switch (nome.toLowerCase()) {
            case "orc" -> new Orc();
            case "anão" -> new Anao();
            case "elfo" -> new Elfo();
            case "humano" -> new Humano();
            default -> throw new IllegalStateException("Personagem não encontrado!");
        };
    }
}
