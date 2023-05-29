import java.util.List;

public class RelatorioVendas {
    public void imprimir(List<Venda> vendas) {
        System.out.println("Relatório de Vendas\n");
        for (Venda venda : vendas) {
            System.out.println("Cliente: " + venda.getCliente());
            System.out.println("Total da compra: R$ " + venda.getTotal());
            System.out.println();
        }
    }
}

class Venda {
    private Cliente cliente;
    private List<Produto> produtos;
    private double total;

    public Venda(Cliente cliente, List<Produto> produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }
}