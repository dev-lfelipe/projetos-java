package model.jogadores;

import model.tabuleiro.Tabuleiro;

public class Computador extends Jogador{
     
    public Computador(int jogador){
        super(jogador);
        System.out.println("Jogador 'Computador' criado!");
    }
    
    @Override
    public void jogar(Tabuleiro tabuleiro){
        
    }
    
    @Override
    public void tentativa(Tabuleiro tabuleiro){
        
    }
}
