import java.util.ArrayList;
import java.util.List;

public class RelatorioVendas {
    private List<Venda> vendas;

    public RelatorioVendas() {
        this.vendas = new ArrayList<>();
    }

    public void adicionarVenda(Venda venda) {
        this.vendas.add(venda);
    }

    public double getTotalVendas() {
        double total = 0.0;
        for (Venda venda : this.vendas) {
            total += venda.getValor();
        }
        return total;
    }

    public void imprimirRelatorio() {
        System.out.println("Relatório de Vendas:");
        for (Venda venda : this.vendas) {
            System.out.println("Data e Hora: " + venda.getDataHora());
            System.out.println("SKU do Produto: " + venda.getSku());
            System.out.println("Valor da Venda: R$ " + venda.getValor());
            System.out.println("Comissão: R$ " + venda.calcularComissao());
            System.out.println("--------------------");
        }
        System.out.println("Total de Vendas: R$ " + this.getTotalVendas());
    }

    public void zerarVendas() {
        this.vendas.clear();
    }
}