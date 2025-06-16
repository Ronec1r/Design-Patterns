package criacao.br.edu.ifs.designpatterns.abstractfactory;

public interface FabricaInterfaceGrafica {
    public Botao criarBotao();
    public Menu criarMenu();
    public Janela criarJanela();
}
