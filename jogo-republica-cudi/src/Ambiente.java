
/**
 * Classe Ambiente - um ambiente em um jogo adventure.
 *
 * Esta classe é parte da aplicação "World of Zuul".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.
 *
 * Um "Ambiente" representa uma localização no cenário do jogo. Ele é conectado
 * aos
 * outros ambientes através de saídas. As saídas são nomeadas como norte, sul,
 * leste
 * e oeste. Para cada direção, o ambiente guarda uma referência para o ambiente
 * vizinho,
 * ou null se não há saída naquela direção.
 * 
 * @author Michael Kölling and David J. Barnes (traduzido e adaptado por Julio
 *         César Alves)
 */

import java.util.HashMap;

public class Ambiente {
    // descrição do ambiente
    private String descricao;
    // ambientes visinhos de acordo com a direção
    private HashMap<String, Ambiente> saidas;
    private Item item;

    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele não tem saidas.
     * "descricao" eh algo como "uma cozinha" ou "um jardim aberto".
     * 
     * @param descricao A descrição do ambiente.
     */
    public Ambiente(String descricao) {
        this.descricao = descricao;
        saidas = new HashMap<String, Ambiente>();
        this.item = null;
    }

    public Ambiente(String descricaoItem, Item item) {
        this(descricaoItem);
        this.item = item;
    }

    public void ajustarSaida(String direcao, Ambiente ambiente) {
        saidas.put(direcao, ambiente);
    }

    public String getSaidas() {
        String textoSaidas = "";
        for (String direcao : saidas.keySet()) {
            textoSaidas = textoSaidas + direcao + " ";
        }
        return textoSaidas;
    }

    /**
     * @return A descrição do ambiente.
     */
    public String getDescricaoLonga() {
        String desc = "Voce esta " + descricao;
        if(temItem()){
            desc += "\nVocê encontrou uma " + item.getNome() + ", " + item.getDesc();
        } else {
            desc += "\nNão há nada aqui";
        }
        desc += "\nSaidas: " + getSaidas();
        return desc;
    }

    public String getDescricao() {
        return descricao;
    }

    public Ambiente getAmbiente(String direcao) {
        return saidas.get(direcao);
    }

    public boolean temItem(){
        if(item != null){
            return true;
        } else {
            return false;
        }
    }

}
