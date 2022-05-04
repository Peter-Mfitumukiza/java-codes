package synchronization;
public class SecondMultiplication  extends  Thread{
    String name;
    MultiplicationTable table;
    int number;

    public SecondMultiplication(String names, MultiplicationTable tabl , int nbr){
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
