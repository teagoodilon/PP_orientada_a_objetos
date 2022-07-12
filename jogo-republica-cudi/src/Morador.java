import java.util.ArrayList;

public class Morador {
  private String nome;
  private ArrayList <Item> mochila;

  public Morador(String nome){
    this.nome = nome;
    mochila = new ArrayList<Item>();
  }

  public String getNome(){
    return nome;
  }

  public void adicionaItem(Item item){
    mochila.add(item);
  }

  public String removeItem(String nomeItem){
    String itemRemovido = "Você não pegou este item";
    for(int i = 0; mochila.size() > i; i++){
      Item item = mochila.get(i);
      if(nomeItem.equals(item.getNome())){
        mochila.remove(i);
        return nomeItem;
      }
    }
    return itemRemovido;
  }

  public String retornaItens(){
    String itens = "";
    if(mochila.size() > 0){
      for(Item item : mochila){
        itens += item.getNome() + ", ";
      }
    }
    return itens;
  }
  
}
