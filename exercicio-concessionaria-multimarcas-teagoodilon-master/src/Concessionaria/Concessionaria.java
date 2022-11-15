package Concessionaria;

import fabricaautomoveis.carros.Carro;
import fabricaautomoveis.carros.CarroFactory;
import fabricaautomoveis.carros.Categoria;

import java.util.ArrayList;
import java.util.List;

import carros.Marca;

/**
 * Representa uma concessionária que vende carros de uma determinada Marca.
 */
public class Concessionaria {
    // Nome da concessionária
    private String nome;
    // Carros da concessionária
    private List<Carro> carros;
    // Marca da qual a concessionária vende os carros
    private Marca marcaFranquia;
    private CarroFactory factory;

    /**
     * Uma concessionária é construída com um nome e uma Marca da qual vende carros
     * 
     * @param nome  O nome da concessionária.
     * @param marca A marca da qual a concessionária vende os carros
     */
    public Concessionaria(String nome) {
        this.nome = nome;
        carros = new ArrayList<>();
    }   

    public void mudarFranquia(Marca marca, CarroFactory factory){
        this.marcaFranquia = marca;
        this.factory = factory;
    }


    /**
     * Retorna o nome da concessionária
     * 
     * @return O nome da concessionária
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a Marca da qual a concessionária vende os carros.
     * 
     * @return A marca dos carros
     */
    public Marca getMarcaFranquia() {
        return marcaFranquia;
    }

    /**
     * Realiza a compra de um carro de uma determinada categoria e com uma cor
     * 
     * @param categoria Categoria do carro a ser comprado.
     * @param cor       Cor do carro a ser comprado
     * 
     * @return Verdadeiro se o carro pode ser comprado (modelo disponível)
     */
    public boolean comprarCarro(Categoria categoria, String cor) {
        Carro carro;
        carro = factory.criarCarro(categoria, cor);
        if (carro != null) {
            carro.produzir();
            carro.pintar();
            carro.liberarDocumentacao();
            carros.add(carro);
            return true;
        } else {
            System.out.println("Não há modelos disponíveis para essa categoria");
            return false;
        }
    }
}
