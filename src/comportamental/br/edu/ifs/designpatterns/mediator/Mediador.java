package comportamental.br.edu.ifs.designpatterns.mediator;

public interface Mediador {
    public String notificar(Colaborador colaborador, String frase);
    public void registrarColaborador(Colaborador colaborador);
}
