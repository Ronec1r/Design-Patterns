package comportamental.br.edu.ifs.designpatterns.mediator;

public abstract class Colaborador {
    protected String id;
    protected Mediador mediador;

    public Colaborador(String id, Mediador mediador) {
        this.id=id;
        this.mediador = mediador;
        this.mediador.registrarColaborador(this);
    }

    public String getId() {
        return this.id;
    }

    public void setMediador(Mediador mediador) {
        this.mediador = mediador;
    }

}
