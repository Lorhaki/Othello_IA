package classe;

import java.util.ArrayList;

public class Plateau {
	//Tableau d'entier pour représenter les cases d'un tableau
	private int [][] cases;
	//i et j pour coordonnées d'une case
	private int i , j ;
	private int nbrBlanc , nbrNoir , nbrVide ;
	//Liste des coups possibles pour les pions noir et blanc
	private ArrayList<CoupPossible> ListeBlanc;
	private ArrayList<CoupPossible> ListeNoir;
	//cases 1 pour blanc et 2 pour noir

	//Constructeur pour initailaiser un plateau classique d'Othello
	//On considére que le 1 c'est pour les blancs et 2 pour les noirs
	public Plateau(){
		this.i = 8;
		this.j = 8;
		this.cases = new int [8][8];
		for(int i = 0 ; i < this.i; i++) {
			for(int j = 0 ; j< this.j ; j++) {
				this.cases[i][j] = 0 ;
			}
		}
	//pour mettre les pions qui sont posés de base sur le palteau.
	cases[3][3] = 1 ; 
	cases[4][4] = 1 ; 
	cases[4][3] = 2 ; 
	cases[3][4] = 2 ; 
	this.NbrBlanc();
	this.NbrNoir();
	this.NbrVide();
	this.ListeBlanc = new ArrayList<>();
	this.ListeNoir = new ArrayList<>();
	
	}
	

	//méthode pour afficher le plateau avec les coordonnées des cases sur les cotés de celui-ci
	public void AfficherPlateau() {
		System.out.print(" ");
		for(int A = 1 ; A < 9 ; A++) {
			System.out.print(" ");
			System.out.print(A);
			}
		System.out.println();
		for(int i = 0 ; i < this.i; i++) {
			System.out.print(i+1);
			for(int j = 0 ; j< this.j ; j++) {
				System.out.print(" ");
				System.out.print(cases[i][j]);
			}
			System.out.println();
		}
	}
	
	//Permet de calculer le nombre de pion blanc sur le plateau
	public void NbrBlanc(){
		int nbrBlanc = 0 ;
		for(int i = 0 ; i < this.i; i++) {
			for(int j = 0 ; j< this.j ; j++) {
				if(this.cases[i][j] == 1)
					nbrBlanc++;
			}		
		}
		this.nbrBlanc = nbrBlanc ; 
	}
	
	//Permet de calculer le nombre de pion noir sur le plateau
	public void NbrNoir(){
		int nbrNoir = 0 ;
		for(int i = 0 ; i < this.i; i++) {
			for(int j = 0 ; j< this.j ; j++) {
				if(this.cases[i][j] == 2)
					nbrNoir++;
			}		
		}
		this.nbrNoir=nbrNoir; 
	}
	
	//Permet de calculer le nombre de cases vides du plateau
	public void NbrVide(){
		int nbrVide = 0 ;
		for(int i = 0 ; i < this.i; i++) {
			for(int j = 0 ; j< this.j ; j++) {
				if(this.cases[i][j] == 0)
					nbrVide++;
			}		
		}
		this.nbrVide = nbrVide ;
	}
	
	//Permet de calculer le nombre de coup possible pour les pions noir
	public int nbrCoupPossibleNoir() {
		int NbrPossible = 0;
		return NbrPossible;
	}
	
	//Permet de calculer le nombre de coup possible pour le joueur noir
	public int nbrCoupPossibleBlanc() {
		int NbrPossible = 0;
		return NbrPossible;
	}
	
	public boolean coupPossibleNoir(int i , int j){
		boolean a= false;
		return a ; 
	}
	public boolean coupPossibleBlanc(int i , int j){
		boolean a = false;
		
		return a ; 
	}

	public boolean coupEstPossible(int x, int y, int couleur, int dirx, int diry){
		if((x + dirx < 0) && (x+dirx>=i) && (y + diry < 0) && (y+diry>=j)){
			return false;
		}
		if(cases[x + dirx][y + diry] == 0){
			return false;
		}
		if(cases[x + dirx][y + diry] == couleur){
			return coupEstPossible(x + dirx,y+diry,couleur, dirx, diry);
		}
		return true;
	}

