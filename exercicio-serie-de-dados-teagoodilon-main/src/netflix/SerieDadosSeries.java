package netflix;

public class SerieDadosSeries extends SerieDadosNetflix{

  public SerieDadosSeries(String pais, int diaInicial, int diaFinal) {
    super(pais, diaInicial, diaFinal);
  }

  @Override
  public String obterIdentificacaoSerie() {
    return "Quantidade de series assistidos em " + super.getPais();
  }
  
}
