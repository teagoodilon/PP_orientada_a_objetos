package br.ufla.gac106.s2022_1.emBuscaDaMuie.comandos;

/**
 * Esta classe é parte da aplicação "World of Zuul".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.
 * 
 * Essa classe guarda uma enumeração de todos os comandos conhecidos do
 * jogo. Ela é usada no reconhecimento de comandos como eles são digitados.
 *
 * @author Michael Kölling and David J. Barnes (traduzido e adaptado por Julio
 *         César Alves)
 */

public class PalavrasComando {

    // atributo da propria classe para referenciar o unico objeto da classe.
    private static PalavrasComando instancia = null;

    // construtor privado para garantir que a classe possua apenas uma instancia.
    private PalavrasComando(){}

    // um vetor constante que guarda todas as palavras de comandos válidas
    private static final String[] comandosValidos = {
            "ir", "sair", "ajuda", "observar" , "pegar", "largar", "usar", "atacar", "comer"
    };

    /**
     * Verifica se uma dada String é uma palavra de comando válida.
     * 
     * @return true se a string dada é um comando valido, false se não é.
     */
    public boolean ehComando(String umaString) {
        for (int i = 0; i < comandosValidos.length; i++) {
            if (comandosValidos[i].equals(umaString))
                return true;
        }
        // se chegamos aqui, a string não foi encontrada nos comandos.
        return false;
    }

    public String getComandosValidos() {
        String comValido = "";
        for (String comando : comandosValidos) {
            comValido += comando + " ";
        }
        return comValido;
    }

    /**
     * Método que retorna a referência para o único objeto da classe.
     * Na primeira vez que é chamado, a instância é criada; nas demais
     * a instância criada anteriormente é retornada.
     * @return A instancia única da classe.
     */
    public static PalavrasComando getInstancia(){
        if (instancia == null){
            instancia = new PalavrasComando();
        }
        return instancia;
    }


}
