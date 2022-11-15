import java.util.Scanner;

/*
 * Classe que trata a interface com o usuário (menu de opções)
 */
public class InterfaceUsuario {
    private Zoologico zoologico;
    // Scanner para obter dados do usuário via terminal
    private Scanner entrada;

    /* 
     * Construtor da classe
     */
    public InterfaceUsuario() {
        entrada = new Scanner(System.in);
        zoologico = new Zoologico();
    }

    /*
     * Método que trata o loop de exibição e tratamento do menu
     */
    public void executar() {
        int opcao;
        do {
            exibirMenu();
            
            System.out.println("\nDigite sua opção: ");
            opcao = Integer.parseInt(entrada.nextLine());

            tratarMenu(opcao);

        } while (opcao != 5);

        // fecha o objeto Scanner para liberar os seus recursos
        entrada.close();
    }

    /*
     * Método que exibe as opções de menu
     */
    public void exibirMenu() {
        System.out.println("1 - Cadastrar animal");
        System.out.println("2 - Descrever animal");
        System.out.println("3 - Listar animais");        
        System.out.println("4 - Listar animais completo");
        System.out.println("5 - Sair");
    }

    /*
     * Método que trata uma opção de menu escolhida pelo usuário
     */
    private void tratarMenu(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarAnimal();
                break;
            case 2:
                descreverAnimal();
                break;
            case 3:
                listarAnimais();
                break;
            case 4:
                listarAnimaisCompleto();
                break;
            case 5:
                System.out.println("Saindo do programa...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        // se o usuário não estiver saindo do programa, pede para ele digitar ENTER antes de exibir o menu novamente
        if (opcao != 5) {
            System.out.println("\nDigite ENTER para continuar!");
            entrada.nextLine();
        }
    }

    /*
     * Método auxiliar que obtém uma String do usuário
     */
    private String pedirString(String instrucao) {
        System.out.print(instrucao + ": ");
        String informacao = entrada.nextLine();
        return informacao;
    }

    /*
     * Trata a opção de menu: Cadastrar Animal
     */
    private void cadastrarAnimal() {
        System.out.println("Escolha o animal a ser cadastrado:");
        System.out.println("(1) Galinha");
        System.out.println("(2) Aguia");
        System.out.println("(3) Lobo");
        System.out.println("(4) Gato");
        String opcao = entrada.nextLine();
        String nome = pedirString("Escreva o nome do animal");
        switch(opcao){
            case "1":
                zoologico.addGalinha(nome);
            break;
                
            case "2":
                zoologico.addAguia(nome);
            break;

            case "3":
                String corPelo = pedirString("Escreva a cor do pelo");
                zoologico.addLobo(nome, corPelo);
            break;
                
            case "4":
                String corPel = pedirString("Escreva a cor do pelo");
                zoologico.addGato(nome, corPel);
            break;
        }
        
    }

    /*
     * Trata a opção de menu: Descrever Animal
     */
    private void descreverAnimal() {
        System.out.print("Qual o nome do animal que você deseja buscar: ");
        String nome = entrada.nextLine();
        System.out.println(zoologico.descLonga(nome));
    }

    /*
     * Trata a opção de menu: Listar Animais
     */
    private void listarAnimais() {
        System.out.println(zoologico.listarDescGeral());
    }

    /*
     * Trata a opção de menu: Listar Animais
     */
    private void listarAnimaisCompleto() {
        System.out.println(zoologico.listarDescLongaGeral());
    }
}