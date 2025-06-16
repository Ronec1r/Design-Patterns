package criacao.br.edu.ifs.designpatterns.abstractfactory.implA;

import criacao.br.edu.ifs.designpatterns.abstractfactory.Botao;
import criacao.br.edu.ifs.designpatterns.abstractfactory.FabricaInterfaceGrafica;
import criacao.br.edu.ifs.designpatterns.abstractfactory.Janela;
import criacao.br.edu.ifs.designpatterns.abstractfactory.Menu;

public class TemaClaro implements FabricaInterfaceGrafica {
    @Override
    public Botao criarBotao() {
        return new BotaoClaro();
    }

    @Override
    public Menu criarMenu() {
        return new MenuClaro();
    }

    @Override
    public Janela criarJanela() {
        return new JanelaClara();
    }
}
