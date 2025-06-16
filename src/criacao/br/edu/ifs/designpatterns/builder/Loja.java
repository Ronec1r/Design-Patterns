package criacao.br.edu.ifs.designpatterns.builder;

import criacao.br.edu.ifs.designpatterns.builder.impl.Computador;
import criacao.br.edu.ifs.designpatterns.builder.impl.ConstrutorComputador;

public class Loja {
    private ConstrutorComputador construtor;

    public Loja(ConstrutorComputador construtor) {
        this.construtor = construtor;
    }

    public Computador construirNotebookGamer(){
        this.construtor.definirArmazenamento(1024);
        this.construtor.definirProcessador("Core i7-13650HX");
        this.construtor.definirRam(16);
        return this.construtor.obterResultado();
    }
    public Computador construirNotebook(){
        this.construtor.definirArmazenamento(512);
        this.construtor.definirProcessador("Core™ i7-1355U");
        this.construtor.definirRam(16);
        return this.construtor.obterResultado();
    }
    public Computador construirNotebookUltra(){
        this.construtor.definirArmazenamento(1024);
        this.construtor.definirProcessador("Core Ultra 7 155H");
        this.construtor.definirRam(32);
        return this.construtor.obterResultado();
    }

}
