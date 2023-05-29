import java.time.LocalDateTime;
import java.util.List;


public class Venda {
    private Cliente cliente;
    private List<Produto> produtos;
    private double valorTotal;
    private String formaPagamento;
    private double valorPago;
    private LocalDateTime dataHora;

    public Venda(Cliente cliente, List<Produto> produtos, double valorTotal, String formaPagamento, double valorPago, double troco, LocalDateTime dataHora) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
        this.dataHora = dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double getTroco() {
        if (formaPagamento.equals("Dinheiro")) {
            return valorPago - valorTotal;
        } else {
            return 0.0;
        }
    }
}
