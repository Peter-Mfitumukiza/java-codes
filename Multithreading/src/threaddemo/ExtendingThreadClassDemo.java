package threaddemo;

public class ExtendingThreadClassDemo extends Thread {
    public String threadName;

    public static void main(String[] args) {
        ExtendingThreadClassDemo myThread = new ExtendingThreadClassDemo("First thread");
        ExtendingThreadClassDemo mySecThread = new ExtendingThreadClassDemo("Second thread");
        myThread.start();
        mySecThread.start();
    }

    public ExtendingThreadClassDemo(String threadName){
        this.threadName = threadName;
    }
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println("Thread: " + i + " is: " + threadName);
        }
    }
}