package main;

import classe.Joueur;
import classe.PlateauIA;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//cette classe permet de run le programme et il suffit de changer les appels de fonctions pour changer les tests que l'on fait
public class TestPlateau {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//On initialise ici notre plateau de jeu
		Joueur ia = new Joueur(1);
		PlateauIA othello = new PlateauIA(ia.getCouleur());
		othello.affichTactiques();
		//On commence la partie
		int a = 1 ;
		int b = 1 ;
		int nbiteration = 6;
		int couleur;
		double start;
		double end;
		double dureeBlanc=0;
		double dureeNoir=0;
		int compteBlanc = 0;
		int compteNoir = 0;
		Scanner scx = new Scanner(System.in);
		Scanner scy = new Scanner(System.in);
		othello.majListesCoupsPossibles();
		while(((othello.getListeBlanc().isEmpty() != true) || (othello.getListeNoir().isEmpty() != true)) && othello.getNbrVide() != 0) {
			othello.AfficherPlateau();

			if(othello.getListeBlanc().isEmpty() != true) {
				compteBlanc++;
				couleur = 1;
				System.out.println("Voici le nombre de cases vide : "+ othello.getNbrVide());
				System.out.println("Voici le nombre de cases Blanche : "+ othello.getNbrBlanc());
				System.out.println("Voici le nombre de cases Noires : "+ othello.getNbrNoir());
				//au joueur 1 de joueur
				//othello.joueur1Joue();
				start = System.nanoTime();
				//ici on appelle la première fonction à tester
				othello.iaPositionnel(couleur,nbiteration);
				end = System.nanoTime();
				dureeBlanc += (end-start);
			}
			//on affiche
			othello.AfficherPlateau();
			if(othello.getListeNoir().isEmpty() != true) {
				compteNoir++;
				couleur = 2;
				System.out.println("Voici le nombre de cases vide : "+ othello.getNbrVide());
				System.out.println("Voici le nombre de cases Blanche : "+ othello.getNbrBlanc());
				System.out.println("Voici le nombre de cases Noires : "+ othello.getNbrNoir());
				//Au joueur 2 de jouer
				//Ici le coup est joué.
				//othello.joueur2Joue();
				//othello.iaJoue(ia.meilleurCoup(othello, ia.getCouleur(), 3),ia.getCouleur() );
				start = System.nanoTime();
				//ici on appelle la première fonction à tester
				othello.iaPositionnel(couleur,nbiteration);
				end = System.nanoTime();
				dureeNoir += (end -start);
				}
			othello.majListesCoupsPossibles();
			}
		othello.AfficherPlateau();
		if (othello.getNbrNoir() > othello.getNbrBlanc()){
			System.out.println("Couleur noir gagne");
		}else if(othello.getNbrNoir() < othello.getNbrBlanc())
		{
			System.out.println("Couleur blanc gagne");
		} else System.out.println("égalité");

		dureeBlanc = dureeBlanc/compteBlanc;
		dureeNoir = dureeNoir/compteNoir;
		System.out.println("pion noir = " + othello.getNbrNoir() + " pion blanc = " + othello.getNbrBlanc());
		System.out.println("en millisecondes: duree noir = " + dureeNoir/1000000 + " duree blanc = " + dureeBlanc/1000000);
	 }
		
	}


