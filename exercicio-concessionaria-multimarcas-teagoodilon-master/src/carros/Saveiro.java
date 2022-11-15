package carros;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.Categoria;

public class Saveiro extends Carro {

    public Saveiro(String cor) {
        super("Saveiro", Marca.VW, cor, 80000, Categoria.PICKUP);
    }

}
