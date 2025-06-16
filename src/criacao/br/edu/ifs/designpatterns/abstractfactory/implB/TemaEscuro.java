package criacao.br.edu.ifs.designpatterns.abstractfactory.implB;

import criacao.br.edu.ifs.designpatterns.abstractfactory.Botao;
import criacao.br.edu.ifs.designpatterns.abstractfactory.FabricaInterfaceGrafica;
import criacao.br.edu.ifs.designpatterns.abstractfactory.Janela;
import criacao.br.edu.ifs.designpatterns.abstractfactory.Menu;

public class TemaEscuro implements FabricaInterfaceGrafica {
    @Override
    public Botao criarBotao() {
        return new BotaoEscuro();
    }

    @Override
    public Menu criarMenu() {
        return new MenuEscuro();
    }

    @Override
    public Janela criarJanela() {
        return new JanelaEscura();
    }
}
