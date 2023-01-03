package main;

import classe.Ordi;
import classe.PlateauIA;

import java.util.Scanner;

public class TestPlateau {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//On initialise ici notre plateau de jeu
		Ordi ia = new Ordi(1);
		PlateauIA othello = new PlateauIA(ia.getCouleur());
		othello.affichTactiques();
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
				//othello.joueur1Joue();
				othello.couleurJoue(othello.absolu(othello, ia.getCouleur(), 3),ia.getCouleur());
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
				//othello.iaJoue(ia.meilleurCoup(othello, ia.getCouleur(), 3),ia.getCouleur() );
				}
			othello.majListesCoupsPossibles();
			}

		if (othello.getNbrNoir() > othello.getNbrBlanc()){
			System.out.println("Couleur noir gagne");
		}else System.out.println("Couleur blanc gagne");
	 }
	
		
		
	}


