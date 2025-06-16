package criacao.br.edu.ifs.designpatterns.prototype.impl;

import criacao.br.edu.ifs.designpatterns.prototype.Robo;

import java.util.Objects;

public class RoboTanque implements Robo {
    private int forca;
    private int velocidade;
    private String armamento;

    public RoboTanque(int forca, int velocidade, String armamento) {
        this.forca = forca;
        this.velocidade = velocidade;
        this.armamento = armamento;
    }

    @Override
    public Robo clonar() {
        return new RoboTanque(this.forca, this.velocidade, this.armamento);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RoboTanque that = (RoboTanque) o;
        return forca == that.forca && velocidade == that.velocidade && Objects.equals(armamento, that.armamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forca, velocidade, armamento);
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public String getArmamento() {
        return armamento;
    }

    public void setArmamento(String armamento) {
        this.armamento = armamento;
    }
}
