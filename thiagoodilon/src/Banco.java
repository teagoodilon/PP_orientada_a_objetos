import java.util.Scanner;

public class Banco {
    Scanner entrada = new Scanner(System.in);
    private Conta conta;

    public void criarConta() {
        System.out.println("Insira o nome do cliente:");
        String nome = entrada.nextLine();
        System.out.println("Insira o cpf do cliente:");
        String cpf = entrada.nextLine();
        System.out.println("Insira o limite da conta do cliente:");
        double limite = Double.parseDouble(entrada.nextLine());

        Cliente cliente = new Cliente(nome, cpf);
        this.conta = new Conta(cliente, limite);
        System.out.println("Conta criada com sucesso!\n");
    }

    public void consultarSaldo() {
        if (this.conta != null) {
            System.out.println("Cliente:");
            System.out.print(this.conta.getNomeCliente());
            System.out.println("Saldo em conta: R$");
            System.out.print(this.conta.getSaldo());

        } else {
            System.out.println("A conta ainda não foi criada! \n");
        }
    }

    public void depositar() {
        if (this.conta != null) {
            System.out.println("Qual o valor do depósito?");
            double valorDepositado = Double.parseDouble(entrada.nextLine());
            this.conta.deposito(valorDepositado);
            System.out.println("Valor depositado com sucesso!\n");
        } else {
            System.out.println("A conta ainda não foi criada!\n");
        }
    }

    public void sacar() {
        if (this.conta != null) {
            System.out.println("Qual o valor a ser sacado?");
            double valorSacado = Double.parseDouble(entrada.nextLine());
            if (this.conta.saque(valorSacado)) {
                System.out.println("Valor sacado com sucesso\n");
            } else {
                System.out.println("Não foi possível realizar o saque, você não tem esse limite disponível\n");
            }
        } else {
            System.out.println("A conta ainda não foi criada!\n");
        }
    }

    public void menu() {
        boolean sairMenu = false;
        while (!sairMenu) {
            System.out.println("(1) Criar conta");
            System.out.println("(2) Consultar saldo");
            System.out.println("(3) Depositar");
            System.out.println("(4) Sacar");
            System.out.println("(5) Sair");
            int comando = Integer.parseInt(entrada.nextLine());
            switch (comando) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    consultarSaldo();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    sacar();
                    break;
                case 5:
                    sairMenu = true;
                    System.out.println("Obrigado por usar nosso programa!");
                    break;
                default:
                    System.out.println("Comando inválido, tente novamente");
                    break;

            }
        }
    }
}