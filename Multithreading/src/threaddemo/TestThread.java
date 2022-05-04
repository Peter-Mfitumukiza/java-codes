package threaddemo;

import threaddemo.RunnableDemo;

public class TestThread {
    public static void main(String[] args) {
        RunnableDemo thread1 = new RunnableDemo("Thread one");
        RunnableDemo thread2 = new RunnableDemo("Thread Two");
        thread1.execute();
        thread2.execute();
    }
}
