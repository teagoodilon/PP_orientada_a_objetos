package fabricaautomoveis.carros;

import carros.Argo;
import carros.Strada;
import carros.Toro;

public class FiatFactory extends CarroFactory {
    @Override
    public Carro criarCarro(Categoria categoria, String cor) {
        Carro carro;
        if (categoria == Categoria.POPULAR) {
            carro = new Argo(cor);
        } else if (categoria == Categoria.PICKUP) {
            carro = new Strada(cor);
        } else {
            carro = new Toro(cor);
        }
        return carro;
    }
}
