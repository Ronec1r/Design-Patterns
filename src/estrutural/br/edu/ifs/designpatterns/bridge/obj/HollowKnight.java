package estrutural.br.edu.ifs.designpatterns.bridge.obj;

import estrutural.br.edu.ifs.designpatterns.bridge.ObjetoGrafico;
import estrutural.br.edu.ifs.designpatterns.bridge.Plataforma;
import java.util.LinkedList;
import java.util.List;

public class HollowKnight extends ObjetoGrafico {
    private double impulso;
    private double velocidade;

    public HollowKnight(Plataforma plataforma) {
        super(plataforma);
        this.velocidade = 15;
        this.impulso = 15;
    }

    @Override
    public List<Ponto> moverDireita(double distancia) {
        double deltaX = distancia;
        Ponto destino = new Ponto(posicao.getX() + deltaX, posicao.getY());
        List<Ponto> trajetoria = plataforma.animar(new Ponto(posicao.getX(), posicao.getY()), destino);
        posicao.setX(destino.getX());
        posicao.setY(destino.getY());
        return trajetoria;
    }

    @Override
    public List<Ponto> moverEsquerda(double distancia) {
        double deltaX = -distancia;
        Ponto destino = new Ponto(posicao.getX() + deltaX, posicao.getY());
        List<Ponto> trajetoria = plataforma.animar(new Ponto(posicao.getX(), posicao.getY()), destino);
        posicao.setX(destino.getX());
        posicao.setY(destino.getY());
        return trajetoria;
    }

    public List<Ponto> andar(boolean andarParaFrente){
        double deltaX = andarParaFrente ? velocidade : -velocidade;
        Ponto destino = new Ponto(posicao.getX() + deltaX, posicao.getY());
        List<Ponto> trajetoria = plataforma.animar(new Ponto(posicao.getX(), posicao.getY()), destino);
        posicao.setX(destino.getX());
        posicao.setY(destino.getY());
        return trajetoria;
    }
    public void correr(boolean correrParaFrente){
        double deltaX = correrParaFrente ? velocidade * 2 : -velocidade * 2;
        Ponto destino = new Ponto(posicao.getX() + deltaX, posicao.getY());
        List<Ponto> trajetoria = plataforma.animar(new Ponto(posicao.getX(), posicao.getY()), destino);
        posicao.setX(destino.getX());
        posicao.setY(destino.getY());
    }
    public List<Ponto> pular(){
        List<Ponto> trajetoriaCompleta = new LinkedList<>();
        Ponto origemPulo = new Ponto(posicao.getX(), posicao.getY());
        Ponto topoPulo = new Ponto(origemPulo.getX(), origemPulo.getY() + impulso);
        List<Ponto> subida = plataforma.animar(origemPulo, topoPulo);
        if (!subida.isEmpty()) {
            trajetoriaCompleta.addAll(subida);
        } else {
            trajetoriaCompleta.add(new Ponto(origemPulo.getX(), origemPulo.getY()));
            trajetoriaCompleta.add(new Ponto(topoPulo.getX(), topoPulo.getY()));
        }
        if (!trajetoriaCompleta.isEmpty() && trajetoriaCompleta.get(trajetoriaCompleta.size() - 1).equals(topoPulo)) {
            trajetoriaCompleta.add(new Ponto(topoPulo.getX(), topoPulo.getY()));
        } else if (trajetoriaCompleta.isEmpty()) {
            trajetoriaCompleta.add(new Ponto(topoPulo.getX(), topoPulo.getY()));
        }
        List<Ponto> descida = plataforma.animar(topoPulo, new Ponto(origemPulo.getX(), origemPulo.getY()));
        if (!descida.isEmpty() && !trajetoriaCompleta.isEmpty() && descida.get(0).equals(trajetoriaCompleta.get(trajetoriaCompleta.size() -1))) {
            descida.remove(0);
        }
        trajetoriaCompleta.addAll(descida);
        posicao.setY(origemPulo.getY());
        return trajetoriaCompleta;
    }

    public double getVelocidade() {
        return velocidade;
    }


}
