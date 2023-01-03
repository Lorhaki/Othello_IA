package classe;

import java.util.ArrayList;
import java.util.Scanner;

public class Plateau {
	//Tableau d'entier pour représenter les cases d'un tableau
	protected int [][] tab;
	//i et j pour coordonnées d'une case
	protected int i , j ;
	protected int nbrBlanc , nbrNoir , nbrVide ;
	//Liste des coups possibles pour les pions noir et blanc
	protected ArrayList<Case> listeBlanc;
	protected ArrayList<Case> listeNoir;
	//cases 1 pour blanc et 2 pour noir
	Joueur joueur1, joueur2;

	protected int [][] tactiques;
	protected int valBlanc;
	protected int valNoir;


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
	//this.instanciationCoups()
		creaTactiques();
	}

	public int getValBlanc() {
		return valBlanc;
	}

	public int getValNoir() {
		return valNoir;
	}

	//instanciation tableau des valeurs tactiques de l'othello
	public void creaTactiques()
	{
		tactiques = new int[8][8];
		tactiques[0][0] = 500;
		tactiques[0][7] = 500;
		tactiques[7][0] = 500;
		tactiques[7][7] = 500;

		tactiques[0][1] = -150;
		tactiques[0][6] = -150;
		tactiques[1][0] = -150;
		tactiques[1][7] = -150;
		tactiques[6][0] = -150;
		tactiques[6][7] = -150;
		tactiques[7][1] = -150;
		tactiques[7][6] = -150;

		tactiques[1][1] = -250;
		tactiques[1][6] = -250;
		tactiques[6][1] = -250;
		tactiques[6][6] = -250;

		tactiques[0][2] = 30;
		tactiques[0][5] = 30;
		tactiques[2][0] = 30;
		tactiques[2][7] = 30;
		tactiques[5][0] = 30;
		tactiques[5][7] = 30;
		tactiques[7][2] = 30;
		tactiques[7][5] = 30;

		tactiques[0][3] = 10;
		tactiques[0][4] = 10;
		tactiques[3][0] = 10;
		tactiques[4][0] = 10;
		tactiques[3][7] = 10;
		tactiques[4][7] = 10;
		tactiques[7][3] = 10;
		tactiques[7][4] = 10;

		tactiques[3][3] = 16;
		tactiques[4][3] = 16;
		tactiques[3][4] = 16;
		tactiques[4][4] = 16;

		tactiques[2][3] = 2;
		tactiques[2][4] = 2;
		tactiques[5][3] = 2;
		tactiques[5][4] = 2;
		tactiques[3][2] = 2;
		tactiques[4][2] = 2;
		tactiques[3][5] = 2;
		tactiques[4][5] = 2;

		tactiques[2][2] = 1;
		tactiques[2][5] = 1;
		tactiques[5][2] = 1;
		tactiques[5][5] = 1;

		for(int i=2; i<6; i++)
		{
			tactiques[1][i] = 0;
			tactiques[i][1] = 0;
			tactiques[6][i] = 0;
			tactiques[i][6] = 0;
		}
	}



	//permet de mettre a jour la valeur des points pour les blancs et les noirs avec les valeurs tactiques du tableau
	public void majValTactiques()
	{
		valBlanc = 0;
		valNoir = 0;
		for(int i = 0 ; i < this.i; i++) {
			for(int j = 0 ; j< this.j ; j++) {
				if(this.tab[i][j] == 1)
					valBlanc += tactiques[i][j];
				else if(tab[i][j] == 2)
					valNoir += tactiques[i][j];
			}
		}
	}

	private void instanciationCoups(){
		listeNoir.add(new Case(4,3));
		listeNoir.add(new Case(3,4));
		listeNoir.add(new Case(5,6));
		listeNoir.add(new Case(6,5));
		listeBlanc.add(new Case(4,6));
		listeBlanc.add(new Case(6,4));
		listeBlanc.add(new Case(3,5));
		listeBlanc.add(new Case(5,3));
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
		if((x + dirx < 0) || (x+dirx>=i) || (y + diry < 0) || (y+diry>=j)){
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
	
	
	public boolean regardeAutourNoir(int i , int j) {
		if(i != 0){
			if(j!=0){
				if(i!=0 && j!=0){
					if(this.tab [i-1][j-1] == 1) {
						if(this.coupEstPossible(i-1,j-1,1,-1,-1)){
							return true;
						}
					}
				}
			}
			if(j!=7){
				if(this.tab [i-1][j+1] == 1) {
					if(this.coupEstPossible(i-1,j+1,1,-1,+1)){
						return true;
					}
				}
			}
			if(this.tab [i-1][j] == 1) {
				if(this.coupEstPossible(i-1,j,1,-1,0)){
					return true;
				}
			}
		}
		if(i != 7){
			if(j!=0){
				if(this.tab [i+1][j-1] == 1) {
					if(this.coupEstPossible(i+1,j-1,1,1,-1)){
						return true;
					}
				}
			}
			else if(j!=7){
				if(this.tab [i+1][j+1] == 1) {
					if(this.coupEstPossible(i+1,j+1,1,1,1)){
						return true;
					}
				}
			}
			if(this.tab [i+1][j] == 1) {
				if(this.coupEstPossible(i+1,j,1,1,0)){
					return true;
				}
			}
		}
		if(j != 0 ){
			if(this.tab [i][j-1] == 1) {
				if(this.coupEstPossible(i,j-1,1,0,-1)){
					return true;
				}
			}
		}
		if(j != 7){
			if(this.tab [i][j+1] == 1) {
				if(this.coupEstPossible(i,j+1,1,0,1)){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean regardeAutourBlanc(int i , int j) {
		if(i != 0){
			if(j!=0){
				if(i!=0 && j!=0){
					if(this.tab [i-1][j-1] == 2) {
						if(this.coupEstPossible(i-1,j-1,2,-1,-1)){
							return true;
						}
					}
				}
			}
			if(j!=7){
				if(this.tab [i-1][j+1] == 2) {
					if(this.coupEstPossible(i-1,j+1,2,-1,+1)){
						return true;
					}
				}
			}
			if(this.tab [i-1][j] == 2) {
				if(this.coupEstPossible(i-1,j,2,-1,0)){
					return true;
				}
			}
		}
		if(i != 7){
			if(j!=0){
				if(this.tab [i+1][j-1] == 2) {
					if(this.coupEstPossible(i+1,j-1,2,1,-1)){
						return true;
					}
				}
			}
			else if(j!=7){
				if(this.tab [i+1][j+1] == 2) {
					if(this.coupEstPossible(i+1,j+1,2,1,1)){
						return true;
					}
				}
			}
			if(this.tab [i+1][j] == 2) {
				if(this.coupEstPossible(i+1,j,2,1,0)){
					return true;
				}
			}
		}
		if(j != 0 ){
			if(this.tab [i][j-1] == 2) {
				if(this.coupEstPossible(i,j-1,2,0,-1)){
					return true;
				}
			}
		}
		if(j != 7){
			if(this.tab [i][j+1] == 2) {
				if(this.coupEstPossible(i,j+1,2,0,1)){
					return true;
				}
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
						//on renvoie +1 car on a un décallage entre ce qu'on affiche et la cas eou on joue
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
		if(couleur == 1){
			c=2;
		} else c = 1;
		//System.out.println("verifie si on change en {" + x + "," + y + "}");
		if(tab[x][y]==couleur){
			tab[x][y]=c;
			changerCouleurLigne(x+a,y+b,couleur,a,b);
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
		if(x!=7){
			if(y!=7){
				if(this.tab [x+1][y+1] == couleur) {
					if(this.coupEstPossible(x+1,y+1,couleur,1,1)){
						changerCouleurLigne(x+1,y+1,couleur,1,1);
					}
				}
			}
			if(y!=0){
				if(this.tab [x+1][y-1] == couleur) {
					if(this.coupEstPossible(x+1,y-1,couleur,1,-1)){
						changerCouleurLigne(x+1,y-1,couleur,1,-1);
					}
				}
			}
			if(this.tab [x+1][y] == couleur) {
				if(this.coupEstPossible(x+1,y,couleur,1,0)){
					changerCouleurLigne(x+1,y,couleur,1,0);
				}
			}
		}
		if(x!=0){
			if(y!=7){
				if(this.tab [x-1][y+1] == couleur) {
					if(this.coupEstPossible(x-1,y+1,couleur,-1,1)){
						changerCouleurLigne(x-1,y+1,couleur,-1,1);
					}
				}
			}
			if(y!=0){
				if(this.tab [x-1][y-1] == couleur) {
					if(this.coupEstPossible(x-1,y-1,couleur,-1,-1)){
						changerCouleurLigne(x-1,y-1,couleur,-1,-1);
					}
				}
			}
			if(this.tab [x-1][y] == couleur) {
				if(this.coupEstPossible(x-1,y,couleur,-1,0)){
					changerCouleurLigne(x-1,y,couleur,-1,0);
				}
			}
		}
		if(y!=0){
			if(this.tab [x][y-1] == couleur) {
				if(this.coupEstPossible(x,y-1,couleur,0,-1)){
					changerCouleurLigne(x,y-1,couleur,0,-1);
				}
			}
		}
		if(y!=7){
			if(this.tab [x][y+1] == couleur) {
				if(this.coupEstPossible(x,y+1,couleur,0,1)){
					changerCouleurLigne(x,y+1,couleur,0,1);
				}
			}
		}
		this.NbrBlanc();
		this.NbrNoir();
		this.NbrVide();
		majValTactiques();
	}

	public boolean appartientCoupBlanc(int x, int y){
		Case temp = new Case(x,y);
		for(int i=0;i<listeBlanc.size();i++)
		{
			if(listeBlanc.get(i).getX()==x && listeBlanc.get(i).getY()==y){
				return true;
			}
		}
		return false;
	}
	public boolean appartientCoupNoir(int x, int y){
		Case temp = new Case(x,y);
		for(int i=0;i<listeNoir.size();i++)
		{
			if(listeNoir.get(i).getX()==x && listeNoir.get(i).getY()==y){
				return true;
			}
		}
		return false;
	}

	//Pour faire un tour
	public void joueur1Joue()
	{
		this.majListesCoupsPossibles();
		for(int i=0;i<this.getListeBlanc().size();i++){
			if(this.getListeBlanc().get(i) != null){
				System.out.println("coups possible pour les blancs "+i+ " "+this.getListeBlanc().get(i));
			}
		}
		Scanner scx = new Scanner(System.in);
		Scanner scy = new Scanner(System.in);
		System.out.println("Selectionner la ligne");
		int x = scx.nextInt();
		System.out.println("Selectionner la collone");
		int y = scy.nextInt();
		x--;
		y--;
		if ((x < 8  && x >= 0 )&& (y < 8  && y >= 0  ) && appartientCoupBlanc(x,y)) {
			tab[x][y]=joueur1.getCouleur();
			this.majPlateau(x, y);
			this.majListesCoupsPossibles();
		}else {
			System.out.println("Veuillez resaisir x et y");
			this.joueur1Joue();
		}
		this.NbrBlanc();
		this.NbrNoir();
		this.NbrVide();
	}

	public void joueur2Joue()
	{
		this.majListesCoupsPossibles();
		for(int i=0;i<this.getListeNoir().size();i++){
			if(this.getListeNoir().get(i) != null){
				System.out.println("coups possible pour les noirs "+ i + " " +this.getListeNoir().get(i));
			}
		}
		Scanner scx = new Scanner(System.in);
		Scanner scy = new Scanner(System.in);
		System.out.println("Selectionner la ligne");
		int x = scx.nextInt();
		System.out.println("Selectionner la collone");
		int y = scy.nextInt();
		x--;
		y--;
		if ((x < 8  && x >= 0 )&& (y < 8  && y >= 0  ) && appartientCoupNoir(x,y)) {
			tab[x][y]= joueur2.getCouleur();
			this.majPlateau(x, y);
			this.majListesCoupsPossibles();
		}else {
			System.out.println("Veuillez resaisir x et y");
			this.joueur2Joue();
		}
	}

	//permet de jouer des coups avec la couleur demander pour faire des essais avec l'ia
	public void couleurJoue(Case coup, int couleur)
	{
		int x = coup.getX();
		int y = coup.getY();
		if ((x < 8  && x >= 0 )&& (y < 8  && y >= 0  )) {
			tab[x][y]= couleur;
			this.majPlateau(x, y);
			this.majListesCoupsPossibles();
		}else {
			System.out.println("probleme ia");
		}
	}

	Plateau getPlateau(){
		Plateau p= new Plateau();
		for(int x = 0; x<i; x++)
		{
			for(int y=0; y<j; y++)
			{
				p.tab[x][y] = tab[x][y];
			}
		}
		p.setNbrBlanc(nbrBlanc);
		p.setNbrNoir(nbrNoir);
		p.setNbrVide(nbrVide);
		p.listeBlanc.clear();
		p.listeNoir.clear();
		for(int v=0; v<listeBlanc.size(); v++)
		{
			p.listeBlanc.add(listeBlanc.get(v));
		}
		for(int v=0; v<listeNoir.size(); v++)
		{
			p.listeNoir.add(listeNoir.get(v));
		}
		return p;
	}
}
