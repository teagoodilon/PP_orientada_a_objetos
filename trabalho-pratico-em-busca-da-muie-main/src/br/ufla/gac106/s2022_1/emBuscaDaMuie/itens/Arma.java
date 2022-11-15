package br.ufla.gac106.s2022_1.emBuscaDaMuie.itens;
import br.ufla.gac106.s2022_1.emBuscaDaMuie.Jogo;
import br.ufla.gac106.s2022_1.emBuscaDaMuie.personagens.Jogador;

public class Arma extends Item {
    private int poderDeAtaque;

    public Arma (String nome, String descricao, int poderDeAtaque, String caminho){
        super (nome, 6, descricao, caminho);
        this.poderDeAtaque = poderDeAtaque;
    }

    public int getPoderDeAtaque(){
        return poderDeAtaque;
    }

    @Override
    public String ataque(Jogador jogador, Jogo jogo){
        String texto = "";
        if(poderDeAtaque>=10 && jogador.estaAlimentado()){
            texto+= "Você liga o aspirador wap que o tata emprestou e aspira a muié para as profundezas da poeira contida na arma";
            texto+= "\nmuié fala: o patinete vai sentir minha faltaaaaa";
            jogo.setAcabou();
            jogo.setGanhou();
        }else if(poderDeAtaque<10 && jogador.getDesvia()){
            texto += "Você desviou do ataque da MUIÉ, não tente novamente com essa arma";
            jogador.setDesvia();
        }else if(poderDeAtaque<10){
            texto+= "A faca passa pelo corpo assombrado da muié e ela te arranha até a morte com suas unhas brancas.\n";
            jogo.setAcabou();
        }else{
            texto+= "Você estava com a arma certa, mas não estava com força para atacar,\na muié te arranha até a morte com suas unhas brancas.";
            jogo.setAcabou();
        }
        return texto;
    }
}
