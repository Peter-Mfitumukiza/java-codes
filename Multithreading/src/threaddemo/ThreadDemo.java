package threaddemo;

public class ThreadDemo {
    public static void main(String[] args) throws Exception{
        new Thread(
            new Runnable(){
                public void run(){
                    for (int i=0; i<10; i++){
                        System.out.println("Hello from a thread!" + System.currentTimeMillis());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        ).start();
//        System.out.println("Completed a thread.");
    }
}
