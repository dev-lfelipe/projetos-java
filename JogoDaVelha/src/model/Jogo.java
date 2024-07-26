package model;

import java.util.Scanner;

import model.jogadores.Computador;
import model.jogadores.Humano;
import model.jogadores.Jogador;
import model.tabuleiro.Tabuleiro;

public class Jogo {
    private Tabuleiro tabuleiro;
    private int rodada = 1, vez = 1;
    private Jogador jogador1, jogador2;
    public Scanner jogada = new Scanner(System.in);

    public Jogo(){
        tabuleiro = new Tabuleiro();
        iniciarJogadores();

        while (jogar());
    }

    public void iniciarJogadores(){
        System.out.println("Quem será o Jogador 1? ");
        //jogador1 = jogada.nextLine();
        if(escolherJogador() == 1){
            this.jogador1 = new Humano(1);
        }else{
            this.jogador1 = new Computador(1);
        }

        System.out.println("=======================");
        System.out.println("Quem será o Jogador 2? ");
        //jogador2 = jogada.nextLine()
        if(escolherJogador() == 1){
            this.jogador2 = new Humano(2);
        }else{
            this.jogador2 = new Computador(2);
        }
    }

    public int escolherJogador(){
        int opcao = 0;
        do{
            System.out.println("De que tipo será o jogo?\n");
            System.out.println("1 - Humano x Humano");
            System.out.println("2 - Humano x Computador\n");
            System.out.println("Escolha: ");
            opcao = jogada.nextInt(); 
            if (opcao != 1 && opcao != 2) {
                System.out.println("Essa opção não existe! Escolha novamente");
            }
        }while(opcao != 1 && opcao != 2);

        return opcao;
    }

    public boolean jogar(){
        if(ganhou() == 0){
            System.out.println("=======================");
            System.out.println("\nRodada: " + rodada);
            System.out.println("É a vez do jogador: " + vez());

            if(vez() == 1){
                jogador1.jogar(tabuleiro);
            }else{
                jogador2.jogar(tabuleiro);
            }

            if (tabuleiro.tabuleiroCompleto()) {
                System.out.println("\nO jogo deu velha!");
                return false;
            }

            vez++;
            rodada++;

            return true;
        }else{
            if (ganhou() == -1) {
                System.out.println("O Jogador 1 ganhou!");
            }else{
                System.out.println("O Jogador 2 ganhou!");
            }

            return false;
        }
    } 

    public int vez(){
        if(vez % 2 == 1)
            return 1;
        else
            return 2;
    }
    
    public int ganhou(){
        if(tabuleiro.checaLinhas() == 1){
            return 1;
        }
        if(tabuleiro.checaColunas() == 1){
            return 1;
        }
        if(tabuleiro.checaDiagonais() == 1){
            return 1;
        }
        if(tabuleiro.checaLinhas() == -1){
            return -1;
        }
        if(tabuleiro.checaColunas() == -1){
            return -1;
        }
        if(tabuleiro.checaDiagonais() == -1){
            return -1;
        }
        
        return 0;
    }

}
