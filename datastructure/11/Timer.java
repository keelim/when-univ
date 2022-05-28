public class Timer {
    private long start;
    private long stop;

    public long getStart() {
        return start;
    } //getter

    public void setStart(long start) {
        this.start = start;
    } //setter

    public long getStop() {
        return stop;
    } //getter

    public void setStop(long stop) {
        this.stop = stop;
    } //setter

    public void start() {
        this.setStart(System.nanoTime());
    } //시스템 시간 측정

    public void stop() {
        this.setStop(System.nanoTime());
    } //시스템 시간 측정

    public long duration() {
        return this.getStop() - this.getStart();
    }
}
