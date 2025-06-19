package comportamental.br.edu.ifs.designpatterns.interpreter.terminal;

import comportamental.br.edu.ifs.designpatterns.interpreter.ExpressaoTerminal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Variavel<G extends Comparable<? super G>> extends ExpressaoTerminal {
    private String nome;
    private G contexto;


    public Variavel(String nome, G contexto) {
        this.nome = nome;
        this.contexto = contexto;
    }

    public Variavel(G contexto) {
        this.contexto = contexto;
        if (contexto instanceof LocalTime) {
            this.nome = contexto.toString();
        } else {
            this.nome = "constante";
        }
    }

    public G getValor() {
        return contexto;
    }

    @Override
    public boolean interpretar() {
        return true;
    }

    @Override
    public String toString() {
        if (this.nome != null && !this.nome.isEmpty() && !this.nome.equals(String.valueOf(this.contexto))) {
            return this.nome;
        }
        if (contexto instanceof LocalTime) {
            return ((LocalTime) contexto).format(DateTimeFormatter.ofPattern("HH:mm"));
        }
        return String.valueOf(this.contexto);
    }
}
