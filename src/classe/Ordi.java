package classe;

import java.util.ArrayList;

public class Ordi extends Joueur{
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
        for(int i = 0; i<listeCoupPossible.size();i++){

        }
    }

    //renvoie la valeur du coup Noir pour que les noirs gagnes
    public void noirGagneMinMax(Plateau p, int nb, int x, int y){

    }
}
