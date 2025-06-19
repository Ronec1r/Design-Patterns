/**
 * 
 */
package test.br.edu.ifs.designpatterns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import comportamental.br.edu.ifs.designpatterns.mediator.Colaborador;
import comportamental.br.edu.ifs.designpatterns.mediator.Mediador;
import comportamental.br.edu.ifs.designpatterns.mediator.impl.Aeronave;
import comportamental.br.edu.ifs.designpatterns.mediator.impl.ControladorTrafego;
import comportamental.br.edu.ifs.designpatterns.mediator.impl.Metereologia;
import comportamental.br.edu.ifs.designpatterns.mediator.impl.Oficina;

/**
 * 
 */
class TestMediator {

	/**
	 * 
	 */
	@Test
	@DisplayName("Teste Mediator")
	void test() {

		/*
		 * Instanciando um controlador de trafego aéreo.
		 * 
		 * A classe ControladorTrafego deve implementar a interface Mediador
		 */
		ControladorTrafego controladorTrafego = new ControladorTrafego();
		assertInstanceOf(Mediador.class, controladorTrafego);

		/*
		 * Instanciando uma entidade responsável pela verificação das condições
		 * metereológicas.
		 * 
		 * A classe Metereologia deve estender a classe abstrata Colaborador
		 */
		Metereologia metereologia = new Metereologia("Metereologia", controladorTrafego);
		assertInstanceOf(Colaborador.class, metereologia);

		/*
		 * Instanciando uma entidade responsável pela verificação das condições
		 * mecânicas das aeronaves.
		 * 
		 * A classe Oficina deve estender a classe abstrata Colaborador
		 */
		Oficina oficina = new Oficina("Oficina", controladorTrafego);
		assertInstanceOf(Colaborador.class, oficina);

		/*
		 * Instanciando um conjunto de aeronaves
		 * 
		 * A classe Aeronave deve estender a classe abstrata Colaborador
		 */
		Aeronave aeronave1 = new Aeronave("Aero1", controladorTrafego);
		Aeronave aeronave2 = new Aeronave("Aero2", controladorTrafego);
		Aeronave aeronave3 = new Aeronave("Aero3", controladorTrafego);
		Aeronave aeronave4 = new Aeronave("Aero4", controladorTrafego);
		Aeronave aeronave5 = new Aeronave("Aero5", controladorTrafego);
		Aeronave aeronave6 = new Aeronave("Aero6", controladorTrafego);
		Aeronave aeronave7 = new Aeronave("Aero7", controladorTrafego);
		Aeronave aeronave8 = new Aeronave("Aero8", controladorTrafego);
		Aeronave aeronave9 = new Aeronave("Aero9", controladorTrafego);
		Aeronave aeronave10 = new Aeronave("Aero10", controladorTrafego);

		assertInstanceOf(Colaborador.class, aeronave1);
		assertInstanceOf(Colaborador.class, aeronave2);
		assertInstanceOf(Colaborador.class, aeronave3);
		assertInstanceOf(Colaborador.class, aeronave4);
		assertInstanceOf(Colaborador.class, aeronave5);
		assertInstanceOf(Colaborador.class, aeronave6);
		assertInstanceOf(Colaborador.class, aeronave7);
		assertInstanceOf(Colaborador.class, aeronave8);
		assertInstanceOf(Colaborador.class, aeronave9);
		assertInstanceOf(Colaborador.class, aeronave10);

		/*
		 * Adicionando aeronaves que necessitam de manutenção
		 */
		oficina.adicionar(aeronave1);
		oficina.adicionar(aeronave3);
		oficina.adicionar(aeronave5);
		oficina.adicionar(aeronave8);

		/*
		 * A classe Metereologia é, por padrão, instanciada com as condições
		 * metereológicas não favoráveis. Logo nenhum pouso ou decolagem deve ser
		 * autorizado.
		 */
		String msg1 = ": Decolagem negada - condições metereológicas.";

		assertEquals(aeronave1.solicitarDecolagem(), aeronave1.getId() + msg1);
		assertEquals(aeronave2.solicitarDecolagem(), aeronave2.getId() + msg1);
		assertEquals(aeronave3.solicitarDecolagem(), aeronave3.getId() + msg1);

		String msg2 = ": Pouso negado - condições metereológicas.";

		assertEquals(aeronave4.solicitarPouso(), aeronave4.getId() + msg2);
		assertEquals(aeronave5.solicitarPouso(), aeronave5.getId() + msg2);
		assertEquals(aeronave6.solicitarPouso(), aeronave6.getId() + msg2);

		/*
		 * Após a mudanças das condições metereológicas é possível informar ao
		 * Controlador de Trafego Áereo que irá autorizar o pouso e a decolagem de todas
		 * as aeronaves que estavam na fila de espera. Contudo, caso alguma aeronave
		 * necessite de manutenção, sua decolagem não deverá ser autorizada.
		 */
		String msg3 = "[Aero4: Pouso autorizado., Aero5: Pouso autorizado., Aero6: Pouso autorizado.]\n"
				+ "[Aero1: Decolagem negada - manutenção., Aero2: Decolagem autorizada., Aero3: Decolagem negada - manutenção.]";

		metereologia.setCondicoesFavoraveis(true);
		assertEquals(metereologia.informarCondicoes(), msg3);

		/*
		 * Verificação das novas solicitações de pousos e decolagems após mudança climática.
		 */
		String msg4 = ": Decolagem autorizada.";
		String msg5 = ": Decolagem negada - manutenção.";

		assertEquals(aeronave7.solicitarDecolagem(), aeronave7.getId() + msg4);
		assertEquals(aeronave8.solicitarDecolagem(), aeronave8.getId() + msg5);

		String msg6 = ": Pouso autorizado.";

		assertEquals(aeronave9.solicitarPouso(), aeronave9.getId() + msg6);
		assertEquals(aeronave10.solicitarPouso(), aeronave10.getId() + msg6);
	}
}