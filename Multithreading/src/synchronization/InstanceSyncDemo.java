package synchronization;

public class InstanceSyncDemo {

    public static void main(String[] args) {
//        Task t = new Task();
//        Executor exec1 = new Executor("Task one ", 5, t);
//        Executor exec2 = new Executor("Task two ", 10, t);
//        exec1.start();
//        exec2.start();
//        System.out.println("All completed");
        MultiplicationTable table = new MultiplicationTable();
        FirstMultpplication first = new FirstMultpplication("First", table, 3);
        SecondMultiplication second = new SecondMultiplication("Second", table, 4);
        first.start();
        second.start();
    }

}
