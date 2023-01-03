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



    //renvoie la valeur du coup Noir pour que les noirs gagnes
    public void noirGagneMinMax(Plateau p, int nb, int x, int y){

    }
}
