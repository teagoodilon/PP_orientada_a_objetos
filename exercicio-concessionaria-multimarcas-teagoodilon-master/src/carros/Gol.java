package carros;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;

public class Gol extends Carro {

    public Gol(String cor) {
        super("Gol", Marca.VW, cor, 90000, Categoria.POPULAR);
    }

}
