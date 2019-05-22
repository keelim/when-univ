public class Timer {

    private long start;
    private long stop;

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getStop() {
        return stop;
    }

    public void setStop(long stop) {
        this.stop = stop;
    }

    public void start() {
        this.setStart(System.nanoTime());
    }

    public void stop() {
        this.setStop(System.nanoTime());
    }


    public long duration() {
        return this.getStop() - this.getStart();
    }
}
