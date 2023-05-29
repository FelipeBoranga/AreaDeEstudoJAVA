import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class PDV {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Venda> vendas = new ArrayList<>();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Realizar venda");
            System.out.println("3. Gerar relatório de vendas");
            System.out.println("0. Sair");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String nomeCliente = scanner.next();
                    System.out.println("Digite o CPF do cliente:");
                    String cpfCliente = scanner.next();
                    clientes.add(new Cliente(nomeCliente, cpfCliente));
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o CPF do cliente (ou digite 's' para vender sem CPF):");
                    String cpf = scanner.next();
                    Cliente cliente = null;
                    if (!cpf.equalsIgnoreCase("s")) {
                        for (Cliente c : clientes) {
                            if (c.getCPF().equals(cpf)) {
                                cliente = c;
                                break;
                            }
                        }
                        if (cliente == null) {
                            System.out.println("Cliente não encontrado");
                            break;
                        }
                    }
                    ArrayList<Produto> produtos = new ArrayList<>();
                    double valorTotal = 0.0;
                    while (true) {
                        System.out.println("Digite o ID do produto ou 0 para finalizar a venda:");
                        int idProduto = scanner.nextInt();
                        if (idProduto == 0) {
                            break;
                        }
                        Produto produto = null;
                        switch (idProduto) {
                            case 11:
                                produto = new Produto(11, "Refrigerante", 3.50);
                                break;
                            case 14:
                                produto = new Produto(14, "Salgado Frito", 6.00);
                                break;
                            case 15:
                                produto = new Produto(15, "Salgado Assado", 4.99);
                                break;
                            case 24:
                                produto = new Produto(24, "Bolo no Pote", 8.00);
                                break;
                            default:
                                System.out.println("Produto não encontrado");
                                break;
                        }
                        if (produto != null) {
                            produtos.add(produto);
                            valorTotal += produto.getPreco();
                        }
                    }
                    System.out.println("Escolha a forma de pagamento:");
                    System.out.println("1. Cartão");
                    System.out.println("2. Débito");
                    System.out.println("3. Crédito");
                    System.out.println("4. PIX");
                    System.out.println("5. Dinheiro");
                    int formaPagamento = scanner.nextInt();
                    String nomeFormaPagamento = "";
                    switch (formaPagamento) {
                        case 1:
                            nomeFormaPagamento = "Cartão";
                            break;
                        case 2:
                            nomeFormaPagamento = "Débito";
                            break;
                        case 3:
                            nomeFormaPagamento = "Crédito";
                            break;
                        case 4:
                            nomeFormaPagamento = "PIX";
                            break;
                        case 5:
                            nomeFormaPagamento = "Dinheiro";
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    if (!nomeFormaPagamento.equals("")) {
                        double valorPago = 0.0;
                        if (nomeFormaPagamento.equals("Dinheiro")) {
                            System.out.println("Digite o valor pago pelo cliente:");
                            valorPago = scanner.nextDouble();
                        }
                        double troco = valorPago - valorTotal;
                        Venda venda = new Venda(cliente, produtos, valorTotal, nomeFormaPagamento, valorPago, troco, LocalDateTime.now());
                        vendas.add(venda);
                        System.out.println("Venda realizada com sucesso!");
                        if (nomeFormaPagamento.equals("Dinheiro")) {
                            System.out.println("Troco: R$" + troco);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Gerando relatório de vendas:");
                    for (Venda venda : vendas) {
                        System.out.println("Cliente: " + venda.getCliente().getNome());
                        System.out.println("CPF: " + venda.getCliente().getCPF());
                        System.out.println("Produtos:");
                        for (Produto produto : venda.getProdutos()) {
                            System.out.println("    - " + produto.getNome() + ": R$" + produto.getPreco());
                        }
                        System.out.println("Valor total: R$" + venda.getValorTotal());
                        System.out.println("Forma de pagamento: " + venda.getFormaPagamento());
                        if (venda.getFormaPagamento().equals("Dinheiro")) {
                            System.out.println("Valor pago: R$" + venda.getValorPago());
                            System.out.println("Troco: R$" + venda.getTroco());
                        }
                        System.out.println("-------------------------------");
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}