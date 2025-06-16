package criacao.br.edu.ifs.designpatterns.factorymethod.impl;

import criacao.br.edu.ifs.designpatterns.factorymethod.Personagem;

public class Anao implements Personagem {
    @Override
    public String atacar() {
        return "Ataque: machado";
    }

    @Override
    public String defender() {
        return "Defesa: escudo";
    }

    @Override
    public String usarMagia() {
        return "Magia: resistência";
    }
}
