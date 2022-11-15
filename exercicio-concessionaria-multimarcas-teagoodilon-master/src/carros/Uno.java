package carros;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;

public class Uno extends Carro {

    public Uno(String cor) {
        super("Uno", Marca.FIAT, cor, 20000, Categoria.POPULAR);
    }
}
