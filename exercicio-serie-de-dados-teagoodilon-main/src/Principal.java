import netflix.ControladorSeriesNetflix;
import java.util.List;
import series.SerieDados;
import series.VisualizadorSeries;

public class Principal {
    public void executar() {
        ControladorSeriesNetflix controladora = new ControladorSeriesNetflix();
        List <SerieDados> listaDados = controladora.obterSeriesDados();
        VisualizadorSeries visualizadorNetflix = new VisualizadorSeries(listaDados);
        visualizadorNetflix.exibir();
    }
}
