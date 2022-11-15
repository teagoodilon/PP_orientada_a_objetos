package fabricaautomoveis.carros;

import carros.Onix;
import carros.S10;
import carros.Camaro;

public class ChevroletFactory extends CarroFactory {
    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro;
        if (categoria == Categoria.POPULAR) {
            carro = new Onix(cor);
        } else if (categoria == Categoria.PICKUP) {
            carro = new S10(cor);
        } else {
            carro = new Camaro(cor);
        }
        return carro;
    }
}
