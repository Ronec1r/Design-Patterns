package criacao.br.edu.ifs.designpatterns.builder.impl;

public class Computador{
    private String processador;
    private int RAM;
    private int HD;

    public Computador(String processador, int ram, int hd) {
        this.processador = processador;
        this.RAM = ram;
        this.HD = hd;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getHD() {
        return HD;
    }

    public void setHD(int HD) {
        this.HD = HD;
    }
}
