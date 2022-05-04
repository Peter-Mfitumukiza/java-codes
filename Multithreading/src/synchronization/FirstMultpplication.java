package synchronization;

public class FirstMultpplication extends Thread{
    String name;
    MultiplicationTable table;
    int number;

    public FirstMultpplication(String names, MultiplicationTable tabl , int nbr){
        name = names;
        number = nbr;
        table = tabl;
    }

    @Override
    public void run(){
        System.out.println(name +" Started!");
        table.multiply(number);
        System.out.println(name+" Completed!");
    }
}
