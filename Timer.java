import java.util.concurrent.TimeUnit;

public class Timer {

    private long startTime;
    private int count;

    public Timer() {

        this.startTime = System.nanoTime();
        this.count = 0;
    }

    public String format(long time) {
        time /= 1000000; //passage du temps en ms
        int milli = (int) time%1000;
        time /= 1000; //passage du temps en secondes
        int sec = (int) time%60;
        time /= 60; //passage du temps en minutes;
        int min = (int) time%60;
        time /= 60; //passage du temps en heures;
        int h = (int) time%60;

        return h + "h" + min + "m" + sec + "." + milli + "s";
    }

    public String toString() {
        this.count++;
        long searchTime = (System.nanoTime() - startTime);
        long averageTime = searchTime / this.count;
        return "Duree de la recheche : "
                + format(System.nanoTime() - startTime)
                + "\nDuree moyenne pour une solution : "
                + format(averageTime);
    }
}