package comportamental.br.edu.ifs.designpatterns.mediator.impl;

import comportamental.br.edu.ifs.designpatterns.mediator.Colaborador;
import comportamental.br.edu.ifs.designpatterns.mediator.Mediador;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ControladorTrafego implements Mediador {
    private List<Aeronave> pousos;
    private List<Aeronave> decolagens;
    private Metereologia metereologia;
    private Oficina oficina;

    private String ultimoResultadoMetereologiaNotificacao = "";

    public ControladorTrafego() {
        this.pousos = new ArrayList<>();
        this.decolagens = new ArrayList<>();
    }

    @Override
    public void registrarColaborador(Colaborador colaborador) {
        if (colaborador instanceof Metereologia && this.metereologia == null) {
            this.metereologia = (Metereologia) colaborador;
        } else if (colaborador instanceof Oficina && this.oficina == null) {
            this.oficina = (Oficina) colaborador;
        }
    }


    @Override
    public String notificar(Colaborador colaborador, String frase) {
        String resultado = "";

        if (this.metereologia == null || this.oficina == null) {
            throw new IllegalStateException("Erro: ControladorTrafego não possui todas as referências (Metereologia/Oficina) configuradas.");
        }

        if (colaborador instanceof Aeronave) {
            Aeronave aeronave = (Aeronave) colaborador;

            if ("solicitarDecolagem".equals(frase)) {
                if (!metereologia.isCondicoesFavoraveis()) {
                    resultado = aeronave.getId() + ": Decolagem negada - condições metereológicas.";
                    if (!decolagens.contains(aeronave)) {
                        decolagens.add(aeronave);
                    }
                } else if (oficina.necessitaManutencao(aeronave)) {
                    resultado = aeronave.getId() + ": Decolagem negada - manutenção.";
                } else {
                    resultado = aeronave.getId() + ": Decolagem autorizada.";
                    decolagens.remove(aeronave);
                }
            } else if ("solicitarPouso".equals(frase)) {
                if (!metereologia.isCondicoesFavoraveis()) {
                    resultado = aeronave.getId() + ": Pouso negado - condições metereológicas.";
                    if (!pousos.contains(aeronave)) {
                        pousos.add(aeronave);
                    }
                } else {
                    resultado = aeronave.getId() + ": Pouso autorizado.";
                    pousos.remove(aeronave);
                }
            }
        }
        else if (colaborador instanceof Metereologia) {
            List<String> resultadosPouso = new ArrayList<>();
            for (Iterator<Aeronave> it = pousos.iterator(); it.hasNext();) {
                Aeronave a = it.next();
                if (metereologia.isCondicoesFavoraveis()) {
                    resultadosPouso.add(a.getId() + ": Pouso autorizado.");
                    it.remove();
                } else {
                    resultadosPouso.add(a.getId() + ": Pouso negado - condições metereológicas.");
                }
            }


            List<String> resultadosDecolagem = new ArrayList<>();
            for (Iterator<Aeronave> it = decolagens.iterator(); it.hasNext();) {
                Aeronave a = it.next();
                if (!metereologia.isCondicoesFavoraveis()) {
                    resultadosDecolagem.add(a.getId() + ": Decolagem negada - condições metereológicas.");
                } else if (oficina.necessitaManutencao(a)) {
                    resultadosDecolagem.add(a.getId() + ": Decolagem negada - manutenção.");
                } else {
                    resultadosDecolagem.add(a.getId() + ": Decolagem autorizada.");
                    it.remove();
                }
            }

            resultado = "[" + String.join(", ", resultadosPouso) + "]\n"
                    + "[" + String.join(", ", resultadosDecolagem) + "]";
            this.ultimoResultadoMetereologiaNotificacao = resultado;
        }
        return resultado;
    }
}
