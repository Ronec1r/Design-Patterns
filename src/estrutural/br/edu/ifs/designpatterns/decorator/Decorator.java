package estrutural.br.edu.ifs.designpatterns.decorator;

public abstract class Decorator implements Component{
    protected Component componente;

    public Decorator(Component componente) {
        this.componente = componente;
    }
}
