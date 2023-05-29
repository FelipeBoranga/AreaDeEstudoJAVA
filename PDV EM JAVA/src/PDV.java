import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PDV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0;
        boolean continuarCompra = true;
        Cliente cliente = new Cliente();
        List<Produto> produtos = new ArrayList<>();

        System.out.println("Bem-vindo ao PDV!");
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Iniciar compra");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            System.out.print("Digite o nome do cliente: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o CPF do cliente: ");
            String cpf = scanner.nextLine();
            cliente.setNome(nome);
            cliente.setCpf(cpf);
        }

        while (continuarCompra) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Finalizar compra");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Digite o nome do produto: ");
                String nome = scanner.next();
                System.out.print("Digite o preço do produto: ");
                double preco = scanner.nextDouble();
                produtos.add(new Produto(nome, preco));
            } else if (opcao == 2) {
                continuarCompra = false;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        System.out.println("Produtos comprados:");
        for (Produto produto : produtos) {
            System.out.println(produto);
            total += produto.getPreco();
        }
        System.out.println("Total da compra: R$ " + total);
        System.out.print("Dinheiro recebido: R$ ");
        double dinheiroRecebido = scanner.nextDouble();
        double troco = dinheiroRecebido - total;
        System.out.println("Troco: R$ " + troco);

        System.out.println("Dados do cliente:");
        System.out.println(cliente);
    }
}