import java.time.LocalDateTime;

public class Venda {
    private String sku;
    private double valor;
    private LocalDateTime dataHora;

    private static final double LIMITE_COMISSAO_1 = 65000.00;

    public Venda(double valor, String sku, LocalDateTime dataHora) {
        this.valor = valor;
        this.sku = sku;
        this.dataHora = dataHora;

    }

    public String getSku() {
        return sku;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double calcularComissao() {
        double valorComissao;
        if (this.valor <= LIMITE_COMISSAO_1) {
            valorComissao = this.valor * 0.01;
        } else if (this.valor < 75000.00) {
            valorComissao = LIMITE_COMISSAO_1 * 0.01;
            valorComissao += (this.valor - LIMITE_COMISSAO_1) * 0.015;
        } else {
            valorComissao = LIMITE_COMISSAO_1 * 0.01;
            valorComissao += (75000.00 - LIMITE_COMISSAO_1) * 0.015;
            valorComissao += (this.valor - 75000.00) * 0.02;
        }
        return valorComissao;
    }
}