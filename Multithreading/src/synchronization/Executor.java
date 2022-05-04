package synchronization;

public class Executor extends  Thread{
    Task task;
    String names;
    Thread t;
    Integer number;
    public Executor(String names, Integer number, Task task){
        this.names = names;
        this.number = number;
        this.task = task;
    }

    @Override
    public void run() {
        synchronized (task){
            System.out.println(names + " started");
            task.perform(number);
            System.out.println(names + "completed");
        }
    }

    public void start(){
        if(t==null){
            t = new Thread(this);
            t.start();
        }
    }
}
