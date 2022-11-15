package br.ufla.gac106.s2022_1.emBuscaDaMuie.personagens;
import br.ufla.gac106.s2022_1.emBuscaDaMuie.itens.Item;

import java.util.ArrayList;

public class Jogador {
  private String nome;
  private ArrayList <Item> mochila;
  private int pesoAtual;
  private int capMochila;
  private boolean alimentado;
  private boolean desvia;

  public Jogador(String nome){
    this.nome = nome;
    mochila = new ArrayList<Item>();
    capMochila = 10;
    pesoAtual = 0;
    alimentado = false;
    desvia = false;
  }

  public String getNome(){
    return nome;
  }

  public int getPesoAtual() {
    return pesoAtual;
  }

  public int getCapMochila() {
    return capMochila;
  }

  public boolean getDesvia(){
    return desvia;
  }

  public boolean estaAlimentado(){
    return alimentado;
  }

  public void setAlimentado(){
    alimentado = !alimentado;
  }
  
  public void setDesvia(){
    desvia = !desvia;
  }

  /**
   * Função para verificar se o jogador pegou um item no ambiente, faz a verificação baseado no peso do item e
   * da capacidade da mochila.
   * @param item O item que o jogador deseja pegar.
   * @return true, em caso do jogador poder pegar o item, false, em caso da mochila não suportar o peso do item.
   */
  public boolean pegouItem(Item item){
    if(item.getPeso() + pesoAtual <= capMochila){
      mochila.add(item);
      pesoAtual += item.getPeso();
      return true;
    } else {
      return false;
    }
  }

  /**
   * Função que retorna um objeto item específico presente na mochila do jogador.
   * @param nomeItem nome do item que será retornado.
   * @return objeto Item.
   */
  public Item getItemMochila(String nomeItem){
    Item item;
    for(int i = 0; mochila.size() > i; i++){
      item = mochila.get(i);
      if(nomeItem.equals(item.getNome())){
        return item;
      }
    }
    return null;
  } 

  /**
   * Função para remover item da mochila do jogador, subtrai o peso do item da mochila.
   * @param nomeItem nome do item a ser removido.
   * @return retorna o objeto item para que ele seja deixado no ambiente no qual o jogador o removeu de sua mochila.
   */
  public Item removeItem(String nomeItem){
    for(int i = 0; mochila.size() > i; i++){
      Item item = mochila.get(i);
      if(nomeItem.equals(item.getNome())){
        mochila.remove(i);
        pesoAtual -= item.getPeso();
        return item;
      }
    }
    return null;
  }

  /**
   * Função verifica se o jogador possui determinado item.
   * @param nomeItem nome do Item que está sendo checado.
   * @return verdadeiro, caso o jogador possua tal item, false, caso não possua.
   */
  public boolean temItem(String nomeItem){
    for(int i = 0; mochila.size() > i; i++){
      Item item = mochila.get(i);
      if(nomeItem.equals(item.getNome())){
        return true;
      }
    }
    return false;
  }
  
  // Função para retornar os nomes dos itens presentes na mochila do jogador.
  public String retornaItens(){
    String itens = "";
    if(mochila.size() > 0){
      for(Item item : mochila){
        itens += item.getNome() + ", ";
      }
    }
    return itens;
  }

  /*
   * Função para retornar o nome dos itens e seu peso,
   * para mostrar para o jogador os itens que ele possui quando a mochila estiver cheia
   * dessa forma ele poderá sabe qual item pode remover para que possa pegar um outro caso seja preciso.
   */
  public String retornaItensPeso(){
    String itens = "";
    if(mochila.size() > 0){
      for(Item item : mochila){
        itens += item.getNome() + " "+  item.getPeso()+", ";
      }
    }
    return itens;
  }

  public Boolean mochilaVazia(){
    return !mochila.isEmpty();
  } 
}
