package services;

public class Timer {

    public static long startTimer() {
        long startTime = System.currentTimeMillis();
        return startTime;
    }

    public static long endTimer(long startTime) {
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        return totalTime;
    }
}
