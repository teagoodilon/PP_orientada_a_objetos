/**
 * Essa é a classe principal da aplicacao "World of Zull".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.
 * 
 * Usuários podem caminhar em um cenário. E é tudo! Ele realmente precisa ser
 * estendido para fazer algo interessante!
 * 
 * Para jogar esse jogo, crie uma instancia dessa classe e chame o método
 * "jogar".
 * 
 * Essa classe principal cria e inicializa todas as outras: ela cria os
 * ambientes,
 * cria o analisador e começa o jogo. Ela também avalia e executa os comandos
 * que
 * o analisador retorna.
 * 
 * @author Michael Kölling and David J. Barnes (traduzido e adaptado por Julio
 *         César Alves)
 */

public class Jogo {
    // analisador de comandos do jogo
    private Analisador analisador;
    // ambiente onde se encontra o jogador
    private Ambiente ambienteAtual;

    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo() {
        criarAmbientes();
        analisador = new Analisador();
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes() {
        Ambiente quintal, cozinha, quartoCaputo, salaDoSofa, sala, quartoDioguinho, sotao;

        // cria os ambientes
        quintal = new Ambiente("quintal","em um espaço aberto e bom pra conversar com o amigo gomes da costa");
        Item pratoEltinho = new Item("prato eltinho", 4, "prato que o eltinho sujou via wi-fi");
        cozinha = new Ambiente("cozinha","da república, a mais limpa de lavras", pratoEltinho);
        Item leiteAzedo = new Item("leite azedo", 2, "esse leite venceu em 2019 e o caputo insiste em tomar");
        quartoCaputo = new Ambiente("quarto do caputo","que tem cheiro de uuuuuui", leiteAzedo);
        sala = new Ambiente("sala","do sem risadola, local favorito dos moradores");
        salaDoSofa = new Ambiente("sala do sofa",", local onde lucas malachias deixou sua marca");
        Item vape = new Item("vape", 1, "esse trem faz mal");
        quartoDioguinho = new Ambiente("quarto do dioguinho",", não deite na cama dele", vape);
        sotao = new Ambiente("sotao","eles se recusam a limpar a caixa d'agua e bebem agua suja");

        // inicializa as saidas dos ambientes
        quintal.ajustarSaida("oeste", cozinha);
        quintal.ajustarSaida("norte", quartoCaputo);
        quintal.ajustarSaida("cima", sotao);
        sotao.ajustarSaida("baixo", quintal);
        cozinha.ajustarSaida("sul", salaDoSofa);
        cozinha.ajustarSaida("leste", quintal);
        quartoCaputo.ajustarSaida("sul", quintal);
        salaDoSofa.ajustarSaida("oeste", sala);
        salaDoSofa.ajustarSaida("norte", cozinha);
        sala.ajustarSaida("norte", quartoDioguinho);
        sala.ajustarSaida("leste", salaDoSofa);
        quartoDioguinho.ajustarSaida("sul", sala);

        ambienteAtual = quintal; // o jogo comeca em frente à quintal
    }

    /**
     * Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar() {
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nós repetidamente lemos comandos e
        // os executamos até o jogo terminar.

        boolean terminado = false;
        while (!terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Até mais!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas() {
        System.out.println();
        System.out.println("Bem-vindo a República Cudi, em busca da muié");
        System.out.println(
                "República Cudi eh um novo jogo de aventura, em que você deve encontrar a muié que assombra a casa.");
        System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
        System.out.println();

        exibirLocal();
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * 
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando) {
        boolean querSair = false;

        if (comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        } else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        } else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        } else if (palavraDeComando.equals("observar")) {
            observar(comando);
        }

        return querSair;
    }

    private void observar(Comando comando) {
        if (comando.temSegundaPalavra()) {
            System.out.println("Observar o que?");
        } else {
            exibirDescLocal();
        }
    }

    /**
     * Exibe informações de ajuda.
     * Aqui nós imprimimos algo bobo e enigmático e a lista de palavras de comando
     */
    private void imprimirAjuda() {
        System.out.println("Voce esta perdido," + ambienteAtual.getDescricao());
        System.out.println("você vê a muié andando pela casa.");
        System.out.println();
        System.out.println("Suas palavras de comando sao:");
        System.out.println("   " + analisador.getPalavrasValidas());
    }

    /**
     * Tenta ir em uma direcao. Se existe uma saída para lá entra no novo ambiente,
     * caso contrário imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando) {
        // se não há segunda palavra, não sabemos pra onde ir...
        if (!comando.temSegundaPalavra()) {
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = ambienteAtual.getAmbiente(direcao);

        if (proximoAmbiente == null) {
            System.out.println("Não há passagem!");
        } else {
            ambienteAtual = proximoAmbiente;
            exibirLocal();
        }
    }

    private void exibirDescLocal() {
        System.out.println(ambienteAtual.getDescricaoLonga());
    }

    private void exibirLocal(){
        System.out.println(ambienteAtual.getNome());
    }

    /**
     * "Sair" foi digitado. Verifica o resto do comando pra ver se nós queremos
     * realmente sair do jogo.
     * 
     * @return true, se este comando sai do jogo, false, caso contrário.
     */
    private boolean sair(Comando comando) {
        if (comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        } else {
            return true; // sinaliza que nós realmente queremos sair
        }
    }
}
