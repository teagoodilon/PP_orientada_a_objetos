package carros;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;

public class Toro extends Carro {

    public Toro(String cor) {
        super("Toro", Marca.FIAT, cor, 120000, Categoria.LUXO);
    }

}
