package classe;

import java.util.ArrayList;

public class PlateauIA extends Plateau{
    Joueur ia;


    public PlateauIA(int couleurIa) {
        super();
        ia = new Joueur(couleurIa);
    }



    //on verifie que l'instantciation se passe sans probleme
    public void affichTactiques()
    {
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                System.out.print(tactiques[i][j] +" ");
            }
            System.out.println();
        }
    }

    public void iaAbsolu(int couleur, int nbIteration)
    {
        this.couleurJoue(absolu(this.getPlateau(), couleur, nbIteration),couleur);
    }

    public Case absolu(Plateau plateau, int couleur, int nbIteration){
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
                    temp.couleurJoue(absolu(temp,couleurI,nbIteration-1),couleurI);
                    temp.couleurJoue(this.absolu(temp,couleur,nbIteration-1),couleur);
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

    public void iaPositionnel(int couleur, int nbIteration)
    {
        this.couleurJoue(positionel(this.getPlateau(), couleur, nbIteration),couleur);
    }
    public Case positionel(Plateau plateau, int couleur, int nbIteration){
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
                    temp.couleurJoue(positionel(temp,couleurI,nbIteration-1),couleurI);
                    temp.couleurJoue(positionel(temp,couleur,nbIteration-1),couleur);
                    if(couleur == 1){
                        if(temp.getValBlanc() >= point){
                            point = temp.getValBlanc();
                            maxPoint = listeCoupPossible.get(j);
                        }
                    }
                    else{
                        if(temp.getValNoir() >= point){
                            point = temp.getValNoir();
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
                if(nbIteration == 1)
                {
                    temp.couleurJoue(positionel(temp,couleur,nbIteration-1),couleur);
                }
                if(couleur == 1){
                    if(temp.getValBlanc() >= point){
                        point = temp.getValBlanc();
                        maxPoint = listeCoupPossible.get(j);
                    }
                }
                else{
                    if(temp.getValNoir() >= point){
                        point = temp.getValNoir();
                        maxPoint = listeCoupPossible.get(j);
                    }
                }
            }
            return maxPoint;
        }
        System.out.println("liste vide");
        return null;
    }

    public void iaMobilite(int couleur, int nbIteration)
    {
        this.couleurJoue(mobillité(this.getPlateau(), couleur, nbIteration),couleur);
    }
    public Case mobillité(Plateau plateau, int couleur, int nbIteration){
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
        if(nbIteration > 1){
            if(!listeCoupPossible.isEmpty()){
                for(int i = 0; i<listeCoupPossible.size();i++){
                    if(listeCoupPossible.get(i).egal(new Case(0, 0)) || listeCoupPossible.get(i).egal(new Case(0, 7)) || listeCoupPossible.get(i).egal(new Case(7, 0)) || listeCoupPossible.get(i).egal(new Case(7, 7)))
                    {
                        return listeCoupPossible.get(i);
                    }
                    temp= plateau.getPlateau();
                    temp.couleurJoue(listeCoupPossible.get(i), couleur);
                    temp.couleurJoue(positionel(temp,couleurI,nbIteration-1),couleurI);
                    temp.couleurJoue(positionel(temp,couleur,nbIteration-1),couleur);

                    if(couleur == 1){
                        if(temp.getListeBlanc().size() - temp.getListeNoir().size() >= point)
                        {
                            maxPoint = listeCoupPossible.get(i);
                            point = temp.getListeBlanc().size() - temp.getListeNoir().size();
                        }
                    }
                    else{
                        if(temp.getListeNoir().size() - temp.getListeBlanc().size() >= point)
                        {
                            point = temp.getListeNoir().size() - temp.getListeBlanc().size();
                            maxPoint = listeCoupPossible.get(i);
                        }
                    }
                }
                return maxPoint;
            }
        }
        if(!listeCoupPossible.isEmpty()){
            for(int i = 0; i<listeCoupPossible.size();i++){
                if(listeCoupPossible.get(i).egal(new Case(0, 0)) || listeCoupPossible.get(i).egal(new Case(0, 7)) || listeCoupPossible.get(i).egal(new Case(7, 0)) || listeCoupPossible.get(i).egal(new Case(7, 7)))
                {
                    return listeCoupPossible.get(i);
                }
                temp = plateau.getPlateau();
                temp.couleurJoue(listeCoupPossible.get(i), couleur);

                if(couleur == 1){
                    if(temp.getListeBlanc().size() - temp.getListeNoir().size() >= point)
                    {
                        maxPoint = listeCoupPossible.get(i);
                        point = temp.getListeBlanc().size() - temp.getListeNoir().size();
                    }
                }
                else{
                    if(temp.getListeNoir().size() - temp.getListeBlanc().size() >= point)
                    {
                        point = temp.getListeNoir().size() - temp.getListeBlanc().size();
                        maxPoint = listeCoupPossible.get(i);
                    }
                }
            }
            return maxPoint;
        }

        System.out.println("liste vide");
        return null;
    }

    public Case mixte( int couleur, int nbIteration)
    {
        if(nbrBlanc + nbrNoir < 20)
        {
            return positionel(this.getPlateau(), couleur, nbIteration);
        }
        if(nbrVide > 10)
        {
            return absolu(this.getPlateau(), couleur, nbIteration);
        }
        return mobillité(this.getPlateau(), couleur, nbIteration);
    }
}
