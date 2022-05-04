package synchronization;

public class Task {
    public void perform(int number){
        try{
            for(int i=1; i<=10; i++){
                System.out.println(i + " * " + number + " = " + i*number);
                Thread.sleep(100);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
