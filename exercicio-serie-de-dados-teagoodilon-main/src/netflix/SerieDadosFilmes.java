package netflix;

public class SerieDadosFilmes extends SerieDadosNetflix{

  public SerieDadosFilmes(String pais, int diaInicial, int diaFinal) {
    super(pais, diaInicial, diaFinal);
  }
  
  @Override
  public String obterIdentificacaoSerie(){
    return "Quantidade de filmes assistidos em " + super.getPais();
  }
}
