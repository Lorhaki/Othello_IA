package main;

import java.util.Scanner;

public class MenuJeu {
    public static void main(String[] args) {
        System.out.println("Bonjour veuillez selectionner votre choix");
        Scanner sc = new Scanner(System.in);
        System.out.println("1- Mode Joueur 1 contre joueur 2");
        System.out.println("1- Mode Joueur 1 contre IA 1");
        System.out.println("1- Mode Joueur 1 contre IA 2");

        int choix = sc.nextInt();

        if(choix == 1){
            TestPlateau t = new TestPlateau();
        }
        if(choix == 2){

        }
        if(choix == 3){

        }
    }
}
