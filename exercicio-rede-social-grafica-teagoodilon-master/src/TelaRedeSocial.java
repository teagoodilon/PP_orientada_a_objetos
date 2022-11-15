
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Classe criada para implementar a interface gráfica da Rede Social.
 * O objetivo dessa implementação é didático!
 * - Exercitar e apresentar conceitos de GUIs (Interfaces Gráficas de Usuário)
 * e Tratamento de Exceções
 * 
 * @author Julio Cesar Alves
 */
public class TelaRedeSocial {
    // Janela da nossa tela
    private JFrame janela;
    // Caixa de texto para exibir o feed de noticiai
    private JTextArea areaTextoFeed;
    // Botão para postar uma mensagem no feed
    private JButton botaoPostarMensagem;
    // Botão para curtir uma mensagem do feed
    private JButton botaoCurtir;
    // Botão para comentar uma mensagem do feed
    private JButton botaoComentar;
    // Botão para atualizar o feed
    private JButton botaoAtualizar;

    private JComboBox<String> caixaAutores;

    private boolean comboCarregando;

    // Objeto que representa a Regra de Negócios (a lógica da Rede Social em si)
    private FeedNoticias feed;

    /**
     * Construtor da classe: cria o feed, os componentes e monta a tela.
     */
    public TelaRedeSocial() {
        feed = new FeedNoticias();
        comboCarregando = false;
        construirJanela();
    }

    /**
     * Constroi os componentes e monta a janela
     */
    private void construirJanela() throws HeadlessException {
        janela = new JFrame("GUI - Rede Social");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        criarComponentes();

        montarJanela();
    }

    /**
     * Cria os componentes da tela e faz a inscrição nos eventos necessários
     */
    private void criarComponentes() {
        // criando os componentes
        areaTextoFeed = new JTextArea();
        Font fonteFeed = new Font("Bold", Font.ITALIC, 20);
        areaTextoFeed.setFont(fonteFeed);
        botaoPostarMensagem = new JButton("Postar Mensagem");
        botaoCurtir = new JButton("Curtir");
        botaoComentar = new JButton("Comentar");
        botaoAtualizar = new JButton("Atualizar");
        caixaAutores = new JComboBox<>();
        preencheCaixaAutores();

        // impede que o usuário edite a área de texto do feed
        areaTextoFeed.setEditable(false);

        // adiciona o método que tratará o evento de clique no botão Postar Mensagem
        botaoPostarMensagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postarMensagem();
            }
        });

        // adiciona o método que tratará o evento de clique no botão Curtir
        botaoCurtir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                curtirMensagem();
            }
        });

        botaoComentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comentarMensagem();
            }
        });

        botaoAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarAreaTextoFeed();
            }
        });

        caixaAutores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!comboCarregando) {
                    atualizarAreaTextoFeed();
                }
            }
        });

    }

    /**
     * Monta a janela
     */
    private void montarJanela() {
        janela.setSize(500, 600);

        // Para mais detalhes sobre o BorderLayout acesse:
        // https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
        janela.setLayout(new BorderLayout());

        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));
        painelCentral.add(new JLabel("Feed de Notícias"));
        painelCentral.add(areaTextoFeed);
        janela.add(painelCentral, BorderLayout.CENTER);
        JScrollPane scrollTela = new JScrollPane(areaTextoFeed);
        janela.add(scrollTela);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        painelBotoes.add(botaoPostarMensagem);
        painelBotoes.add(botaoCurtir);
        painelBotoes.add(botaoComentar);
        painelBotoes.add(botaoAtualizar);
        janela.add(painelBotoes, BorderLayout.SOUTH);

        JPanel painelTopo = new JPanel();
        painelTopo.add(caixaAutores);
        janela.add(painelTopo, BorderLayout.NORTH);
    }

    /*
     * Exibe a tela da Rede Social
     */
    public void exibir() {
        janela.setVisible(true);
    }

    /**
     * Posta uma mensagem no feed. Solicita o autor e a mensagem ao usuário,
     * posta no Feed e atualiza a área de texto de exibição do feed.
     */
    private void postarMensagem() {
        String autor = JOptionPane.showInputDialog("Autor da mensagem");
        String mensagem = JOptionPane.showInputDialog("Texto da mensagem");
        feed.postarMensagemTexto(autor, mensagem);
        preencheCaixaAutores();
        atualizarAreaTextoFeed();
    }

    /**
     * Curte uma mensagem. Solicita o identificador da mensagem ao usuário,
     * curte a mensagem e atualiza a área de texto de exibição do feed.
     */
    private void curtirMensagem() {
        if(feed.nroMensagens() > 0){
            int idMensagem = Integer.parseInt(JOptionPane.showInputDialog("Id da mensagem"));
            try{
                feed.curtir(idMensagem);
            } catch(MensagemNaoEncontradaException e) {
                JOptionPane.showMessageDialog(janela, "Não existe mensagem com o id: " + e.getId(), "Erro", JOptionPane.ERROR_MESSAGE);
                curtirMensagem();
            }
            atualizarAreaTextoFeed();
        } else {
            JOptionPane.showMessageDialog(janela, "Nenhuma mensagem foi postada para curtir!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void comentarMensagem() {
        int idMensagem = Integer.parseInt(JOptionPane.showInputDialog("Id da mensagem"));
        String comentario = JOptionPane.showInputDialog("Digite seu comentario");
        feed.comentar(idMensagem, comentario);
        atualizarAreaTextoFeed();

    }

    private void preencheCaixaAutores() {
        comboCarregando = true;
        caixaAutores.removeAllItems();
        caixaAutores.addItem("todos");
        List<String> autores = feed.getAutores();
        for (String autor : autores) {
            caixaAutores.addItem(autor);
        }
        comboCarregando = false;
    }

    /**
     * Atauliza a área de texto de exibição do Feed.
     */
    private void atualizarAreaTextoFeed() {
        // Limpa a lista de publicações
        areaTextoFeed.setText("");

        String selecao = caixaAutores.getItemAt(caixaAutores.getSelectedIndex());
        // Obtém as publicações do feed de notícia
        List<Publicacao> publicacoes;
        if (selecao.equals("todos")) {
            publicacoes = feed.getPublicacoes();

        } else {
            publicacoes = feed.getPublicacoes(selecao);
        }
        for (Publicacao publicacao : publicacoes) {
            areaTextoFeed.append(publicacao.getTextoExibicao());
        }
    }
}
