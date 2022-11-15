package carros;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;

public class Onix extends Carro {

    public Onix(String cor) {
        super("Onix", Marca.CHEVROLET, cor, 80000, Categoria.POPULAR);
    }
}
