package fabricaautomoveis.carros;

public abstract class CarroFactory {
    public abstract Carro criarCarro(Categoria categoria, String cor);
}
