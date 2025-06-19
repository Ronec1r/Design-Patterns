package comportamental.br.edu.ifs.designpatterns.command.impl;

import comportamental.br.edu.ifs.designpatterns.command.Comando;
import comportamental.br.edu.ifs.designpatterns.command.Luz;


public class LigarLuz implements Comando {
    private Luz luz;

    public LigarLuz(Luz luz) {
        this.luz = luz;
    }

    @Override
    public void executar() {
        this.luz.ligar();
    }

    @Override
    public String toString() {
        return "ligar " + luz.getNome();
    }
}
