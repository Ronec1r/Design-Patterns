package estrutural.br.edu.ifs.designpatterns.composite;

public abstract class Componente {
    private String nome;

    public Componente(String nome) {
        this.nome = nome;
    }

    public abstract double calcularPreco();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
