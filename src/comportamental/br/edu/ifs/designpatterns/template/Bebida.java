package comportamental.br.edu.ifs.designpatterns.template;

import java.util.ArrayList;
import java.util.List;

public abstract class Bebida {

    public List<String> obterPreparo(){
        ArrayList preparo = new ArrayList<>();
        preparo.add(this.prepararXicara());
        for(String passo : this.prepararIngredientes()){
            preparo.add(passo);
        }
        preparo.add(prepararAguaQuente());
        return preparo;
    }
    private String prepararXicara(){
        return "Preparar uma xícara";
    }
    private String prepararAguaQuente(){
        return "Adicionar água quente";
    }
    public abstract List<String> prepararIngredientes();
}
