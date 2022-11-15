package carros;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;

public class Camaro extends Carro {

    public Camaro(String cor) {
        super("Camaro", Marca.CHEVROLET, cor, 150000, Categoria.LUXO);
    }
}
