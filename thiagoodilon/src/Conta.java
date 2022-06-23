public class Conta {
    private static int numConta = 1000;
    private int id;
    private Cliente cliente;
    private double saldo;
    private double limite;

    public Conta(Cliente cliente, double limite, double saldo) {
        this.id = numConta + 1;
        this.cliente = cliente;
        this.limite = -limite;
        this.saldo = saldo;
        numConta = this.id;
    }

    public Conta(Cliente cliente, double limite) {
        this.id = numConta + 1;
        this.cliente = cliente;
        this.limite = -limite;
        saldo = 0.0;
        numConta = this.id;
    }

    public int getid() {
        return id;
    }

    public int getNum() {
        return numConta;
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

    public boolean transferencia(Conta contaDestino, int valor) {
        if (saque(valor)) {
            contaDestino.deposito(valor);
            return true;
        } else {
            return false;
        }
    }
}
