package br.ufla.gac106.s2022_1.emBuscaDaMuie;
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

import br.ufla.gac106.s2022_1.baseJogo.EntidadeGrafica;
import br.ufla.gac106.s2022_1.emBuscaDaMuie.itens.Item;
import br.ufla.gac106.s2022_1.emBuscaDaMuie.personagens.Morador;

public class Ambiente extends EntidadeGrafica {
    // descrição e nome do ambiente
    private String nome;
    private String descricao;
    private Morador morador;
    // ambientes visinhos de acordo com a direção
    private HashMap<String, Ambiente> saidas;
    private String saidaBloqueada;
    private String itemQueAbre;
    private HashMap<String, Item> itens;
    

    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele não tem saidas.
     * "descricao" eh algo como "uma cozinha" ou "um jardim aberto".
     * 
     * @param descricao A descrição do ambiente.
     */
    public Ambiente(String nome, String descricao, String caminho) {
        super(caminho);
        this.nome = nome;
        this.descricao = descricao;
        saidas = new HashMap<String, Ambiente>();
        this.itens = new HashMap<String,Item>();
        saidaBloqueada = null;
        itemQueAbre = null;
    }

    public Ambiente(String nome, String descricao, Item item, String caminho) {
        this(nome, descricao,caminho);
        itens.put(item.getNome(), item);
    }

    public Ambiente(String nome, String descricao, Item item, Morador morador, String caminho) {
        this(nome, descricao,caminho);
        this.morador = morador;
    }

    public Ambiente(String nome, String descricao, Morador morador, String caminho) {
        this(nome, descricao,caminho);
        this.morador = morador;
    }


    public void ajustarSaida(String direcao, Ambiente ambiente) {
        saidas.put(direcao, ambiente);
    }

    /**
     * Função para definir o caminho de um ambiente para outro como bloqueado. Isso faz com que o jogador só possa
     * acessar essa direção se utilizar um item específico.
     * @param direcao direção que será definida como bloqueada.
     * @param ambiente ambiente que terá esse bloqueio.
     * @param itemQueAbre item específico para liberar a passagem.
     */
    public void ajustarSaidaBloqueada(String direcao, Ambiente ambiente, String itemQueAbre){
        ajustarSaida(direcao, ambiente);
        this.saidaBloqueada = direcao;
        this.itemQueAbre = itemQueAbre;
    }

    // Retorna as saídas de um ambiente.
    public String getSaidas() {
        String textoSaidas = "";
        for (String direcao : saidas.keySet()) {
            textoSaidas = textoSaidas + direcao + " ";

        }
        return textoSaidas;
    }

    // Retorna o nome e a descrição dos itens presente no ambiente.
    public String getItens() {
        String textoSaidas = "";
        for (String nome : itens.keySet()) {
            textoSaidas = textoSaidas + nome + " - " + itens.get(nome).getDesc() + "\n";
        }
        return textoSaidas;
    }

    /**
     * @return A descrição do ambiente.
     */
    public String getDescricaoLonga() {
        String desc = "Você está em " + nome + descricao;
        desc += temItem() ? "\nVocê encontrou: " + getItens() : "\nNão há nada aqui\n";
        return desc;
    }

    public String getSaidaBloqueada(){
        return saidaBloqueada;
    }

    public String getItemQueAbre(){
        return itemQueAbre;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome(){
        return nome;
    }

    public Morador getMorador() {
      return morador;
    }

    public String getNomeMorador(){
        return morador.getNome();
    }

    public String getFalaMorador(){
        return morador.getFala();
    }

    public Ambiente getAmbiente(String direcao) {
        if(direcao.equals(saidaBloqueada)){
            return null;
        }
        return saidas.get(direcao);
    }

    // Verifica se existe algum item no ambiente
    public boolean temItem(){
        boolean resultado = itens.isEmpty() ? false : true;
        return resultado;
    }

    // Verifica se existe um item com o nome buscado no ambiente.
    public boolean temItemEspecifico(String item){
        for (String nome : itens.keySet()) {
            if(nome.equals(item)){
                return true;
            }
        }
        return false;
    }

    public int getPesoItem(String item){
        return itens.get(item).getPeso();
    }

    //retira um item do ambiente
    public void pegarItem(String item){
        itens.remove(item);
    }

    /**
     * Função que retorna o objeto Item de um ambiente.
     * @param item nome do item que será buscado.
     * @return  item específico.
     */
    public Item getItem(String item){
        return itens.get(item);
    }

    //deixa um item no ambiente
    public void deixarItem(Item item){
        itens.put(item.getNome(), item);
    }

    /**
     * Função para saber se o jogador utilizou um determinado item para liberar a passagem
     * para outro ambiente.
     * @param item Item que será verificado se é ou não o correto para desbloquear a saída.
     * @return true, em caso de ser o item correto, false, caso não seja.
     */
    public boolean usarItem(Item item){
        if(item.getNome().equals(itemQueAbre)){
            saidaBloqueada = null;
            return true;
        }
        return false;
    }
}
