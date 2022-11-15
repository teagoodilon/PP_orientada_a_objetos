import java.util.ArrayList;

public class Zoologico {
  private ArrayList<Animal> animais;

  public Zoologico() {
    animais = new ArrayList<>();
  }

  public void addGalinha(String nome) {
    Galinha galinha = new Galinha(nome);
    animais.add(galinha);
  }

  public void addAguia(String nome) {
    Aguia aguia = new Aguia(nome);
    animais.add(aguia);
  }

  public void addLobo(String nome, String corPelo) {
    Lobo lobo = new Lobo(nome, corPelo);
    animais.add(lobo);
  }

  public void addGato(String nome, String corPelo) {
    Gato gato = new Gato(nome, corPelo);
    animais.add(gato);
  }

  public Animal buscarAnimal(String nome) { // trecho que estou em dúvida
    for (int i = 0; animais.size() > i; i++) {
      if (animais.get(i).getNome().equals(nome)) {
        return animais.get(i);
      }
    }
    return null;
  }

  public String descLonga(String nome) {
    String desc = "";
    if (buscarAnimal(nome) != null) {
      desc = buscarAnimal(nome).getDescLonga();
      return desc;
    }
    return desc = "Não existe animal com esse nome";
  }

  public String listarDescGeral() {
    String desc = "";
    if (!animais.isEmpty()) {
      for (int i = 0; i < animais.size(); i++) {
        desc += animais.get(i).getDescricao() + "\n";
      }
    } else {
      return desc = "Não há animais cadastrados";
    }
    return desc;
  }

  public String listarDescLongaGeral() {
    String desc = "";
    if (!animais.isEmpty()) {
      for (int i = 0; i < animais.size(); i++) {
        desc += animais.get(i).getDescLonga() + "\n";
      }
    } else {
      return desc = "Não há animais cadastrados";
    }
    return desc;
  }
}
