package br.ufla.gac106.s2022_1.emBuscaDaMuie;


public class App {
    public static void main(String[] args) throws Exception {
        Jogo jogo = new Jogo(new Terminal());
		jogo.jogar();
    }
}
