package comportamental.br.edu.ifs.designpatterns.template.impl;

import comportamental.br.edu.ifs.designpatterns.template.Bebida;
import java.util.ArrayList;
import java.util.List;

public class Cha extends Bebida {
    @Override
    public List<String> prepararIngredientes() {
        ArrayList ingredientes = new ArrayList<>();
        ingredientes.add("Adicionar um sachê de chá");
        return ingredientes;
    }
}
