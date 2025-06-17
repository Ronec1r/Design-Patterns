package estrutural.br.edu.ifs.designpatterns.facade;

import estrutural.br.edu.ifs.designpatterns.facade.impl.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Fachada {
    private Repositorio<List<Pedido>> PedidosPorCliente;
    private Repositorio<Cliente> clientes;
    private Repositorio<Produto> produtos;

    public Fachada() {
        this.clientes = new Repositorio<>();
        this.produtos = new Repositorio<>();
        this.PedidosPorCliente = new Repositorio<>();
    }

    public String registrarCliente(String nome){
        String novoId = "Cli" + GeradorID.gerarClienteID();
        Cliente cliente = new Cliente(novoId, nome);
        this.clientes.criar(novoId, cliente);
        this.PedidosPorCliente.criar(novoId, new ArrayList<>());
        return novoId;
    }

    public String registrarProduto(String nome, double valor){
        String novoId = "Pro" + GeradorID.gerarProdutoID();
        Produto produto = new Produto(novoId, nome, valor);
        this.produtos.criar(novoId, produto);
        return novoId;
    }

    public void escolherProduto(String idCliente, String idProduto){
        Cliente cliente = clientes.recuperar(idCliente);
        Produto produto = produtos.recuperar(idProduto);
        if (cliente != null && produto != null) {
            cliente.getPedido().adicionar(produto);
        }
    }

    public String fecharCompra(String idCliente){
        Cliente cliente = clientes.recuperar(idCliente);
        if (cliente != null && cliente.getPedido() != null && !cliente.getPedido().mostrarPedido().isEmpty()) {
            String idPedido = "Ped" + GeradorID.gerarPedidoID();
            Pedido pedidoFechado = new Pedido();
            pedidoFechado.setId(idPedido);
            for (String produtoStr : cliente.getPedido().mostrarPedido()) {
                List<Produto> produtosDoPedidoEmAndamento = new ArrayList<>();
                Pedido pedidoAtualDoCliente = cliente.getPedido();
                pedidoAtualDoCliente.setId(idPedido);
                List<Pedido> listaPedidosCliente = PedidosPorCliente.recuperar(idCliente);
                if (listaPedidosCliente == null) {
                    listaPedidosCliente = new ArrayList<>();
                    PedidosPorCliente.criar(idCliente, listaPedidosCliente);
                }
                listaPedidosCliente.add(pedidoAtualDoCliente);
                cliente.setPedido(new Pedido());
                return idPedido;
            }
        }
        return null;
    }

    public List<String> listarProdutos() {
        return produtos.recuperar().stream()
                .map(Produto::toString)
                .collect(Collectors.toList());
    }

    public List<String> listarPedidos(String idCliente) {
        List<Pedido> pedidosDoCliente = PedidosPorCliente.recuperar(idCliente);
        if (pedidosDoCliente == null) {
            return new ArrayList<>(); // Retorna uma lista vazia se não houver pedidos para o cliente
        }
        return pedidosDoCliente.stream()
                .map(p -> p.getId() + ": " + p.mostrarPedido().toString())
                .collect(Collectors.toList());
    }

    public List<String> listarClientes() {
        return clientes.recuperar().stream()
                .map(Cliente::toString)
                .collect(Collectors.toList());
    }

    public double obterTotal(String idCliente) {
        Cliente cliente = clientes.recuperar(idCliente);
        if (cliente != null && cliente.getPedido() != null) {
            return cliente.getPedido().valorTotal();
        }
        return 0.0;
    }
}
