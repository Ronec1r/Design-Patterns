package estrutural.br.edu.ifs.designpatterns.bridge.obj;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class Ponto {
    private double x;
    private double y;

    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "{%.2f, %.2f}", x, y);
    }

}
