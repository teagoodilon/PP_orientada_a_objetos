package carros;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;

public class S10 extends Carro {

    public S10(String cor) {
        super("S10", Marca.CHEVROLET, cor, 120000, Categoria.PICKUP);
    }
}
