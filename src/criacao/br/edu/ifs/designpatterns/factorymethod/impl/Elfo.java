package criacao.br.edu.ifs.designpatterns.factorymethod.impl;

import criacao.br.edu.ifs.designpatterns.factorymethod.Personagem;

public class Elfo implements Personagem {
    @Override
    public String atacar() {
        return "Ataque: arco e flecha";
    }

    @Override
    public String defender() {
        return "Defesa: esquiva";
    }

    @Override
    public String usarMagia() {
        return "Magia: cura";
    }
}
