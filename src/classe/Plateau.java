package classe;

import java.util.ArrayList;

public class Plateau {
	//Tableau d'entier pour représenter les cases d'un tableau
	private int [][] tab;
	//i et j pour coordonnées d'une case
	private int i , j ;
	private int nbrBlanc , nbrNoir , nbrVide ;
	//Liste des coups possibles pour les pions noir et blanc
	private ArrayList<Case> listeBlanc;
	private ArrayList<Case> listeNoir;
	//cases 1 pour blanc et 2 pour noir
	Joueur joueur1, joueur2;


	//Constructeur pour initailaiser un plateau classique d'Othello
	//On considére que le 1 c'est pour les blancs et 2 pour les noirs
	public Plateau(){
		this.i = 8;
		this.j = 8;
		this.tab = new int [8][8];
		for(int i = 0 ; i < this.i; i++) {
			for(int j = 0 ; j< this.j ; j++) {
				this.tab[i][j] = 0 ;
			}
		}
	//pour mettre les pions qui sont posés de base sur le palteau.
	tab[3][3] = 1 ;
	tab[4][4] = 1 ;
	tab[4][3] = 2 ;
	tab[3][4] = 2 ;
	this.NbrBlanc();
	this.NbrNoir();
	this.NbrVide();
	this.listeBlanc = new ArrayList<>();
	this.listeNoir = new ArrayList<>();
	joueur1 = new Joueur(1);
	joueur2 = new Joueur(2);
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
				System.out.print(tab[i][j]);
			}
			System.out.println();
		}
	}
	
	//Permet de calculer le nombre de pion blanc sur le plateau
	public void NbrBlanc(){
		int nbrBlanc = 0 ;
		for(int i = 0 ; i < this.i; i++) {
			for(int j = 0 ; j< this.j ; j++) {
				if(this.tab[i][j] == 1)
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
				if(this.tab[i][j] == 2)
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
				if(this.tab[i][j] == 0)
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
		return regardeAutourNoir(i,j);
	}
	public boolean coupPossibleBlanc(int i , int j){
		return regardeAutourBlanc(i,j);
	}

	public boolean coupEstPossible(int x, int y, int couleur, int dirx, int diry){
		if((x + dirx < 0) && (x+dirx>=i) && (y + diry < 0) && (y+diry>=j)){
			return false;
		}
		if(tab[x + dirx][y + diry] == 0){
			return false;
		}
		if(tab[x + dirx][y + diry] == couleur){
			return coupEstPossible(x + dirx,y+diry,couleur, dirx, diry);
		}
		return true;
	}

	public void mettreAjourLePlateau(int x, int y, int couleur) {
		tab[x][y]=couleur;
	}
	
	
	public boolean regardeAutourNoir(int i , int j) {
		if(this.tab [i+1][j+1] == 1) {
			if(this.coupEstPossible(i+1,j+1,1,1,1)){
				return true;
			}
		}
		if(this.tab [i+1][j] == 1) {
			if(this.coupEstPossible(i+1,j,1,1,0)){
				return true;
			}
		}
		if(this.tab [i][j+1] == 1) {
			if(this.coupEstPossible(i,j+1,1,0,1)){
				return true;
			}
		}
		if(this.tab [i-1][j-1] == 1) {
			if(this.coupEstPossible(i-1,j-1,1,-1,-1)){
				return true;
			}
		}
		if(this.tab [i-1][j] == 1) {
			if(this.coupEstPossible(i-1,j,1,-1,0)){
				return true;
			}
		}
		if(this.tab [i][j-1] == 1) {
			if(this.coupEstPossible(i,j-1,1,0,-1)){
				return true;
			}
		}
		if(this.tab [i+1][j-1] == 1) {
			if(this.coupEstPossible(i+1,j-1,1,1,-1)){
				return true;
			}
		}
		if(this.tab [i-1][j+1] == 1) {
			if(this.coupEstPossible(i-1,j+1,1,-1,+1)){
				return true;
			}
		}
		return false;
	}
	
	public boolean regardeAutourBlanc(int i , int j) {
			if(this.tab [i+1][j+1] == 2) {
				if(this.coupEstPossible(i+1,j+1,2,1,1)){
					return true;
				}
			}
			if(this.tab [i+1][j] == 2) {
				if(this.coupEstPossible(i+1,j,1,2,0)){
					return true;
				}
			}
			if(this.tab [i][j+1] == 2) {
				if(this.coupEstPossible(i,j+1,2,1,1)){
					return true;
				}
			}
			if(this.tab [i-1][j-1] == 2) {
				if(this.coupEstPossible(i-1,j-1,2,-1,-1)){
					return true;
				}
			}
			if(this.tab [i-1][j] == 2) {
				if(this.coupEstPossible(i-1,j,2,-1,0)){
					return true;
				}
			}
			if(this.tab [i][j-1] == 2) {
				if(this.coupEstPossible(i,j-1,2,0,-1)){
					return true;
				}
			}
			if(this.tab [i+1][j-1] == 2) {
				if(this.coupEstPossible(i+1,j-1,2,1,-1)){
					return true;
				}
			}
			if(this.tab [i-1][j+1] == 2) {
				if(this.coupEstPossible(i-1,j+1,2,-1,+1)){
					return true;
				}
			}
			return false;
}
	//GET ET SET
	
	
	public int[][] getCases() {
		return tab;
	}

	public void setCases(int[][] cases) {
		this.tab = cases;
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
	public ArrayList<Case> getListeBlanc() {
		return listeBlanc;
	}



	public void setListeBlanc(ArrayList<Case> listeBlanc) {
		this.listeBlanc = listeBlanc;
	}


	public ArrayList<Case> getListeNoir() {

		return listeNoir;
	}


	public void setListeNoir(ArrayList<Case> listeNoir) {
		this.listeNoir = listeNoir;
	}

	//permet de rechercher à chaque tour les coups possibles pour les pions noirs et les pions noirs
	public void majListesCoupsPossibles(){
		listeBlanc.clear();
		listeNoir.clear();
		for (int a=0;a<i;a++){
			for(int b=0;b<j;b++){
				if(tab[a][b]==0){
					if(this.coupPossibleNoir(a,b)){
						listeNoir.add(new Case(a,b));
					}
					if(this.coupPossibleBlanc(a,b)){
						listeBlanc.add(new Case(a,b));
					}
				}
			}
		}
	}

	//une fois qu'on sait qu'un coup doit changer des cases, on regarde jusqu'ou les cases vont changer
	public Case limite(int x, int y, int a , int b, int couleur)
	{
		int tempx=x,tempy=y;
		Case temp = new Case();
		while(tab[tempx+a][tempy+b] == couleur)
		{
			tempx=tempx+a;
			tempy=tempy+b;
		}
		temp.setX(tempx);
		temp.setY(tempy);
		return temp;
	}

	//permet de changer la couleur d'une ligne entre deux cases (a et b sont les directions)
	public void changerCouleurLigne(int x, int y, int couleur, int a, int b)
	{
		int c;
		Case lim=limite(x, y, a, b, couleur);
		if(couleur == 1){
			c=2;
		} else c = 1;
		if(x >= lim.getX()){
			if( y >= lim.getY()){
				for(int i= lim.getX();i<x;i++){
					for(int j= lim.getY();j<y;j++){
						tab[i][j]=c;
					}
				}
			}
			else{
				for(int i= lim.getX();i<x;i++){
					for(int j= lim.getY();j<y;j--){
						tab[i][j]=c;
					}
				}
			}
		}
		else{
			if( y >= lim.getY()){
				for(int i= lim.getX();i<x;i--){
					for(int j= lim.getY();j<y;j++){
						tab[i][j]=c;
					}
				}
			}
			else{
				for(int i= lim.getX();i<x;i--){
					for(int j= lim.getY();j<y;j--){
						tab[i][j]=c;
					}
				}
			}
		}
	}

	//permet de changer les couleurs après qu'on joue en x, y
	public void majPlateau(int x, int y)
	{
		int couleur;
		if(tab[x][y]==1){
			couleur = 2;
		}
		else couleur = 1;
		if(this.tab [x+1][y+1] == couleur) {
			if(this.coupEstPossible(x+1,j+1,couleur,1,1)){
				changerCouleurLigne(x+1,j+1,couleur,1,1);
			}
		}
		if(this.tab [x+1][y] == couleur) {
			if(this.coupEstPossible(x+1,y,couleur,2,0)){
				changerCouleurLigne(x+1,y,couleur,2,0);
			}
		}
		if(this.tab [x][y+1] == couleur) {
			if(this.coupEstPossible(x,y+1,couleur,1,1)){
				changerCouleurLigne(x,y+1,couleur,1,1);
			}
		}
		if(this.tab [x-1][y-1] == couleur) {
			if(this.coupEstPossible(x-1,y-1,couleur,-1,-1)){
				changerCouleurLigne(x-1,y-1,couleur,-1,-1);
			}
		}
		if(this.tab [x-1][y] == couleur) {
			if(this.coupEstPossible(x-1,y,couleur,-1,0)){
				changerCouleurLigne(x-1,y,couleur,-1,0);
			}
		}
		if(this.tab [x][y-1] == couleur) {
			if(this.coupEstPossible(x,y-1,couleur,0,-1)){
				changerCouleurLigne(x,y-1,couleur,0,-1);
			}
		}
		if(this.tab [x+1][y-1] == couleur) {
			if(this.coupEstPossible(x+1,y-1,couleur,1,-1)){
				changerCouleurLigne(x+1,y-1,couleur,1,-1);
			}
		}
		if(this.tab [x-1][y+1] == couleur) {
			if(this.coupEstPossible(x-1,y+1,couleur,-1,+1)){
				changerCouleurLigne(x-1,y+1,couleur,-1,+1);
			}
		}
	}

	//Pour faire un tour
	public void joueur1Joue(int x, int y)
	{
		tab[x][y]=joueur1.getCouleur();
		this.majPlateau(x, y);
		this.majListesCoupsPossibles();
	}

	public void joueur2Joue(int x, int y)
	{
		tab[x][y]=joueur2.getCouleur();
		this.majPlateau(x, y);
		this.majListesCoupsPossibles();
	}
}
