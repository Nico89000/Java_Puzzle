public class Piece {


    private int size;
    private boolean availability;


    /**
     * constructeur de piece
     * @param n la taille de la piece
     */
    public Piece(int n) {

        this.size = n;
        this.availability = true;
    }

    public static Piece[] creerTableauPieces(int n) {

        int nbrPieces = ((n*(n+1))/2);
        Piece[] tab = new Piece[nbrPieces];

        int c = 0;
        for(int i = n; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                tab[c] = new Piece(i);
                c++;
            }
        }

        return tab;
    }

    /**
     * methode permettant d'obtenir la taille de la piece
     * @return la taille de la piece
     */
    public int getSize() {
        return size;
    }

    /**
     * methode permettant d'obtenir la disponibilite de la piece
     * @return true si la piece est disponible (pas encore utilise), false sinon
     */
    public boolean isAvailable() {
        return availability;
    }

    /**
     * methode permettant de definir une piece comme etant utilise
     */
    public void setUse() {
        availability = false;
    }

    /**
     * methode permettant de definir une piece comme n'etant pas utilise
     */
    public void setFree() {
        availability = true;
    }

    /**
     * methode permettant d'afficher le tableau de piece
     * @param tab le tableau de piece
     */
    public static void displayPieces(Piece[] tab) {
        System.out.print("\n| ");
        for(int i = 0; i < tab.length; i++)
            System.out.print(tab[i].getSize() + " | ");

        System.out.print("\n");
    }
}
