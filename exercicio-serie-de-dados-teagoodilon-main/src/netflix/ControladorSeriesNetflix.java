package netflix;

import series.SerieDados;
import series.ControladorSeries;

import java.util.ArrayList;
import java.util.List;

public class ControladorSeriesNetflix implements ControladorSeries {
  private List <SerieDados> lista;

  public ControladorSeriesNetflix(){
    lista = new ArrayList<>();
    SerieDadosFilmes obj1 = new SerieDadosFilmes("brasil", 1, 5);
    SerieDadosSeries obj2 = new SerieDadosSeries("colombia", 1, 5);
    
    obj1.addDado(1, 22);
    obj1.addDado(2, 30);
    obj1.addDado(3, 35);
    obj1.addDado(4, 53);
    obj1.addDado(5, 45);

    obj2.addDado(1, 12);
    obj2.addDado(2, 20);
    obj2.addDado(3, 75);
    obj2.addDado(4, 19);
    obj2.addDado(5, 53);
    
    lista.add(obj1);
    lista.add(obj2);
  }

  @Override
  public List<SerieDados> obterSeriesDados(){
    List <SerieDados> aux = new ArrayList<>();
    aux = lista;
    return aux;
  }
}
