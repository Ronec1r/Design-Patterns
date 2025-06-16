package criacao.br.edu.ifs.designpatterns.builder;

import criacao.br.edu.ifs.designpatterns.builder.impl.Computador;

public interface Construtor {
    public Computador obterResultado();
    public void definirProcessador(String processador);
    public void definirRam(int ram);
    public void definirArmazenamento(int hd);
}
