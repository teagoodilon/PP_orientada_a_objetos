package fabricaautomoveis.carros;

import carros.Gol;
import carros.Saveiro;

public class VwFactory extends CarroFactory {
    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro;
        if (categoria == Categoria.POPULAR) {
            carro = new Gol(cor);
        } else {
            carro = new Saveiro(cor);
        }
        return carro;
    }
}
