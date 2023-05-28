package Banco;

public class Conta {

    private static int idConta = 1 ;
    private int NumeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;

    public Conta(int numeroConta, Pessoa pessoa, Double saldo) {
        NumeroConta = idConta;
        this.pessoa = pessoa;
        this.saldo = saldo;
        idConta += 1;
    }

    public Conta(Pessoa pessoa) {
    }

    public static int getIdConta() {
        return idConta;
    }

    public static void setIdConta(int idConta) {
        Conta.idConta = idConta;
    }

    public int getNumeroConta() {
        return NumeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        NumeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "\nNumero da Conta:"+this.getNumeroConta()+
                "\nNome:"+this.pessoa.getCpf()+
                "\nEmail:"+this.pessoa.getEmail()+
                "\nSaldo:"+Utilitarios.doubleToString(this.getSaldo())+
                "\n";
    }

    public void depositar(Double valor){
        if (valor > 0){
            setSaldo(getSaldo() + valor);
            System.out.print("Seu Deposito foi realizado.");
        }else {
            System.out.print("Não foi possivel realizar o deposito, contate sua agencia.");
        }
    }
    public void sacar(Double valor){
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo()-valor);
            System.out.print("Seu Saque foi realizado!");
        }else{
            System.out.print("Não foi possivel realizar o saque, contate sua agencia.");
        }
    }

    public void transferir(Conta contaParaDeposito, double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo()+valor;
            System.out.print("Transferencia realizada.");
        }else{
            System.out.print("Não foi possivel realizar a transferenciafg, contate sua agencia.");
        }
    }

}
