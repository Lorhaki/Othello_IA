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
		othello.majListesCoupsPossibles();
		while((othello.getListeBlanc().isEmpty() != true) && (othello.getListeNoir().isEmpty() != true) || othello.getNbrVide() == 0) {
			othello.AfficherPlateau();

			if(othello.getListeBlanc().isEmpty() != true) {
				System.out.println("Voici le nombre de cases vide : "+ othello.getNbrVide());
				System.out.println("Voici le nombre de cases Blanche : "+ othello.getNbrBlanc());
				System.out.println("Voici le nombre de cases Noires : "+ othello.getNbrNoir());
				//au joueur 1 de joueur
				othello.joueur1Joue();
			}
			//on affiche
			othello.AfficherPlateau();
			if(othello.getListeNoir().isEmpty() != true) {
				System.out.println("Voici le nombre de cases vide : "+ othello.getNbrVide());
				System.out.println("Voici le nombre de cases Blanche : "+ othello.getNbrBlanc());
				System.out.println("Voici le nombre de cases Noires : "+ othello.getNbrNoir());
				//Au joueur 2 de jouer
				//Ici le coup est joué.
				othello.joueur2Joue();
				}
			othello.majListesCoupsPossibles();
			}

		if (othello.getNbrNoir() > othello.getNbrBlanc()){
			System.out.println("Couleur noir gagne");
		}else System.out.println("Couleur blanc gagne");
	 }
	
		
		
	}


