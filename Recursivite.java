public class Recursivite {


    /**
     * methode permettant de trouver une solution au puzzle recursivement
     * @param pieceLeft le nombre de piece disponible restantes
     * @param rowLeft le nombre de lignes disponible restantes
     * @param tab le tableau de pieces
     * @param p le puzzle
     * @param all permet de savoir si il faut chercher une solution (all == false) ou toutes les solutions (all == true)
     */
    public static void resolvePuzzle(int pieceLeft, int rowLeft, Piece[] tab, Puzzle p, boolean all, Timer timer) {

        /* recherche d'une place libre */
        int x = rowLeft, y = 0;
        boolean placeFound = false;
        while (!placeFound && x < p.getSize()) //tant que : aucunes place n'est trouve ET que la valeur x ne sort pas du tableau ET que la valeur y
        {
            if (p.getPos(x, y) == 0) placeFound = true; //si place libre trouve : signaler place trouver
            else {
                y++;
                if (y == p.getSize()) {
                    x++;
                    y = 0;
                    rowLeft++;
                }
            }
        }


        if(placeFound) //SI UNE PLACE EST TROUVE
        {
            /* Recherche de la taille max dispo */
            int size = 1, a = x, b;
            boolean reachSom1 = false;
            while (!reachSom1 && size < p.getN() && a < p.getSize())
            {
                for (a = x, b = y+size; (a < (x+size)) && (!reachSom1); a++) {
                    if (a < p.getSize() && b < p.getSize()) { //si toujours dans le tableau
                        if (p.getPos(a, b) != 0) reachSom1 = true; //si emplacement non vide
                    } else reachSom1 = true;
                }

                if (a >= p.getSize()) reachSom1 = true;

                for (; b - y >= 0 && !reachSom1 && b < p.getSize(); b--) {
                    if (a < p.getSize() && b < p.getSize()) {
                        if (p.getPos(a, b) != 0) reachSom1 = true; //si emplacement non vide
                    } else reachSom1 = true;
                }

                if (!reachSom1) size++;
            }

            /* Placement des pieces */
            int oldPiece = -1;
            for(int k = 0; k < tab.length; k++) {
                if (tab[k].getSize() <= size && tab[k].getSize() != oldPiece && tab[k].isAvailable())
                {
                    oldPiece = tab[k].getSize();

                    for(a = x; (a < (x + tab[k].getSize())); a++)
                        for(b = y; (b < (y + tab[k].getSize())); b++)
                            p.setPos(a, b, tab[k].getSize());

                    tab[k].setUse();
                    pieceLeft--;

                    resolvePuzzle(pieceLeft, rowLeft, tab, p, all, timer); //APPEL RECURSIF

                    for(a = x; (a < (x + tab[k].getSize())); a++)
                        for(b = y; (b < (y + tab[k].getSize())); b++)
                            p.setPos(a, b, 0);

                    tab[k].setFree();
                    pieceLeft++;
                }
            }
        }

        if (pieceLeft == 0) { //si aucunes pieces disponibles restantes
            p.upPossibility(); //augmenter le nombre de solution
            System.out.println("Resultat : ");
            p.displayPuzzle(); //afficher la solution
            System.out.println("\n" + timer);
            if (!all) System.exit(0); //si une seul solution est recherche : quitter
            else System.out.println("\nNombre de solutions trouve : " + p.getPossibility());
        }

    }

}