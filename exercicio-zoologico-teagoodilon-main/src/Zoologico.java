import java.util.ArrayList;

public class Zoologico {
  private ArrayList <Galinha> listaGalinha;
  private ArrayList <Aguia> listaAguia;
  private ArrayList <Lobo> listaLobo;
  private ArrayList <Gato> listaGato;

  public Zoologico(){
    listaGalinha = new ArrayList<>();
    listaAguia = new ArrayList<>();
    listaLobo = new ArrayList<>();
    listaGato = new ArrayList<>();
  }

  public void addGalinha(String nome){
    Galinha galinha = new Galinha(nome);
    listaGalinha.add(galinha);
  }

  public void addAguia(String nome){
    Aguia aguia = new Aguia(nome);
    listaAguia.add(aguia);
  }

  public void addLobo(String nome, String corPelo){
    Lobo lobo = new Lobo(nome, corPelo);
    listaLobo.add(lobo);
  }

  public void addGato(String nome, String corPelo){
    Gato gato = new Gato(nome, corPelo);
    listaGato.add(gato);
  }

  public Galinha buscarGalinha(String nome){         //trecho que estou em dúvida
    for(int i = 0; listaGalinha.size() > i; i++){
      if(listaGalinha.get(i).getNome().equals(nome)){
        return listaGalinha.get(i);
      }
    }
    return null;
  }

  public Aguia buscarAguia(String nome){         //trecho que estou em dúvida
    for(int i = 0; listaAguia.size() > i; i++){
      if(listaAguia.get(i).getNome().equals(nome)){
        return listaAguia.get(i);
      }
    }
    return null;
  }

  public Lobo buscarLobo(String nome){         //trecho que estou em dúvida
    for(int i = 0; listaLobo.size() > i; i++){
      if(listaLobo.get(i).getNome().equals(nome)){
        return listaLobo.get(i);
      }
    }
    return null;
  }

  public Gato buscarGato(String nome){         //trecho que estou em dúvida
    for(int i = 0; listaGato.size() > i; i++){
      if(listaGato.get(i).getNome().equals(nome)){
        return listaGato.get(i);
      }
    }
    return null;
  }

  public String descLonga(String nome){
    String desc = "";
    if(buscarGalinha(nome) != null){
      desc = buscarGalinha(nome).getDescLonga();
      return desc;
    } 
    if(buscarAguia(nome) != null){
      desc = buscarAguia(nome).getDescLonga();
      return desc;
    }
    if(buscarLobo(nome) != null){
      desc = buscarLobo(nome).getDescLonga();
      return desc;
    }
    if(buscarGato(nome) != null){
      desc = buscarGato(nome).getDescLonga();
      return desc;
    }
    return desc = "Não existe animal com esse nome";
  }

  public String listarDescGeral(){
    String desc = "";
    int tam = listaGalinha.size() + listaAguia.size() + listaLobo.size() + listaGato.size();
    if(tam > 0){
      for(int i = 0; i < listaGalinha.size(); i++){
        desc += listaGalinha.get(i).getDescricao() + "\n";
      }

      for(int i = 0; i < listaAguia.size(); i++){
        desc += listaAguia.get(i).getDescricao() + "\n";
      }

      for(int i = 0; i < listaLobo.size(); i++){
        desc += listaLobo.get(i).getDescricao() + "\n";
      }

      for(int i = 0; i < listaGato.size(); i++){
        desc += listaGato.get(i).getDescricao() + "\n";
      }
    } else {
      return desc = "Não há animais cadastrados";
    }
    return desc;
  }

  public String listarDescLongaGeral(){
    String desc = "";
    int tam = listaGalinha.size() + listaAguia.size() + listaLobo.size() + listaGato.size();
    if(tam > 0){
      for(int i = 0; i < listaGalinha.size(); i++){
        desc += listaGalinha.get(i).getDescLonga() + "\n";
      }

      for(int i = 0; i < listaAguia.size(); i++){
        desc += listaAguia.get(i).getDescLonga() + "\n";
      }

      for(int i = 0; i < listaLobo.size(); i++){
        desc += listaLobo.get(i).getDescLonga() + "\n";
      }

      for(int i = 0; i < listaGato.size(); i++){
        desc += listaGato.get(i).getDescLonga() + "\n";
      }
    } else {
      return desc = "Não há animais cadastrados";
    }
    return desc;
  }
}
