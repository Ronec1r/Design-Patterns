package estrutural.br.edu.ifs.designpatterns.facade.impl;

import java.text.DecimalFormat;

/**
 * 
 */
public class GeradorID {

	/*
	 * 
	 */
	private static long prodID;

	private static long cliID;

	private static long pedID;

	/**
	 * 
	 * @return
	 */
	public static String gerarClienteID() {

		return new DecimalFormat("0000").format(++GeradorID.cliID);
	}

	/**
	 * 
	 * @return
	 */
	public static String gerarProdutoID() {

		return new DecimalFormat("0000").format(++GeradorID.prodID);
	}

	/**
	 * 
	 * @return
	 */
	public static String gerarPedidoID() {

		return new DecimalFormat("0000").format(++GeradorID.pedID);
	}
}
