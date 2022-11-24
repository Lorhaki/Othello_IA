package main;

import classe.Plateau;

public class TestPlateau {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//On initialise ici notre plateau de jeu 
		Plateau Othello = new Plateau();
		//On affiche le plateau de jeu
		Othello.AfficherPlateau();
		System.out.println("Voici le nombre de cases vide : "+ Othello.getNbrVide());
		System.out.println("Voici le nombre de cases Blanche : "+ Othello.getNbrBlanc());
		System.out.println("Voici le nombre de cases Noires : "+ Othello.getNbrNoir());
		
		//On commence la partie
		int a = 1 ;
		int b = 1 ;
		while(Othello.getNbrBlanc() != 0 || Othello.getNbrNoir() != 0 ||Othello.getNbrVide() != 0 || (a != 0 && b!=0)) {
			//au joueur 1 de joueur
				System.out.println("c'est au joueur 1 de jouer");
				
				System.out.println("c'est au joueur 2 de jouer");
				
			}
		}
	
		
		
	}


