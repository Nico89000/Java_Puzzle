import java.util.Arrays;

public class Puzzle {


    private int n, size, possibility;
    private int[][] puzzle;


    /**
     * consctructeur de puzzle
     * @param n la valeur a utiliser
     */
    public Puzzle(int n) {

        this.n = n;
        this.size = calculPuzzleSize(n);
        this.puzzle = createPuzzle(size);
        this.possibility = 0;
    }


    /**
     * methode permettant de calculer la taille d'un cote du puzzle
     * @param n la valeur n a utiliser
     * @return la taille d'un cote du puzzle
     */
    private int calculPuzzleSize(int n) {
        return ((n*(n+1))/2);
    }

    /**
     * methode permettant de creer le puzzle
     * @param size la taille d'un cote du puzzle
     * @return le puzzle
     */
    public static int[][] createPuzzle(int size) {

        int[][] puzzle = new int[size][size];

        for(int x = 0; x < puzzle.length; x++)
            for(int y = 0; y < puzzle[x].length; y++)
                puzzle[x][y] = 0;

        return puzzle;
    }

    /**
     * methode permettant d'obtenir la valeur de n utilise
     * @return la valeur de n
     */
    public int getN() {
        return n;
    }

    /**
     * methode permettant d'obtenir la taille d'un cote du puzzle
     * @return la taille d'un cote du puzzle
     */
    public int getSize() {
        return size;
    }

    /**
     * methode permettant d'obtenir le puzzle
     * @return le puzzle
     */
    public int[][] getPuzzle() {
        return puzzle;
    }

    /**
     * methode permettant d'obtenir la valeur en position x, y
     * @param x le numero de la ligne
     * @param y le numero de la colonne
     * @return la valeur de l'emplacement
     */
    public int getPos(int x, int y) {
        return puzzle[x][y];
    }

    /**
     * methode permettant d'obtenir le nombre de possibilite du puzzle
     * @return le nombre de possibilte
     */
    public int getPossibility() {
        return possibility;
    }

    /**
     * methode permettant de modifier la valeur en position x, y
     * @param x le numero de la ligne
     * @param y le numero de la colonne
     * @param val la valeur a appliquer
     */
    public void setPos(int x, int y, int val) {
        puzzle[x][y] = val;
    }

    /**
     * methode permettant d'augmenter de 1 le nombre de possibilite du puzzle
     */
    public void upPossibility() {
        possibility++;
    }

    /**
     * methode permettant d'afficher le puzzle
     */
    public void displayPuzzle() {
        System.out.print("\n");
        for (int[] val : puzzle)
            System.out.println(Arrays.toString(val));
    }
}