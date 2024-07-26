package model.jogadores;

import java.util.Scanner;

import model.tabuleiro.Tabuleiro;

public class Humano extends Jogador {
    public Scanner sc = new Scanner(System.in);

    public Humano(int jogador){
        super(jogador);
        this.jogador = jogador;
        System.out.println("Jogador criado!");
    }

    @Override
    public void jogar(Tabuleiro tabuleiro){
        tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }

    @Override
    public void tentativa(Tabuleiro tabuleiro){
        do{
            do{
                System.out.print("Linha: ");
                tentativa[0] = sc.nextInt();

                if (tentativa[0] > 3 || tentativa[0] < 1) {
                    System.out.println("Linha incorreta! As linhas são 1, 2 ou 3");
                }
            }while(tentativa[0] > 3 || tentativa[0] < 1);

            do{
                System.out.print("Coluna: ");
                tentativa[1] = sc.nextInt();

                if (tentativa[1] > 3|| tentativa[1] < 1) {
                    System.out.println("Coluna incorreta! As colunas são 1, 2 ou 3");
                }
            }while(tentativa[1] > 3|| tentativa[1] < 1);

            tentativa[0]--;
            tentativa[1]--;

            if (checaTentativa(tentativa, tabuleiro)) {
                System.out.println("Esse local já está preenchido! Jogue novamente.");
            }
        }while(!checaTentativa(tentativa, tabuleiro));

    }
}
