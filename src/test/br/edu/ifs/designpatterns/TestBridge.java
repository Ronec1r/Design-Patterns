/**
 * 
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import estrutural.br.edu.ifs.designpatterns.bridge.ObjetoGrafico;
import estrutural.br.edu.ifs.designpatterns.bridge.Plataforma;
import estrutural.br.edu.ifs.designpatterns.bridge.obj.HollowKnight;
import estrutural.br.edu.ifs.designpatterns.bridge.obj.Ponto;
import estrutural.br.edu.ifs.designpatterns.bridge.plat.NintendoSwitch;
import estrutural.br.edu.ifs.designpatterns.bridge.plat.PC;
import estrutural.br.edu.ifs.designpatterns.bridge.plat.Playstation5;
import estrutural.br.edu.ifs.designpatterns.bridge.plat.XBoxSeriesX;

/**
 * 
 */
class TestBridge {

	/**
	 */
	@Test
	@DisplayName("Teste Bridge")
	void test() {

		/*
		 * Instanciação das plataformas.
		 * 
		 * Cada plataforma possui uma taxa de frames por segundo (FPS). Para simplificar
		 * os testes foram definidos os seguintes valores:
		 * 
		 * PC: 5 FPS Xbox: 4 FPS Playstation: 3 FPS Nintendo Switch: 2 FPS
		 */
		PC pc = new PC();
		XBoxSeriesX xbox = new XBoxSeriesX();
		Playstation5 playstation = new Playstation5();
		NintendoSwitch nintendo = new NintendoSwitch();

		/*
		 * Todas as plataformas devem implementar a interface Plataforma
		 */
		assertInstanceOf(Plataforma.class, pc);
		assertInstanceOf(Plataforma.class, xbox);
		assertInstanceOf(Plataforma.class, nintendo);
		assertInstanceOf(Plataforma.class, playstation);

		/*
		 * Testando a configuração do FPS de cada plataforma
		 */
		assertEquals(pc.getFPS(), 5);
		assertEquals(xbox.getFPS(), 4);
		assertEquals(nintendo.getFPS(), 2);
		assertEquals(playstation.getFPS(), 3);

		/*
		 * Instanciando um personagem do jogo Hollow Knight
		 * 
		 * Esse personagem possui os seguintes atributos:
		 * 
		 * Velocidade: 15 posições por segundo;
		 * Impulso do pulo: 15 posições por segundo.
		 * 
		 */
		HollowKnight vesselPC = new HollowKnight(pc);

		/*
		 * Todos os personagens devem estender a classe abstrata ObjetoGrafico
		 */
		assertInstanceOf(ObjetoGrafico.class, vesselPC);

		assertEquals(vesselPC.getVelocidade(), 15);

		/*
		 * Verificando a posição inicial do personagem
		 */
		assertEquals(vesselPC.getPosicao().getX(), 0);
		assertEquals(vesselPC.getPosicao().getY(), 0);

		/*
		 * Verificando a posição após andar para frente
		 */
		vesselPC.andar(true);

		assertEquals(vesselPC.getPosicao().getX(), 15);
		assertEquals(vesselPC.getPosicao().getY(), 0);

		/*
		 * Verificando a posição após andar para trás
		 */
		vesselPC.andar(false);

		assertEquals(vesselPC.getPosicao().getX(), 0);
		assertEquals(vesselPC.getPosicao().getY(), 0);

		/*
		 * Verificando a posição após correr
		 */
		vesselPC.correr(true);

		assertEquals(vesselPC.getPosicao().getX(), 30);
		assertEquals(vesselPC.getPosicao().getY(), 0);

		/*
		 * Verificando a posição após correr para trás
		 */
		vesselPC.correr(false);

		assertEquals(vesselPC.getPosicao().getX(), 0);
		assertEquals(vesselPC.getPosicao().getY(), 0);

		/*
		 * Verificando a posição após pular
		 */
		vesselPC.pular();

		assertEquals(vesselPC.getPosicao().getX(), 0);
		assertEquals(vesselPC.getPosicao().getY(), 0);

		/*
		 * Explicitando as trajetórias que o personagem irá percorrer ao andar a partir
		 * da origem.
		 * 
		 * Obs. Lembrar que cada plataforma possui um FPS diferente, logo as plataformas
		 * com maior taxa de frames por segundo irão apresentar uma quantidade maior de
		 * pontos, tornando a animação mais fluída.
		 */
		String trajetoPC = "[{0.00, 0.00}, {3.00, 0.00}, {6.00, 0.00}, {9.00, 0.00}, {12.00, 0.00}, {15.00, 0.00}]";
		String trajetoXbox = "[{0.00, 0.00}, {3.75, 0.00}, {7.50, 0.00}, {11.25, 0.00}, {15.00, 0.00}]";
		String trajetoPlay5 = "[{0.00, 0.00}, {5.00, 0.00}, {10.00, 0.00}, {15.00, 0.00}]";
		String trajetoNintendo = "[{0.00, 0.00}, {7.50, 0.00}, {15.00, 0.00}]";

		List<Ponto> trajetoria = vesselPC.andar(true);
		assertEquals(trajetoPC, trajetoria.toString());

		trajetoria = new HollowKnight(xbox).andar(true);
		assertEquals(trajetoXbox, trajetoria.toString());

		trajetoria = new HollowKnight(playstation).andar(true);
		assertEquals(trajetoPlay5, trajetoria.toString());

		trajetoria = new HollowKnight(nintendo).andar(true);
		assertEquals(trajetoNintendo, trajetoria.toString());

		/*
		 * Explicitando as trajetórias que o personagem irá percorrer ao pular a partir
		 * da origem.
		 * 
		 * Obs. Lembrar que cada plataforma possui um FPS diferente, logo as plataformas
		 * com maior taxa de frames por segundo irá apresentar uma quantidade maior de
		 * pontos, tornando a animação mais fluída.
		 */
		trajetoPC = "[{0.00, 0.00}, {0.00, 3.00}, {0.00, 6.00}, {0.00, 9.00}, {0.00, 12.00}, {0.00, 15.00}, {0.00, 15.00}, {0.00, 12.00}, {0.00, 9.00}, {0.00, 6.00}, {0.00, 3.00}, {0.00, 0.00}]";
		trajetoXbox = "[{0.00, 0.00}, {0.00, 3.75}, {0.00, 7.50}, {0.00, 11.25}, {0.00, 15.00}, {0.00, 15.00}, {0.00, 11.25}, {0.00, 7.50}, {0.00, 3.75}, {0.00, 0.00}]";
		trajetoPlay5 = "[{0.00, 0.00}, {0.00, 5.00}, {0.00, 10.00}, {0.00, 15.00}, {0.00, 15.00}, {0.00, 10.00}, {0.00, 5.00}, {0.00, 0.00}]";
		trajetoNintendo = "[{0.00, 0.00}, {0.00, 7.50}, {0.00, 15.00}, {0.00, 15.00}, {0.00, 7.50}, {0.00, 0.00}]";

		trajetoria = new HollowKnight(pc).pular();
		assertEquals(trajetoPC,trajetoria.toString());

		trajetoria = new HollowKnight(xbox).pular();
		assertEquals(trajetoXbox,trajetoria.toString());

		trajetoria = new HollowKnight(playstation).pular();
		assertEquals(trajetoPlay5,trajetoria.toString());

		trajetoria = new HollowKnight(nintendo).pular();
		assertEquals(trajetoNintendo,trajetoria.toString());
	}
}