package br.ufla.gac106.s2022_1.emBuscaDaMuie;

import br.ufla.gac106.s2022_1.baseJogo.InterfaceUsuario;
import br.ufla.gac106.s2022_1.emBuscaDaMuie.comandos.Analisador;
import br.ufla.gac106.s2022_1.emBuscaDaMuie.comandos.Comando;
import br.ufla.gac106.s2022_1.emBuscaDaMuie.itens.*;
import br.ufla.gac106.s2022_1.emBuscaDaMuie.personagens.Jogador;
import br.ufla.gac106.s2022_1.emBuscaDaMuie.personagens.Morador;

import java.time.Instant;
import java.util.Scanner;
import java.time.Duration;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
    private Jogador jogador;
    private boolean ganhou;
    private InterfaceUsuario iu;
    private boolean acabou;

    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo(InterfaceUsuario iu) {
        this.iu = iu;
        criarJogador();
        criarAmbientes();
        analisador = new Analisador(iu);
        ganhou = false;
        acabou = false;
    }

    private void criarJogador() {
        jogador = new Jogador("Vitor");
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes() {
        Ambiente quintal, quartoCaputo, sotao, cozinha, sala, quartoDioguinho,
                salaTrofeu, quartoThiago, quartoHenrique, quartoPatinete, quartoPedro,
                banheiro, garagem;

        Item bolo, armario, faca, macarrao, toalha, aspirador, chave;

        Morador henrique, pedro, adrian, lucas, muie;

        // cria os ambientes e seus itens;
        bolo = new Alimento("bolo", 4, "esse bolo venceu em 2019 e o caputo insiste em comer", "imagens/bolo.png");
        quartoCaputo = new Ambiente("quarto do caputo", ", que tem cheiro de uuuuuui", bolo,
                "imagens/quartoCaputo.png");

        adrian = new Morador("Adrian Veneno", "Cê tá longe do objetivo meu fi, vai lá arrumar seus trem");
        armario = new Utilitario("armario", 12, " alguém ainda vai sair dele", false, "imagens/faca.png");
        sotao = new Ambiente("sotao", ", eles se recusam a limpar a caixa d'agua e bebem água suja", armario, adrian,
                "imagens/sotao.png");

        lucas = new Morador("Lucas", "zZzZzZzZzZz");
        quintal = new Ambiente("quintal", ", um espaço aberto e bom pra conversar com o amigo gomes da costa", lucas,
                "imagens/quintal.png");

        faca = new Arma("faca", "não deixa de ser uma arma, mas acho que pra fantasmas não funciona muito bem", 4,
                "imagens/faca.png");
        cozinha = new Ambiente("cozinha", " da república, a mais limpa de lavras", faca, "imagens/cozinha.png");

        macarrao = new Alimento("macarrao", 3, "do muquem, gente boa d+++, precisava não po", "imagens/macarrao.png");
        sala = new Ambiente("sala", " do sem risadola, você vê rapidamente um cabelo feminino passando ao oeste",
                macarrao, "imagens/sala.png");

        toalha = new Utilitario("toalha", 4, "isso pode ser importante para alguma coisa..", true,
                "imagens/toalha.png");
        quartoDioguinho = new Ambiente("quarto do dioguinho", ", não deite na cama dele", toalha,
                "imagens/quartoDioguinho.png");

        salaTrofeu = new Ambiente("sala dos troféis",
                ", o local mais escuro e empoeirado da cudi, você vê uma movimentação estranha ao sul da casa",
                "imagens/salaTrofeu.png");

        quartoThiago = new Ambiente("quarto do thiago",
                ", esse é point de encontro da casa, você percebe que tem alguém te observando na escada",
                "imagens/quartoThiago.png");

        henrique = new Morador("Henrique",
                "Lembre-se que para conseguir pegar uma arma pesada, você deve estar de buchin chei");
        quartoHenrique = new Ambiente("quarto do henrique", ", silêncio, o iguana está estudando", henrique,
                "imagens/quartoHenrique.png");

        aspirador = new Arma("aspirador", "esse é o aspirador do tata, pode ser usado como uma arma letal", 10,
                "imagens/aspirador.png");
        garagem = new Ambiente("garagem", " do tata movel e tata bike", aspirador, "imagens/garagem.png");

        muie = new Morador("muie", "nu, peguei");
        quartoPatinete = new Ambiente("quarto do patinete",
                ", VOCÊ ACABA DE SE DEPARAR COM A MUIÉ USE SEU ASPIRADOR PARA VENCE-LA", muie,
                "imagens/quartoPatinete.png");

        pedro = new Morador("Pedro", "Lembre-se que você precisa de algo secador para entrar no banheiro");
        quartoPedro = new Ambiente("quarto do pedro", ", ou ele tá tocando violão ou tá tocando cavaco", pedro,
                "imagens/quartoPedro.png");

        chave = new Utilitario("chave", 2, "essa chave pode te ajudar a vencer o desafio", true, "imagens/chave.png");
        banheiro = new Ambiente("banheiro do pedro", ", como entra no banheiro sem toalha, não é mesmo?", chave,
                "imagens/banheiro.png");

        // inicializa as saidas dos ambientes
        quintal.ajustarSaida("norte", quartoCaputo);
        quintal.ajustarSaida("oeste", cozinha);
        quintal.ajustarSaida("cima", sotao);
        sotao.ajustarSaida("baixo", quintal);
        quartoCaputo.ajustarSaida("sul", quintal);
        cozinha.ajustarSaida("leste", quintal);
        cozinha.ajustarSaida("sul", sala);
        sala.ajustarSaida("oeste", quartoDioguinho);
        sala.ajustarSaida("sul", salaTrofeu);
        sala.ajustarSaida("norte", cozinha);
        quartoDioguinho.ajustarSaida("leste", sala);
        salaTrofeu.ajustarSaida("oeste", quartoThiago);
        salaTrofeu.ajustarSaidaBloqueada("leste", quartoPatinete, "chave");
        salaTrofeu.ajustarSaida("sul", quartoPedro);
        salaTrofeu.ajustarSaida("norte", sala);
        quartoThiago.ajustarSaida("baixo", quartoHenrique);
        quartoThiago.ajustarSaida("leste", salaTrofeu);
        quartoHenrique.ajustarSaida("portal", sotao);
        quartoHenrique.ajustarSaida("cima", quartoThiago);
        quartoHenrique.ajustarSaida("sul", garagem);
        garagem.ajustarSaida("norte", quartoHenrique);
        quartoPatinete.ajustarSaida("oeste", salaTrofeu);
        quartoPedro.ajustarSaida("norte", salaTrofeu);
        quartoPedro.ajustarSaidaBloqueada("leste", banheiro, "toalha");
        banheiro.ajustarSaida("oeste", quartoPedro);
        ambienteAtual = quintal; // o jogo comeca no quintal
        iu.ambienteAtualMudou(ambienteAtual);
    }

    public void setAcabou() {
        acabou = true;
    }

    public void setGanhou() {
        ganhou = true;
    }

    /**
     * Rotina principal do jogo. Fica em loop ate terminar o jogo.
     * 
     * @throws IOException
     */
    public void jogar() throws IOException {
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nós repetidamente lemos comandos e
        // os executamos até o jogo terminar.
        Instant instantStarted = Instant.now();
        boolean terminado = false;
        while (!terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        Instant instantStopped = Instant.now();
        Duration durationBetween = Duration.between(instantStarted, instantStopped);
        int tempo = 0;
        if (ganhou) {
            BufferedReader arqRead = new BufferedReader(new FileReader("hall-da-fama.txt"));
            String linha = arqRead.readLine();
            String[] termos = linha.split(",");
            tempo = Integer.parseInt(termos[0]);
            linha = arqRead.readLine();
            arqRead.close();
            if (tempo > durationBetween.getSeconds()) {
                FileWriter arq = new FileWriter("hall-da-fama.txt");
                iu.continuarMensagem("Você terminou o jogo no melhor tempo!!!" + "\n");
                try (Scanner entrada = new Scanner(System.in)) {
                    String nome = iu.obterInformacao("Digite seu nome para o hall da fama: ");
                    arq.write(durationBetween.getSeconds() + ",00 segundos, esse foi o tempo que " + nome
                            + " concluiu o jogo com sucesso!");
                }
                arq.close();
            }
        }
        iu.continuarMensagem("Obrigado por jogar. Até mais!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas() {
        iu.exibirMensagem("Bem-vindo ao Em busca da Muié" + "\n"
                + "Em busca da muié é um novo jogo de aventura, em que você deve encontrar a muié que assombra a casa."
                +
                "\n" + "Digite 'ajuda' se você precisar de ajuda." + "\n");

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
            iu.exibirMensagem("Eu não entendi o que você disse...");
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
        } else if (palavraDeComando.equals("pegar")) {
            pegar(comando);
        } else if (palavraDeComando.equals("largar")) {
            largar(comando);
        } else if (palavraDeComando.equals("usar")) {
            usar(comando);
        } else if (palavraDeComando.equals("comer")) {
            comer(comando);
        } else if (palavraDeComando.equals("atacar")) {
            if (atacar(comando)) {
                querSair = true;
            }
        }
        return querSair;
    }

    private boolean atacar(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            iu.exibirMensagem("Atacar quem?");
            return acabou;
        } else {
            if (ambienteAtual.getMorador() != null) {
                if (ambienteAtual.getNomeMorador().equals("muie")) {
                    String nomeItem = iu.obterInformacao("Com que item?");
                    if (jogador.temItem(nomeItem)) {
                        Item item = jogador.getItemMochila(nomeItem);
                        String entidade = comando.getSegundaPalavra();
                        if (entidade.equals("muie")) {
                            iu.exibirMensagem(item.ataque(jogador, this));
                        } else {
                            iu.exibirMensagem("A muié te arranha até a morte com suas unhas brancas\n");
                            acabou = true;
                        }
                    } else {
                        iu.exibirMensagem("Você não possui esse item\n");
                    }
                } else {
                    iu.exibirMensagem("Não é possível atacar os moradores\n");
                }
            } else {
                iu.exibirMensagem("Não há nada para atacar aqui!\n");
            }
        }
        return acabou;
    }

    private void comer(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            iu.exibirMensagem("Comer o que?");
            return;
        } else {
            String item = comando.getSegundaPalavra();
            if (item.equals("macarrao") && jogador.temItem(item)) {
                iu.jogadorDescartouItem(jogador.getItemMochila(item));
                jogador.removeItem(item);
                jogador.setAlimentado();
                iu.exibirMensagem("Agora você está com o buxin chei e com a força para usar a arma final!\n");
            } else if (item.equals("bolo") && jogador.temItem(item)) {
                iu.jogadorDescartouItem(jogador.getItemMochila(item));
                jogador.removeItem(item);
                jogador.setDesvia();
                iu.exibirMensagem("Você adquiriu o poder de desvio de ataque!\n");
            } else {
                iu.exibirMensagem("Esse item não está na sua mochila");
            }
        }
    }

    private void observar(Comando comando) {
        if (comando.temSegundaPalavra()) {
            iu.exibirMensagem("Observar o que?");
        } else {
            exibirDescLonga();
            if (!jogador.mochilaVazia()) {
                iu.continuarMensagem("Você não possui itens");
            } else {
                iu.continuarMensagem("Seus itens: " + jogador.retornaItens());
            }
            iu.continuarMensagem("Saídas: " + ambienteAtual.getSaidas());
        }
    }

    private void largar(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            iu.exibirMensagem("Largar o que?");
            return;
        }
        String item = comando.getSegundaPalavra();
        Item aux = jogador.removeItem(item);
        if (aux != null) {
            iu.jogadorDescartouItem(aux);
            ambienteAtual.deixarItem(aux);
            iu.exibirMensagem(item + " foi deixado no ambiente...");

        } else {
            iu.exibirMensagem("Item inexistente");
        }

    }

    private void usar(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            iu.exibirMensagem("Usar o que?");
            return;
        }
        String item = comando.getSegundaPalavra();
        if (jogador.temItem(item)) {
            if (ambienteAtual.getSaidaBloqueada() != null) {
                if (jogador.getItemMochila(item).getNome().equals(ambienteAtual.getItemQueAbre())) {
                    if (ambienteAtual.getSaidaBloqueada() != null) {
                        ambienteAtual.usarItem(jogador.getItemMochila(item));
                        iu.jogadorDescartouItem(jogador.getItemMochila(item));
                        jogador.removeItem(item);
                        iu.exibirMensagem("A porta foi aberta com sucesso\n");
                    }
                } else {
                    iu.exibirMensagem("Esse não é o item certo para abrir essa porta!\n");
                }
            } else {
                iu.exibirMensagem("Esse ambiente não tem lugares bloqueados!\n");
            }
        } else {
            iu.exibirMensagem("Você não possui esse item na mochila!\n");
        }
    }

    private void pegar(Comando comando) {
        if (!comando.temSegundaPalavra()) {
            iu.exibirMensagem("Pegar o que?");
            return;
        }
        String item = comando.getSegundaPalavra();
        if (ambienteAtual.temItem()) {
            if (ambienteAtual.temItemEspecifico(item)) {
                if (ambienteAtual.getPesoItem(item) > jogador.getCapMochila()) {
                    iu.exibirMensagem("\nEsse item tem o peso maior que a capacidade da mochila");
                    iu.continuarMensagem("Capacidade: " + jogador.getCapMochila() + "    Peso item: "
                            + ambienteAtual.getPesoItem(item));
                } else if (jogador.pegouItem(ambienteAtual.getItem(item))) {
                    iu.jogadorPegouItem(ambienteAtual.getItem(item));
                    ambienteAtual.pegarItem(item);

                    iu.exibirMensagem("O item " + item + " foi coletado\n");
                } else {
                    iu.exibirMensagem("Não foi possível coletar o item");
                    iu.continuarMensagem("Peso do item = " + ambienteAtual.getPesoItem(item) +
                            "\nPeso disponível = " + (jogador.getCapMochila() - jogador.getPesoAtual()));
                    iu.continuarMensagem("Libere itens para ter espaço");
                    iu.continuarMensagem("Seus itens são:\n" + jogador.retornaItensPeso());
                }
            } else {
                iu.exibirMensagem("Não há esse item aqui");
            }
        } else {
            iu.exibirMensagem("Não há itens aqui");
        }
    }

    /**
     * Exibe informações de ajuda.
     * Aqui nós imprimimos algo bobo e enigmático e a lista de palavras de comando
     */
    private void imprimirAjuda() {
        iu.exibirMensagem("Você esta perdido no(a) " + ambienteAtual.getNome() + ambienteAtual.getDescricao() +
                "\n" + "Você vê a muié andando pela casa.\n" +
                "\n" + "Suas palavras de comando são:" +
                "\n" + analisador.getPalavrasValidas() + "\n" + "\nSaídas: " + ambienteAtual.getSaidas());
    }

    /*
     * Tenta ir em uma direcao. Se existe uma saída para lá entra no novo ambiente,
     * caso contrário imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando) {
        // se não há segunda palavra, não sabemos pra onde ir...
        if (!comando.temSegundaPalavra()) {
            iu.exibirMensagem("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = ambienteAtual.getAmbiente(direcao);

        if (proximoAmbiente == null) {
            if (ambienteAtual.getSaidaBloqueada() == null) {
                iu.exibirMensagem("Não há passagem!");
            } else {
                iu.exibirMensagem("A porta está trancada, você vai precisar de um item para abri-la\n");
            }
        } else {
            ambienteAtual = proximoAmbiente;
            iu.ambienteAtualMudou(ambienteAtual);
            exibirLocal();
        }
    }

    private void exibirDescLonga() {
        iu.exibirMensagem(ambienteAtual.getDescricaoLonga());
        if (ambienteAtual.getMorador() != null) {
            iu.continuarMensagem(ambienteAtual.getNomeMorador() + " diz: " + ambienteAtual.getFalaMorador());
        }
    }

    private void exibirLocal() {
        iu.continuarMensagem("Você está em " + ambienteAtual.getNome());
        iu.continuarMensagem("Saídas: " + ambienteAtual.getSaidas());
    }

    /**
     * "Sair" foi digitado. Verifica o resto do comando pra ver se nós queremos
     * realmente sair do jogo.
     * 
     * @return true, se este comando sai do jogo, false, caso contrário.
     */
    private boolean sair(Comando comando) {
        if (comando.temSegundaPalavra()) {
            iu.exibirMensagem("Sair o que?");
            return false;
        } else {
            return true; // sinaliza que nós realmente queremos sair
        }
    }
}
