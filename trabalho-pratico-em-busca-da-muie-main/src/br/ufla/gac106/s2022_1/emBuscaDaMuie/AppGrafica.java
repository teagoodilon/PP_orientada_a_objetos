package br.ufla.gac106.s2022_1.emBuscaDaMuie;

import br.ufla.gac106.s2022_1.baseJogo.Tela;

public class AppGrafica {
    public static void main(String[] args) throws Exception {
        Jogo jogo = new Jogo(new Tela("Em busca da MUIE"));		
		jogo.jogar();
    }
}
