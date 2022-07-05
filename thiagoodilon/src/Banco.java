import java.util.Scanner;
import java.util.ArrayList;

public class Banco {
    Scanner entrada = new Scanner(System.in);
    private ArrayList<Conta> conta = new ArrayList<Conta>();

    public void criarConta() {
        System.out.println("Insira o nome do cliente:");
        String nome = entrada.nextLine();
        System.out.print("Insira o cpf do cliente " + nome);
        System.out.println(":");
        String cpf = entrada.nextLine();
        System.out.print("Insira o limite da conta do cliente " + nome);
        System.out.println(":");
        double limite = Double.parseDouble(entrada.nextLine());
        tiposConta(nome, cpf, limite);
    }
    
    public void tiposConta(String nome, String cpf, double limite) {
        Cliente mCliente = new Cliente(nome, cpf);
        System.out.println("Deseja depositar um valor inicial na conta do cliente " + nome);
        System.out.println("(1) Sim");
        System.out.println("(2) Não");
        int comando = Integer.parseInt(entrada.nextLine());
        switch (comando) {
            case 1:
                System.out.println("Insira o saldo inicial da conta:");
                double saldo = Double.parseDouble(entrada.nextLine());
                Conta mConta = new Conta(mCliente, limite, saldo);
                conta.add(mConta);
                System.out.print("Código de identificação da conta: ");
                System.out.println(mConta.getId());
                System.out.println("Conta criada com sucesso!\n");
                break;
            case 2:
                Conta mConta2 = new Conta(mCliente, limite);
                conta.add(mConta2);
                System.out.print("Código de identificação da conta: ");
                System.out.println(mConta2.getId());
                System.out.println("Conta criada com sucesso!\n");
                break;
            default:
                System.out.println("Comando Inválido, tente novamente\n");
                tiposConta(nome, cpf, limite);
                break;
        }
    }

    public void listarContas(){
        if(conta.size() > 0){
            System.out.println("Lista de todas as contas: ");
            for(Conta conta : conta){
                System.out.print("Número da conta: ");
                System.out.print(conta.getId());
                System.out.print(" - Nome do Cliente: ");
                System.out.println(conta.getNomeCliente());
            }
        } else {
            System.out.println("Nenhuma conta foi criada, voltando ao menu principal");
        }
        System.out.println();
    }

    public void consultarSaldo(Conta conta) {
        if(conta != null){
            System.out.print("Cliente: ");
            System.out.println(conta.getNomeCliente());
            System.out.print("Saldo em conta: R$");
            System.out.println(conta.getSaldo());
            System.out.println();
        } 
    }

    public void depositar(Conta conta) {
        if(conta != null){
            System.out.println("Qual o valor do depósito?");
            double valorDepositado = Double.parseDouble(entrada.nextLine());
            conta.deposito(valorDepositado);
            System.out.println("Valor depositado com sucesso!\n");
        }
    }

    public void sacar(Conta conta) {
        if(conta != null){
            System.out.println("Qual o valor a ser sacado?");
            double valorSacado = Double.parseDouble(entrada.nextLine());
            if(conta.saque(valorSacado)) {
                System.out.println("Valor sacado com sucesso!\n");
            } else {
                System.out.println("Não foi possível realizar o saque, pois o cliente não tem esse limite disponível\n");
            }
        }
    }

    public int digiteNum(String acao){
        System.out.print("Digite o número da conta que você deseja " + acao);
        System.out.print(": ");
        int id = Integer.parseInt(entrada.nextLine());
        return id;
    }

    public Conta retornaConta(int id) {
        for(Conta conta : conta){
            if(conta.getId() == id){
                return conta; 
            }
        } 
        System.out.println("Essa conta não existe, voltando ao menu principal\n");
        return null;
    }

    public void transferencia() {
        if (conta.size() > 1) {
            System.out.print("Digite o número da conta ORIGEM que você deseja fazer a transferência: ");
            int idO = Integer.parseInt(entrada.nextLine());
            if (retornaConta(idO) != null) {
                System.out.print("Digite o número da conta DESTINO dessa transferência: ");
                int idD = Integer.parseInt(entrada.nextLine());
                if (retornaConta(idD) != null) {
                    if (idD != idO) {
                        System.out.print("Digite o valor da transferência: ");
                        int valor = Integer.parseInt(entrada.nextLine());
                        if (retornaConta(idO).transferencia(retornaConta(idD), valor)) {
                            System.out.println("Transferência realizada com sucesso!\n");
                        } else {
                            System.out.println("Não é possível realizar essa transferência, a conta ORIGEM não tem esse limite de saldo\n");
                        }
                    } else {
                        System.out.println("Não é possível fazer uma transferência, a conta para qual você quer transferir é a mesma\n");
                    }
                }
            } 
        } else if(conta.size() == 1) {
            System.out.println("Apenas uma conta foi criada, voltando ao menu principal\n");
        } else {
            System.out.println("Nenhuma conta foi criada, voltando ao menu principal\n");
        }
    }

    public void removerConta(Conta conta){
        if(conta != null){
            if(conta.getSaldo() == 0){
                for(int i = 0; i < this.conta.size(); i++){
                    if(this.conta.get(i).getId() == conta.getId()){
                        this.conta.remove(i);
                        System.out.println("Conta removida com sucesso!\n");
                    }
                }
            } else if(conta.getSaldo() > 0){
                System.out.println("Não é possível cancelar uma conta com saldo disponível\n");
            } else {
                System.out.println("Não é possível cancelar uma conta em débito\n");
            }
        }        
    }

    public void menu() {
        boolean sairMenu = false;
        System.out.println("\nBem vindo ao meu criador de contas bancárias!\n");
        while (!sairMenu) {
            System.out.println("(1) Criar conta");
            System.out.println("(2) Listar todas as contas");
            System.out.println("(3) Consultar saldo");
            System.out.println("(4) Depositar");
            System.out.println("(5) Sacar");
            System.out.println("(6) Transferência entre contas");
            System.out.println("(7) Remover conta");
            System.out.println("(8) Sair\n");
            System.out.println("Digite uma opção:");

            int comando = Integer.parseInt(entrada.nextLine());
            switch (comando) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    listarContas();
                    break;    
                case 3:
                    if (conta.size() > 0) {
                        consultarSaldo(retornaConta(digiteNum("consultar o saldo")));
                    } else {
                        System.out.println("Nenhuma conta foi criada, voltando ao menu principal\n");
                    }
                    break;
                case 4:
                    if (conta.size() > 0) {
                        depositar(retornaConta(digiteNum("depositar")));
                    } else {
                        System.out.println("Nenhuma conta foi criada, voltando ao menu principal\n");
                    }
                    break;
                case 5:
                    if (conta.size() > 0) {
                        sacar(retornaConta(digiteNum("sacar")));  
                    } else {
                        System.out.println("Nenhuma conta foi criada, voltando ao menu principal\n");
                    }
                    break;
                case 6:
                    transferencia();
                    break;
                case 7:
                    if (conta.size() > 0) {
                        removerConta(retornaConta(digiteNum("remover")));
                    } else {
                        System.out.println("Nenhuma conta foi criada, voltando ao menu principal\n");
                    }
                    break;
                case 8:
                    sairMenu = true;
                    System.out.println("Obrigado por usar meu programa!");
                    break;
                default:
                    System.out.println("Comando inválido, tente novamente\n");
                    break;
            }
        }
    }
}