	public void mettreAjourLePlateau() {
		
	}
	public void JouerUnCoup(int i , int j) {
		
	}
	
	
	public boolean regardeAutourNoir(int i , int j) {
		if(this.cases [i+1][j+1] == 1) {
			if(this.coupEstPossible(i+1,j+1,1,1,1)){
				return true;
			}
		}
		if(this.cases [i+1][j] == 1) {
			if(this.coupEstPossible(i+1,j,1,1,0)){
				return true;
			}
		}
		if(this.cases [i][j+1] == 1) {
			if(this.coupEstPossible(i,j+1,1,0,1)){
				return true;
			}
		}
		if(this.cases [i-1][j-1] == 1) {
			if(this.coupEstPossible(i-1,j-1,1,-1,-1)){
				return true;
			}
		}
		if(this.cases [i-1][j] == 1) {
			if(this.coupEstPossible(i-1,j,1,-1,0)){
				return true;
			}
		}
		if(this.cases [i][j-1] == 1) {
			if(this.coupEstPossible(i,j-1,1,0,-1)){
				return true;
			}
		}
		if(this.cases [i+1][j-1] == 1) {
			if(this.coupEstPossible(i+1,j-1,1,1,-1)){
				return true;
			}
		}
		if(this.cases [i-1][j+1] == 1) {
			if(this.coupEstPossible(i-1,j+1,1,-1,+1)){
				return true;
			}
		}
		return false;
	}
	
public boolean regardeAutourBlanc(int i , int j) {

	if(this.cases [i+1][j+1] == 2) {
		if(this.coupEstPossible(i+1,j+1,2,1,1)){
			return true;
		}
	}
	if(this.cases [i+1][j] == 2) {
		if(this.coupEstPossible(i+1,j,1,2,0)){
			return true;
		}
	}
	if(this.cases [i][j+1] == 2) {
		if(this.coupEstPossible(i,j+1,2,1,1)){
			return true;
		}
	}
	if(this.cases [i-1][j-1] == 2) {
		if(this.coupEstPossible(i-1,j-1,2,-1,-1)){
			return true;
		}
	}
	if(this.cases [i-1][j] == 2) {
		if(this.coupEstPossible(i-1,j,2,-1,0)){
			return true;
		}
	}
	if(this.cases [i][j-1] == 2) {
		if(this.coupEstPossible(i,j-1,2,0,-1)){
			return true;
		}
	}
	if(this.cases [i+1][j-1] == 2) {
		if(this.coupEstPossible(i+1,j-1,2,1,-1)){
			return true;
		}
	}
	if(this.cases [i-1][j+1] == 2) {
		if(this.coupEstPossible(i-1,j+1,2,-1,+1)){
			return true;
		}
	}
	return false;
}
	//GET ET SET
	
	
	public int[][] getCases() {
		return cases;
	}

	public void setCases(int[][] cases) {
		this.cases = cases;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getNbrBlanc() {
		return nbrBlanc;
	}

	public void setNbrBlanc(int nbrBlanc) {
		this.nbrBlanc = nbrBlanc;
	}

	public int getNbrNoir() {
		return nbrNoir;
	}

	public void setNbrNoir(int nbrNoir) {
		this.nbrNoir = nbrNoir;
	}

	public int getNbrVide() {
		return nbrVide;
	}

	public void setNbrVide(int nbrVide) {
		this.nbrVide = nbrVide;
	}
	public ArrayList<CoupPossible> getListeBlanc() {
		return ListeBlanc;
	}


	public void setListeBlanc(ArrayList<CoupPossible> listeBlanc) {
		ListeBlanc = listeBlanc;
	}


	public ArrayList<CoupPossible> getListeNoir() {
		return ListeNoir;
	}


	public void setListeNoir(ArrayList<CoupPossible> listeNoir) {
		ListeNoir = listeNoir;
	}
}
