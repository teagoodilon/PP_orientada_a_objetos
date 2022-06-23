import java.util.Scanner;

public class Banco {
    Scanner entrada = new Scanner(System.in);
    private Conta[] conta = new Conta[2];

    public void criarConta() {
        System.out.println("Insira o nome do cliente 1");
        String nome = entrada.nextLine();
        System.out.println("Insira o nome do cliente 2");
        String nome2 = entrada.nextLine();
        System.out.println("Insira o cpf do cliente " + nome);
        String cpf = entrada.nextLine();
        System.out.println("Insira o cpf do cliente " + nome2);
        String cpf2 = entrada.nextLine();
        System.out.println("Insira o limite da conta do cliente " + nome);
        double limite = Double.parseDouble(entrada.nextLine());
        System.out.println("Insira o limite da conta do cliente " + nome2);
        double limite2 = Double.parseDouble(entrada.nextLine());
        tiposConta(nome, cpf, limite, 0);
        tiposConta(nome2, cpf2, limite2, 1);
    }

    public void tiposConta(String nome, String cpf, double limite, int numConta){
        System.out.println("Deseja depositar um valor inicial na conta do cliente " + nome);
        System.out.println("(1) Sim");
        System.out.println("(2) Não");
        int comando = Integer.parseInt(entrada.nextLine());
        switch(comando){
            case 1:
                System.out.println("Insira o saldo inicial da conta:");
                double saldo = Double.parseDouble(entrada.nextLine());
                Cliente mCliente = new Cliente(nome, cpf);
                this.conta[numConta] = new Conta(mCliente, limite, saldo);
                System.out.print("Código de identificação da conta: ");
                System.out.println(this.conta[numConta].getid());
                System.out.println("Conta criada com sucesso!\n");
            break;
            case 2:
                Cliente cliente = new Cliente(nome, cpf);
                this.conta[numConta] = new Conta(cliente, limite, 0.0);
                System.out.print("Código de identificação da conta: ");
                System.out.println(this.conta[numConta].getid());
                System.out.println("Conta criada com sucesso!\n");
            break;
            default:
                System.out.println("Comando Inválido, tente novamente\n");
                tiposConta(nome, cpf, limite, numConta);
            break;
        }
    }

    public void consultarSaldo(int idconta) {
        idconta -= 1001;
        System.out.print("Cliente: ");
        System.out.println(this.conta[idconta].getNomeCliente());
        System.out.print("Saldo em conta: R$");
        System.out.println(this.conta[idconta].getSaldo());
        System.out.println();
    }

    public void depositar(int idconta) {
        idconta -= 1001;
        System.out.println("Qual o valor do depósito?");
        double valorDepositado = Double.parseDouble(entrada.nextLine());
        this.conta[idconta].deposito(valorDepositado);
        System.out.println("Valor depositado com sucesso!\n");
    }

    public void sacar(int idconta) {
        idconta -= 1001;
        System.out.println("Qual o valor a ser sacado?");
        double valorSacado = Double.parseDouble(entrada.nextLine());
        if (this.conta[idconta].saque(valorSacado)) {
            System.out.println("Valor sacado com sucesso! \n");
        } else {
            System.out.println("Não foi possível realizar o saque, pois o cliente não tem esse limite disponível\n");
        }
    }

    public int digiteId(String acao){
        System.out.print("Digite o id da conta que você deseja " + acao);
        int id = Integer.parseInt(entrada.nextLine());
        while(id < 1001 || id > 1002){
            System.out.print("Id inválido, digite novamente: ");
            id = Integer.parseInt(entrada.nextLine());
        }
        return id;
    }

    public void transferencia(){
        if (this.conta[0] != null) {
            System.out.print("Digite o id da conta ORIGEM que você deseja fazer a transferência: ");
            int idO = Integer.parseInt(entrada.nextLine());
            if(idO == conta[0].getid() || idO == conta[1].getid()){
                idO -= 1001;
                System.out.print("Digite o id da conta DESTINO dessa transferência: ");
                int idD = Integer.parseInt(entrada.nextLine());
                if(idD == conta[0].getid() || idD == conta[1].getid()){
                    idD -= 1001;
                    if(idD != idO){
                        System.out.print("Digite o valor da transferência: ");
                        int valor = Integer.parseInt(entrada.nextLine());
                        if(conta[idO].transferencia(conta[idD], valor)){
                            System.out.println("Transferência realizada com sucesso!\n");
                        } else {
                            System.out.println("Não é possível realizar essa transferência, a conta ORIGEM não tem esse limite de saldo\n");
                        }
                    } else {
                        System.out.println("Não é possível fazer uma transferência, a conta para qual você quer transferir é a mesma\n");
                    }
                } else {
                    System.out.println("Não é possível fazer essa transferência, a conta DESTINO não existe\n");
                }
            } else {
                System.out.println("Não é possível fazer essa transferência, a conta ORIGEM não existe\n");
            }    
        } else {
            System.out.println("Nenhuma conta foi criada, voltando ao menu principal\n");
        }
    }

    public void menu() {
        boolean sairMenu = false;
        System.out.println("\nBem vindo ao meu criador de contas bancárias! \n");
        while (!sairMenu) {
            System.out.println("(1) Criar 2 contas");
            System.out.println("(2) Consultar saldo");
            System.out.println("(3) Depositar");
            System.out.println("(4) Sacar");
            System.out.println("(5) Transferência entre contas");
            System.out.println("(6) Sair");
            int comando = Integer.parseInt(entrada.nextLine());
            switch (comando) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    if (this.conta[0] != null) {
                        consultarSaldo(digiteId("consultar o saldo: "));
                    } else {
                        System.out.println("Nenhuma conta foi criada, voltando ao menu principal\n");
                    }
                    break;
                case 3:
                    if (this.conta[0] != null) {
                        depositar(digiteId("depositar: "));
                    } else {
                        System.out.println("Nenhuma conta foi criada, voltando ao menu principal\n");
                    }
                    break;
                case 4:
                    if (this.conta[0] != null) {
                        sacar(digiteId("sacar: "));
                    } else {
                        System.out.println("Nenhuma conta foi criada, voltando ao menu principal\n");
                    }
                    break;
                case 5:
                    transferencia();
                    break;
                case 6:
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