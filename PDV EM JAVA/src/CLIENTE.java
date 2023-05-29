class Cliente {
    private String nome;
    private String cpf;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome + "\nCPF: " + cpf;
    }
}