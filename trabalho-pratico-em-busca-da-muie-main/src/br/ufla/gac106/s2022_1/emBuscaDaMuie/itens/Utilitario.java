package br.ufla.gac106.s2022_1.emBuscaDaMuie.itens;

import br.ufla.gac106.s2022_1.emBuscaDaMuie.Jogo;
import br.ufla.gac106.s2022_1.emBuscaDaMuie.personagens.Jogador;

public class Utilitario extends Item {
    private boolean abrePorta;
    
    public Utilitario(String nome, int peso, String descricao, boolean abrePorta, String caminho){
        super(nome, peso, descricao, caminho);
        this.abrePorta = abrePorta;
    }
    
    public boolean getAbrePorta(){
        return abrePorta;
    }
    
    @Override
    public  String ataque(Jogador jogador, Jogo jogo){
        String texto = "Esse item não teve efeito algum... A muié te arranha até a morte\n";
        jogo.setAcabou();
        return texto;
    }
}
