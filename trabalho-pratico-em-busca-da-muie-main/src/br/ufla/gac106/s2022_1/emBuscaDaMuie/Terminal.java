package br.ufla.gac106.s2022_1.emBuscaDaMuie;

import java.util.Scanner;

import br.ufla.gac106.s2022_1.baseJogo.EntidadeGrafica;
import br.ufla.gac106.s2022_1.baseJogo.InterfaceUsuario;

public class Terminal implements InterfaceUsuario{
    private Scanner entrada;

    public Terminal(){
        entrada = new Scanner(System.in);
    }
    
    @Override
    public void exibirMensagem(String mensagem) {
        System.out.print("\n" + mensagem);
    }

    @Override
    public void continuarMensagem(String mensagem) {
        System.out.println("\n" + mensagem);
    }

    @Override
    public String obterComando() {
        return entrada.nextLine();
    }

    @Override
    public String obterInformacao(String instrucao) {

        System.out.println(instrucao);

        return entrada.nextLine();
    }

    @Override
    public void ambienteAtualMudou(EntidadeGrafica ambiente) {
       
        
    }

    @Override
    public void jogadorPegouItem(EntidadeGrafica item) {
       
        
    }

    @Override
    public void jogadorDescartouItem(EntidadeGrafica item) {
       
        
    }
    
}
