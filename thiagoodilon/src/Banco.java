import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Banco {
    Scanner entrada = new Scanner(System.in);
    private Conta[] conta = new Conta[2];

    public void criarConta() {
        System.out.println("Insira o nome do cliente 1:");
        String nome = entrada.nextLine();
        System.out.println("Insira o nome do cliente 2:");
        String nome2 = entrada.nextLine();
        System.out.println("Insira o cpf do cliente 1:");
        String cpf = entrada.nextLine();
        System.out.println("Insira o cpf do cliente 2:");
        String cpf2 = entrada.nextLine();
        System.out.println("Insira o limite da conta do cliente 1:");
        double limite = Double.parseDouble(entrada.nextLine());
        System.out.println("Insira o limite da conta do cliente 2:");
        double limite2 = Double.parseDouble(entrada.nextLine());
        tiposConta(nome, cpf, limite, 0);
        tiposConta(nome2, cpf2, limite2, 1);
        consultarSaldo(conta[0].getid());
        consultarSaldo(conta[1].getid());
    }

    public void tiposConta(String nome, String cpf, double limite, int numConta){
        System.out.println("Deseja depositar um valor inicial em sua conta?");
        System.out.println("(1) Sim");
        System.out.println("(2) Não");
        int comando = Integer.parseInt(entrada.nextLine());
        switch(comando){
            case 1:
                System.out.println("Insira o saldo inicial da conta:");
                double saldo = Double.parseDouble(entrada.nextLine());
                Cliente mCliente = new Cliente(nome, cpf);
                this.conta[numConta] = new Conta(mCliente, limite, saldo);
                System.out.println("Conta criada com sucesso!\n");
            break;
            case 2:
                Cliente cliente = new Cliente(nome, cpf);
                this.conta[numConta] = new Conta(cliente, limite);
                System.out.println("Conta criada com sucesso!\n");
            break;
            default:
                System.out.println("Comando Inválido, tente novamente\n");
                tiposConta(nome, cpf, limite, numConta);
                break;
        }
    }

    public void consultarSaldo(int idconta) {
        if (this.conta != null) {
            System.out.print("Cliente: ");
            System.out.println(this.conta[idconta].getNomeCliente());
            System.out.print("Saldo em conta: R$");
            System.out.println(this.conta[idconta].getSaldo());
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
                System.out.println("Não foi possível realizar o saque, porque o cliente você não tem esse limite disponível\n");
            }
        } else {
            System.out.println("A conta ainda não foi criada!\n");
        }
    }

    public void menu() {
        boolean sairMenu = false;
        while (!sairMenu) {
            System.out.println("(1) Criar 2 contas");
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