public class Conta {
    private Cliente cliente;
    private double saldo;
    private double limite;

    public Conta(Cliente cliente, double limite) {
        this.cliente = cliente;
        this.limite = -limite;
        saldo = 0.0;
    }

    public String getNomeCliente() { // retorna saldo na conta
        return this.cliente.getNome();
    }

    public double getSaldo() { // retorna saldo na conta
        return saldo;
    }

    public void deposito(double valorDepositado) { // deposita uma quantia na conta
        saldo += valorDepositado;
    }

    public boolean saque(double valorSacado) { // saca um valor da conta desde que esse valor esteja disponível
        if (saldo >= valorSacado || saldo - valorSacado >= limite) {
            saldo -= valorSacado;
            return true;
        } else {
            return false;
        }
    }

}
