package synchronization;

public class MultiplicationTable {
    synchronized void multiply(int number){
        try {
            for(int i=1; i<10; i++){
                System.out.println(number+" * " + i + " = " + i*number);
                Thread.sleep(100);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
