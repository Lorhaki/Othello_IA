package classe;

import java.util.ArrayList;

public class PlateauIA extends Plateau{
    Ordi ia;

    public PlateauIA(int couleurIa) {
        super();
        ia = new Ordi(couleurIa);
    }



    public Case meilleurCoup(Plateau plateau, int couleur, int nbIteration){
        if(nbIteration > 1){
            int couleurI;
            ArrayList<Case> listeCoupPossible = plateau.getListeBlanc();
            if(couleur == 1){
                couleurI = 2;
            }
            else{
                couleurI = 1;
                listeCoupPossible = plateau.getListeNoir();
            }
            Plateau temp =new Plateau();
            int point = 0;
            Case maxPoint = listeCoupPossible.get(0);
            if(!listeCoupPossible.isEmpty()){
                for(int j = 0; j<listeCoupPossible.size();j++){
                    temp= plateau.getPlateau();
                    temp.couleurJoue(listeCoupPossible.get(j), couleur);
                    temp.couleurJoue(meilleurCoup(temp,couleurI,nbIteration-1),couleurI);
                    temp.couleurJoue(this.meilleurCoup(temp,couleur,nbIteration-1),couleur);
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
                return maxPoint;
            }
        }
        int couleurI;
        ArrayList<Case> listeCoupPossible = plateau.getListeBlanc();
        if(couleur == 1){
            couleurI = 2;
        }
        else{
            couleurI = 1;
            listeCoupPossible = plateau.getListeNoir();
        }
        Plateau temp =new Plateau();
        int point = 0;

        if(!listeCoupPossible.isEmpty()){
            Case maxPoint = listeCoupPossible.get(0);
            for(int j = 0; j<listeCoupPossible.size();j++){
                temp= plateau.getPlateau();
                temp.couleurJoue(listeCoupPossible.get(j), couleur);
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
            return maxPoint;
        }
        System.out.println("liste vide");
        return null;
    }
}
