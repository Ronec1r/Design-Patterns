package comportamental.br.edu.ifs.designpatterns.template.impl;

import comportamental.br.edu.ifs.designpatterns.template.Bebida;
import java.util.ArrayList;
import java.util.List;

public class Cappuccino extends Bebida {
    @Override
    public List<String> prepararIngredientes() {
        ArrayList ingredientes = new ArrayList<>();
        ingredientes.add("Adicionar uma colher de café");
        ingredientes.add("Adicionar uma colher de leite em pó");
        ingredientes.add("Adicionar uma colher de chocolate em pó");
        return ingredientes;
    }
}
