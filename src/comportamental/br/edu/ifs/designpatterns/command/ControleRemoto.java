package comportamental.br.edu.ifs.designpatterns.command;

public class ControleRemoto {
    private Comando comando=null;

    public void pressionarBotao(){
        if(comando==null){
            throw new IllegalStateException("Comando não definido");
        }else{
            comando.executar();
        }
    }

    public void definirComando(Comando comando){
        this.comando=comando;
    }
}
