package comportamental.br.edu.ifs.designpatterns.mediator.impl;

import comportamental.br.edu.ifs.designpatterns.mediator.Colaborador;
import comportamental.br.edu.ifs.designpatterns.mediator.Mediador;
import java.util.ArrayList;
import java.util.List;

public class Oficina extends Colaborador {
    private List<Aeronave> manutencao;

    public Oficina(String id, Mediador mediador) {
        super(id, mediador);
        this.manutencao = new ArrayList<>();
    }

    public void adicionar(Aeronave aeronave){
        this.manutencao.add(aeronave);
    }

    public boolean necessitaManutencao(Aeronave aeronave) {
        return manutencao.contains(aeronave);
    }
}
