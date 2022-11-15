/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concessionaria;

import fabricaautomoveis.carros.CarroFactory;
import fabricaautomoveis.carros.Categoria;
import fabricaautomoveis.carros.ChevroletFactory;
import fabricaautomoveis.carros.FiatFactory;
import fabricaautomoveis.carros.VwFactory;

import java.util.Scanner;
import carros.Marca;

/**
 *
 * @author julio
 */
public class InterfaceUsuario {

    private Concessionaria ppooVeiculos;
    private Scanner entrada;

    public void exibir() {
        ppooVeiculos = new Concessionaria("PPOO Veículos");
        entrada = new Scanner(System.in);
        escolherFranquia();
        int opcao;
        do {
            opcao = menu();

            switch (opcao) {
                case 1:
                    comprarCarro();
                    break;
                case 2:
                    escolherFranquia();
                    break;
                case 3:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 3);
    }

    private int menu() {
        System.out.println("1 - Comprar Carro");
        System.out.println("2 - Mudar Franquia");
        System.out.println("3 - Sair");
        return Integer.parseInt(entrada.nextLine());
    }

    private void comprarCarro() {
        System.out.println("Concessionaria vende carros da: " + ppooVeiculos.getMarcaFranquia());

        System.out.print("Escolha a categoria (1: Popular, 2: Pickup ou 3: Luxo): ");
        Categoria categoria = Categoria.peloID(Integer.parseInt(entrada.nextLine()));

        System.out.print("Escolha a cor: ");
        String cor = entrada.nextLine();

        if (ppooVeiculos.comprarCarro(categoria, cor)) {
            System.out.println("Parabéns!!! O carro é seu!!!");
        } else {
            System.out.println("Sinto muito, não quer escolher outro?");
        }

        esperarTecla();
    }

    private void esperarTecla() {
        entrada.nextLine();
    }

    private void escolherFranquia(){
        System.out.println("Você deseja qual franquia de carros?\n");
        System.out.println("(1) - VW");
        System.out.println("(2) - FIAT");
        System.out.println("(3) - CHEVROLET");
        CarroFactory factory = new VwFactory();
        int escolha = Integer.parseInt(entrada.nextLine());
        switch(escolha){
            case 1:
                ppooVeiculos.mudarFranquia(Marca.VW, factory);
                break;
            case 2:
                ppooVeiculos.mudarFranquia(Marca.FIAT, factory = new FiatFactory());
                break;
            case 3:
                ppooVeiculos.mudarFranquia(Marca.CHEVROLET, factory = new ChevroletFactory());
                break;
        }
    }
}
