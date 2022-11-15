package carros;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;

public class Strada extends Carro {

    public Strada(String cor) {
        super("Strada", Marca.FIAT, cor, 95000, Categoria.PICKUP);
    }

}
