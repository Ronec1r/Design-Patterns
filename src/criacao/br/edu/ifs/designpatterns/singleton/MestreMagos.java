package criacao.br.edu.ifs.designpatterns.singleton;

public final class MestreMagos {
    private String nome;
    private int nivelMagia;
    private static MestreMagos instancia;

    private MestreMagos() {
        this.nome="Gandalf";
        this.nivelMagia=1;
    }

    public static MestreMagos obterInstancia(){
        if(instancia == null){
            instancia = new MestreMagos();
        }
        return instancia;
    }

    private static void setInstancia(MestreMagos instancia) {
        MestreMagos.instancia = instancia;
    }

    public void elevarNivel(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivelMagia() {
        return nivelMagia;
    }

}
