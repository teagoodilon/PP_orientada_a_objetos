package br.ufla.gac106.s2022_1.emBuscaDaMuie.itens;
import br.ufla.gac106.s2022_1.baseJogo.EntidadeGrafica;
import br.ufla.gac106.s2022_1.emBuscaDaMuie.Jogo;
import br.ufla.gac106.s2022_1.emBuscaDaMuie.personagens.Jogador;

public abstract class Item extends EntidadeGrafica{
  private String nome;
  private int peso;
  private String descricao;

  public Item(String nome, int peso, String descricao, String caminho){
    super(caminho);
    this.nome = nome;
    this.peso = peso;
    this.descricao = descricao;
  }

  public String getNome(){
    return nome;
  }

  public int getPeso(){
    return peso;
  }

  public String getDesc(){
    return descricao;
  }

  public abstract String ataque(Jogador jogador, Jogo jogo);

}
