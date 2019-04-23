import java.util.Scanner;

public class Resolution {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Valeur du nombre n : ");
        int n = sc.nextInt();
        boolean all = oneOrAll();

        Piece[] tabPieces = Piece.creerTableauPieces(n); //creation du tableau de pieces
        Puzzle p = new Puzzle(n); //creation du puzzle vide

        Piece.displayPieces(tabPieces); //affichage du tableau de pieces
        p.displayPuzzle(); //affichage du puzzle

        Timer timer = new Timer(); //creation du timer
        Recursivite.resolvePuzzle(tabPieces.length, 0, tabPieces, p, all, timer); //entree dans la fonction recursive

        if (p.getPossibility() == 0) //si tout a ete essaye mais qu'aucunes solutions n'a ete trouve
            System.out.print("\nResultat : \nAucunes solution n'a ete trouve pour n = " + n);
    }


    /**
     * methode permettant de choisir son mode de recherche
     * @return true si toutes les solutions sont recherche, false si une solution est recherche
     */
    public static boolean oneOrAll() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Combien de solution faut-il rechercher ? (O = one / A = all) ");
        char c = sc.next().charAt(0);
        if (c == 'O' || c == 'o') return false;
        else if (c == 'A' || c == 'a') return true;
        else return oneOrAll();
    }
}