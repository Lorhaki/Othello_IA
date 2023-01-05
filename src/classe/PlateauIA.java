package classe;

import java.util.ArrayList;

public class PlateauIA extends Plateau{
    private Joueur ia;


    public PlateauIA(int couleurIa) {
        super();
        ia = new Joueur(couleurIa);
    }

    public void aleatoire(int couleur)
    {
        int rand;
        if(couleur == 1)
        {
            rand = listeBlanc.size();
            rand = (int) (Math.random() * rand);
            this.couleurJoue(listeBlanc.get(rand), couleur);
        }
        else
        {
            rand = listeNoir.size();
            rand = (int) (Math.random() * rand);
            this.couleurJoue(listeNoir.get(rand), couleur);
        }

    }


    //on verifie que l'instantciation du tableau des valeurs tactiques se passe sans probleme
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
        Case c;
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
            if(!listeCoupPossible.isEmpty()){
                Case maxPoint = listeCoupPossible.get(0);
                for(int j = 0; j<listeCoupPossible.size();j++){
                    temp= plateau.getPlateau();
                    temp.couleurJoue(listeCoupPossible.get(j), couleur);
                    c=absolu(temp,couleurI,nbIteration-1);
                    if(c != null)
                    {
                        temp.couleurJoue(c,couleurI);
                        c =this.absolu(temp,couleur,nbIteration-1);
                        if(c !=null)
                        {
                            temp.couleurJoue(c,couleur);
                        }
                    }
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
        //System.out.println("liste vide");
        return null;
    }

    public void iaPositionnel(int couleur, int nbIteration)
    {
        this.couleurJoue(positionel(this.getPlateau(), couleur, nbIteration),couleur);
    }
    public Case positionel(Plateau plateau, int couleur, int nbIteration){
        Case c;
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

            if(!listeCoupPossible.isEmpty()){
                Case maxPoint = listeCoupPossible.get(0);
                for(int j = 0; j<listeCoupPossible.size();j++){
                    temp= plateau.getPlateau();
                    temp.couleurJoue(listeCoupPossible.get(j), couleur);
                    c = positionel(temp,couleurI,nbIteration-1);
                    if(c != null)
                    {
                        temp.couleurJoue(c,couleurI);
                        c = positionel(temp,couleur,nbIteration-1);
                        if(c != null)
                        {
                            temp.couleurJoue(c,couleur);
                        }
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
                    c =positionel(temp,couleur,nbIteration-1);
                    if(c != null)
                    {
                        temp.couleurJoue(c,couleurI);
                    }
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
        //System.out.println("liste vide");
        return null;
    }

    public void iaMobilite(int couleur, int nbIteration)
    {
        this.couleurJoue(mobilite(this.getPlateau(), couleur, nbIteration),couleur);
    }

    public Case mobilite(Plateau plateau, int couleur, int nbIteration){
        Case c;
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
        if(nbIteration > 1){
            if(!listeCoupPossible.isEmpty()){
                Case maxPoint = listeCoupPossible.get(0);
                for(int i = 0; i<listeCoupPossible.size();i++){
                    //on priorise les coins
                    if(listeCoupPossible.get(i).egal(new Case(0, 0)) || listeCoupPossible.get(i).egal(new Case(0, 7)) || listeCoupPossible.get(i).egal(new Case(7, 0)) || listeCoupPossible.get(i).egal(new Case(7, 7)))
                    {
                        return listeCoupPossible.get(i);
                    }
                    temp= plateau.getPlateau();
                    temp.couleurJoue(listeCoupPossible.get(i), couleur);
                    c = mobilite(temp,couleurI,nbIteration-1);
                    if(c!=null)
                    {
                        temp.couleurJoue(c,couleurI);
                        c=mobilite(temp,couleur,nbIteration-1);
                        if(c!=null)
                        {
                            temp.couleurJoue(c,couleur);
                        }
                    }
                    //si l'adversaire ne peut pas jouer au tour suivant on retourne ce coup qui permet d'empecher l'adversaire de jouer
                    else return listeCoupPossible.get(i);
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
            Case maxPoint = listeCoupPossible.get(0);
            for(int i = 0; i<listeCoupPossible.size();i++){
                if(listeCoupPossible.get(i).egal(new Case(0, 0)) || listeCoupPossible.get(i).egal(new Case(0, 7)) || listeCoupPossible.get(i).egal(new Case(7, 0)) || listeCoupPossible.get(i).egal(new Case(7, 7)))
                {
                    return listeCoupPossible.get(i);
                }
                temp = plateau.getPlateau();
                temp.couleurJoue(listeCoupPossible.get(i), couleur);
                if(nbIteration > 0)
                {
                    c = mobilite(temp, couleurI, nbIteration-1);
                    if(c!=null)
                    {
                        temp.couleurJoue(c,couleurI);
                    }
                }

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

        //System.out.println("liste vide");
        return null;
    }

    public void iaMixte(int couleur, int nbIteration)
    {
        this.couleurJoue(mixte( couleur, nbIteration),couleur);
    }

    public Case mixte(int couleur, int nbIteration)
    {
        if(nbrBlanc + nbrNoir < 20)
        {
            return positionel(this.getPlateau(), couleur, nbIteration);
        }
        if(nbrVide <= 10)
        {
            return absolu(this.getPlateau(), couleur, nbIteration);
        }
        return mobilite(this.getPlateau(), couleur, nbIteration);
    }
}
