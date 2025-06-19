package comportamental.br.edu.ifs.designpatterns.interpreter.terminal;

import comportamental.br.edu.ifs.designpatterns.command.Comando;
import comportamental.br.edu.ifs.designpatterns.interpreter.ExpressaoTerminal;

public class Executavel extends ExpressaoTerminal {
    private Comando comando;

    public Executavel(Comando comando) {
        this.comando = comando;
    }

    @Override
    public boolean interpretar() {
        comando.executar();
        return true;
    }

    @Override
    public String toString() {
        return comando.toString();
    }

}
