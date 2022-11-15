package carros;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;

public class Freemont extends Carro {

    public Freemont(String cor) {
        super("Freemont", Marca.FIAT, cor, 90000, Categoria.LUXO);
    }

}
