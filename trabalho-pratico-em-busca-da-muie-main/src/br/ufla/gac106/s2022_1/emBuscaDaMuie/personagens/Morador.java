package br.ufla.gac106.s2022_1.emBuscaDaMuie.personagens;

public class Morador {
  private String nome;
  private String fala;

  public Morador(String nome, String fala){
    this.nome = nome;
    this.fala = fala;
  }

  public String getFala() {
    return fala;
  }

  public String getNome() {
    return nome;
  }
}
