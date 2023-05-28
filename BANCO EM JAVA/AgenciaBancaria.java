package Banco;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;
    public static void main(String[] args){
        contasBancarias = new ArrayList<>();
        operacoes();

    }
    public static void operacoes() {

        System.out.println("-----------------------------------");
        System.out.println("----------- Banco ArkTek-----------");
        System.out.println("-----------------------------------");
        System.out.println("***Selecione uma operação***");
        System.out.println("-----------------------------------");
        System.out.println("*|  OPÇÃO 1- CRIAR CONTA  |");
        System.out.println("*|  OPÇÃO 2- DEPOSITAR    |");
        System.out.println("*|  OPÇÃO 3- SACAR        |");
        System.out.println("*|  OPÇÃO 4- TRANSFERIR   |");
        System.out.println("*|  OPÇÃO 5- LISTAR       |");
        System.out.println("*|  OPÇÃO 6- SAIR         |");


        int operacao = input.nextInt();
        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("Até mais, obrigado pela preferencia!.");
                System.exit(0);
            default:
                System.out.print("Opção invalida.");
                break;


        }



    }

    public static void criarConta(){
        System.out.print("\nNome: ");
        String nome= input.next();
        System.out.print("\nCPF: ");
        String cpf= input.next();
        System.out.print("\nEmail: ");
        String email= input.next();
        Pessoa pessoa = new Pessoa(nome,cpf,email);
       Conta conta = new Conta(pessoa);
        contasBancarias.add(conta);
        System.out.println("Conta criada com sucesso!");
        operacoes();

    }

    private static Conta encontrarConta(int numeroConta){
        Conta conta = null;
        if (contasBancarias.size() > 0){
            for(Conta c: contasBancarias) {
                if (c.getNumeroConta()== numeroConta);
                conta=c;
            }
        }
        return conta;
    }

    public static void depositar(){
        System.out.print("Numero da conta: ");
        int numeroConta = input.nextInt();
        Conta conta = encontrarConta(numeroConta);
        if (conta !=null) {
            System.out.print("Qual valor deseja depositar? ");
            Double valorDeposito= input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.print("Deposito realizado!");
        }else{
            System.out.print("Seu deposito falhou, procure uma agencia! ");
        }
        operacoes();
    }
    public static void sacar(){
        System.out.print("Numero da conta: ");
        int numeroConta = input.nextInt();
        Conta conta = encontrarConta(numeroConta);
        if (conta !=null) {
            System.out.print("Qual valor deseja sacar? ");
            Double valorSaque= input.nextDouble();
            conta.depositar(valorSaque);
            System.out.print("Saque realizado!");
        }else{
            System.out.print("Seu saque falhou, procure uma agencia! ");
        }
        operacoes();

    }
    public static void transferir(){
        System.out.print("Numero da conta do remetente: ");
        int numeroContaRemetente = input.nextInt();
        Conta contaRemetente = encontrarConta(numeroContaRemetente);
        if (contaRemetente != null){
            System.out.println("Numero da conta do destino: ");
            int numeroContaDestino = input.nextInt();
            Conta contaDestino = encontrarConta(numeroContaDestino);
            if(contaDestino !=null){
                System.out.println("Valor da transferencia: ");
                Double valor = input.nextDouble();
                contaRemetente.transferir(contaDestino, valor);
            }
        }
        operacoes();

    }
    public static void listar(){
        if(contasBancarias.size()>0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);

            }
        }else {
            System.out.println("Conta não cadastrada!");
        }
        operacoes();

    }



}
