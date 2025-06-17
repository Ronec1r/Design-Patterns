package estrutural.br.edu.ifs.designpatterns.flyweight;

public class TipoBloco implements Flyweight{
    private String nome;
    private boolean inflamavel;
    private boolean quebravel;
    private boolean empilhavel;


    public TipoBloco(String nome, boolean inflamavel, boolean quebravel, boolean empilhavel) {
        this.nome = nome;
        this.inflamavel = inflamavel;
        this.quebravel = quebravel;
        this.empilhavel = empilhavel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isInflamavel() {
        return inflamavel;
    }

    public void setInflamavel(boolean inflamavel) {
        this.inflamavel = inflamavel;
    }

    public boolean isQuebravel() {
        return quebravel;
    }

    public void setQuebravel(boolean quebravel) {
        this.quebravel = quebravel;
    }

    public boolean isEmpilhavel() {
        return empilhavel;
    }

    public void setEmpilhavel(boolean empilhavel) {
        this.empilhavel = empilhavel;
    }

    @Override
    public String mostrar() {
        return "";
    }
}
