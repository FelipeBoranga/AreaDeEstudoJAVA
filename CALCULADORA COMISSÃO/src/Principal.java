import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private static RelatorioVendas relatorioVendas = new RelatorioVendas();

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("|         CALCULADORA DE COMISSÃO         |");
            System.out.println("|  (1% DE TODA VENDA APARTIR 75mil 1.5%)  |");
            System.out.println("------------------------------------------");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar venda");
            System.out.println("2 - Mostrar relatório de vendas");
            System.out.println("3 - Zerar vendas");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarVenda(scanner);
                    break;
                case 2:
                    relatorioVendas.imprimirRelatorio();
                    break;
                case 3:
                    relatorioVendas.zerarVendas();
                    System.out.println("Vendas zeradas.");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void adicionarVenda(Scanner scanner) {
        System.out.println("Digite o valor da venda:");
        double valor = scanner.nextDouble();

        System.out.println("Digite o SKU do produto:");
        String sku = scanner.next();

        LocalDateTime dataHora = LocalDateTime.now();

        Venda venda = new Venda(valor, sku, dataHora);
        relatorioVendas.adicionarVenda(venda);

        double comissao = calcularComissao(valor);
        System.out.println("Comissão do vendedor: " + Double.toString(comissao) + "%");

        System.out.println("Venda adicionada com sucesso.");
    }

    public static double calcularComissao(double valor) {
        double comissao;
        if (valor <= 65000) {
            comissao = 1.0;
        } else if (valor <= 75000) {
            comissao = 1.5;
        } else {
            comissao = 2.0;
        }
        return comissao;
    }
}