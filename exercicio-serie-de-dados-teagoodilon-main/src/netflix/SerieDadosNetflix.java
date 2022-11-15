package netflix;

import series.SerieDados;
import java.util.HashMap;

public abstract class SerieDadosNetflix implements SerieDados{
  private String pais;
  private int diaInicial;
  private int diaFinal;
  private HashMap <Integer, Integer> serieDados;

  public SerieDadosNetflix(String pais, int diaInicial, int diaFinal){
    this.pais = pais;
    this.diaInicial = diaInicial;
    this.diaFinal = diaFinal;
    serieDados = new HashMap<>();
  }

  public boolean addDado(int dia, int dado){
    if(dia >= diaInicial && dia <= diaFinal){
      serieDados.put(dia, dado);
      return true;
    } else {
      return false;
    }
  }

  public String getPais(){
    return pais;
  }

  public int obterDiaInicial(){
    return diaInicial;
  }

  public int obterDiaFinal(){

    return diaFinal;
  }

  public int obterDado(int dia){
    return serieDados.get(dia);
  }
}
