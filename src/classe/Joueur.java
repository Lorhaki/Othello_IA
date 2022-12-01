package classe;

public class Joueur {
    private int couleur ; //1 pour blanc 2 pour noir

    public Joueur(int couleur) {
        this.couleur = couleur;
    }

    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }
}
