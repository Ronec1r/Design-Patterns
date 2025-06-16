package estrutural.br.edu.ifs.designpatterns.bridge.plat;

import estrutural.br.edu.ifs.designpatterns.bridge.Plataforma;
import estrutural.br.edu.ifs.designpatterns.bridge.obj.Ponto;
import java.util.LinkedList;
import java.util.List;

public class XBoxSeriesX implements Plataforma {
    final private int fps=4;

    @Override
    public List<Ponto> animar(Ponto ponto1, Ponto ponto2) {
        List<Ponto> trajetoria = new LinkedList<>();
        trajetoria.add(new Ponto(ponto1.getX(), ponto1.getY()));

        double deltaX = ponto2.getX() - ponto1.getX();
        double deltaY = ponto2.getY() - ponto1.getY();

        double incrementoXPorFrame = deltaX / fps;
        double incrementoYPorFrame = deltaY / fps;

        for (int i = 1; i <= fps; i++) {
            double currentX = ponto1.getX() + (incrementoXPorFrame * i);
            double currentY = ponto1.getY() + (incrementoYPorFrame * i);
            trajetoria.add(new Ponto(currentX, currentY));
        }
        return trajetoria;
    }

    public int getFPS() {
        return this.fps;
    }
}
