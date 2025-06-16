package criacao.br.edu.ifs.designpatterns.builder.impl;

import criacao.br.edu.ifs.designpatterns.builder.Construtor;

public class ConstrutorComputador implements Construtor {
    private String processador;
    private int RAM;
    private int HD;

    @Override
    public Computador obterResultado() {
        return new Computador(this.processador, this.RAM,this.HD);
    }

    @Override
    public void definirProcessador(String processador) {
        this.processador=processador;
    }

    @Override
    public void definirRam(int ram) {
        this.RAM = ram;
    }

    @Override
    public void definirArmazenamento(int hd) {
        this.HD=hd;
    }


}
