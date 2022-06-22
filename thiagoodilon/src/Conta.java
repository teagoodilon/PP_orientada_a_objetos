public class Conta {
    static int numContas = 1000;
    private int id;
    private Cliente cliente;
    private double saldo;
    private double limite;

    public Conta(Cliente cliente, double limite) {
        this.id = numContas + 1;
        this.cliente = cliente;
        this.limite = -limite;
        saldo = 0.0;
        numContas = this.id;
    }

    public Conta(Cliente cliente, double limite, double saldo) {
        this.id = numContas + 1;
        this.cliente = cliente;
        this.limite = -limite;
        this.saldo = saldo;
        numContas = this.id;
    }

    public int getid(){
        return id;
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
