package classe;

import java.util.ArrayList;

public class Ordi extends Joueur{

    //permet de savoir le nombre d'iteration effectuer par l'IA
    int iteration=3;
    private Plateau plateau = new Plateau();

    public Ordi(int couleur) {
        super(couleur);
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public void simuNoir(int nb)
    {
        ArrayList<Integer> listeQualite = new ArrayList<>();
        ArrayList<Case> listeCoupPossible = plateau.getListeNoir();
        ArrayList<Case> listeCoupEnnemi = plateau.getListeBlanc();
        Plateau temp = plateau;


    }

    public Case meilleurCoup(Plateau plateau, int couleur, int nbIteration){
        int couleurI;
        ArrayList<Case> listeCoupPossible = plateau.getListeBlanc();
        ArrayList<Case> listeCoupEnnemi = plateau.getListeNoir();
        if(couleur == 1){
            couleurI = 2;
        }
        else{
            couleurI = 1;
            listeCoupPossible = plateau.getListeNoir();
            listeCoupEnnemi = plateau.getListeBlanc();
        }
        Plateau temp =new Plateau();
        int point = 0;
        Case maxPoint = new Case();
        for (int i = 0; i<nbIteration; i++){
            for(int j = 0; j<listeCoupPossible.size();j++){
                temp= plateau;
                temp.iaJoue(listeCoupPossible.get(j),couleur);
                temp.iaJoue(meilleurCoup(temp,couleurI,nbIteration),couleurI);
                temp.iaJoue(this.meilleurCoup(temp,couleur,nbIteration-1),couleur);
                if(couleur == 1){
                    if((temp.getNbrBlanc()-temp.getNbrNoir()) >= point){
                        point = temp.getNbrBlanc() - temp.getNbrNoir();
                        maxPoint = listeCoupPossible.get(j);
                    }
                }
                else{
                    if((temp.getNbrNoir()-temp.getNbrBlanc()) >= point){
                        point = temp.getNbrNoir() - temp.getNbrBlanc();
                        maxPoint = listeCoupPossible.get(j);
                    }
                }
            }
        }
        return maxPoint;
    }

    //renvoie la valeur du coup Noir pour que les noirs gagnes
    public void noirGagneMinMax(Plateau p, int nb, int x, int y){

    }
}
