package comportamental.br.edu.ifs.designpatterns.template.impl;

import comportamental.br.edu.ifs.designpatterns.template.Bebida;
import java.util.ArrayList;
import java.util.List;

public class Cafe extends Bebida {
    @Override
    public List<String> prepararIngredientes() {
        ArrayList ingredientes = new ArrayList<>();
        ingredientes.add("Adicionar uma colher de café");
        return ingredientes;
    }
}
