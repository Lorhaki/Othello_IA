package main;

import classe.Plateau;

import java.util.Scanner;

public class TestPlateau {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//On initialise ici notre plateau de jeu 
		Plateau othello = new Plateau();
		//On commence la partie
		int a = 1 ;
		int b = 1 ;
		Scanner scx = new Scanner(System.in);
		Scanner scy = new Scanner(System.in);
		while(othello.getListeBlanc() != null || othello.getListeBlanc() != null) {
			othello.AfficherPlateau();
			if(othello.getListeBlanc() != null) {
				System.out.println("Voici le nombre de cases vide : "+ othello.getNbrVide());
				System.out.println("Voici le nombre de cases Blanche : "+ othello.getNbrBlanc());
				System.out.println("Voici le nombre de cases Noires : "+ othello.getNbrNoir());
				//au joueur 1 de joueur
				//au depart on demande la saisie de la colonne et la ligne.
				System.out.println("c'est au joueur 1 de jouer");
				System.out.println("Veuillez saisir un chiffre pour choisir la ligne");
				int x = scx.nextInt();

				System.out.println("Veuillez saisir un chiffre pour chosir la colonne");
				int y = scy.nextInt();
				//Ici le coup est joué.

			}
			//on affiche
			othello.AfficherPlateau();
			if(othello.getListeBlanc() != null) {
				System.out.println("Voici le nombre de cases vide : "+ othello.getNbrVide());
				System.out.println("Voici le nombre de cases Blanche : "+ othello.getNbrBlanc());
				System.out.println("Voici le nombre de cases Noires : "+ othello.getNbrNoir());
				//Au joueur 2 de jouer
				System.out.println("c'est au joueur 2 de jouer");
				System.out.println("Veuillez saisir un chiffre pour choisir la ligne");
				int x2 = scx.nextInt();
				System.out.println("Veuillez saisir un chiffre pour chosir la colonne");
				int y2 = scy.nextInt();
				//Ici le coup est joué.

				}
			}
		}
	
		
		
	}


