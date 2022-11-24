package main;

import classe.Plateau;

import java.util.Scanner;

public class TestPlateau {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//On initialise ici notre plateau de jeu 
		Plateau othello = new Plateau();
		//On affiche le plateau de jeu
		othello.AfficherPlateau();
		System.out.println("Voici le nombre de cases vide : "+ othello.getNbrVide());
		System.out.println("Voici le nombre de cases Blanche : "+ othello.getNbrBlanc());
		System.out.println("Voici le nombre de cases Noires : "+ othello.getNbrNoir());
		
		//On commence la partie
		int a = 1 ;
		int b = 1 ;
		Scanner scx = new Scanner(System.in);
		Scanner scy = new Scanner(System.in);
		while(othello.getNbrBlanc() != 0 || othello.getNbrNoir() != 0 ||othello.getNbrVide() != 0 || (a != 0 && b!=0)) {
			//au joueur 1 de joueur
			//au depart on demande la saisie de la colonne et la ligne.
				System.out.println("c'est au joueur 1 de jouer");
				System.out.println("Veuillez saisir un chiffre pour choisir la ligne");
				int x = scx.nextInt();

				System.out.println("Veuillez saisir un chiffre pour chosir la colonne");
				int y = scy.nextInt();
				//On afficche le plateau aprés le coup joué
				othello.AfficherPlateau();

				//Au joueur 2 de jouer
				System.out.println("c'est au joueur 2 de jouer");
				System.out.println("Veuillez saisir un chiffre pour choisir la ligne");
				int x2 = scx.nextInt();
				System.out.println("Veuillez saisir un chiffre pour chosir la colonne");
				int y2 = scy.nextInt();
				//On affiche le plateau apres le coup joué.
				othello.AfficherPlateau();
				
			}
		}
	
		
		
	}


