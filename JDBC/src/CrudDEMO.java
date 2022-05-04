package jdbc;
import java.sql.*;
import java.util.Scanner;

public class CrudDEMO {
    public static void main(String[] args) {
//        Connecting to database using a method defined in MysqlConnectionDemo file.
        Connection conn = MysqlConnectionDemo.connectToDatabase("com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost:3306/jdbc_demo?characterEncoding=latin1",
                "",
                "");

        System.out.println("============ Welcome to our book store ============");
        System.out.println("Choose where to go next: ");
        Boolean canContinue = true;
        while(canContinue){
            System.out.println("1. View all books\n2. Read a book\n3. Register a new book\n4. Update a book\n" +
                    "5. Delete a book\n6. Exit");
            Scanner inScanner = new Scanner(System.in);
            int userInput  = inScanner.nextInt();
            inScanner.nextLine();
            switch (userInput){
                case 1 : {
                    viewBooks(conn);
                    break;
                }
                case 2 : {
                    readBook(conn, inScanner);
                    break;
                }
                case 3 : {
                    registerBook(conn, inScanner);
                    break;
                }
                case 4 : {
                    updateBook(conn, inScanner);
                    break;
                }
                case 5 :{
                    deleteBook(conn, inScanner);
                    break;
                }
                case 6 :{
                    System.out.println("Bye!");
                    System.exit(1);
                    break;
                }
                default:
                    System.out.println("Invalid choice please try again");
            }
            System.out.println("Press \n1. To continue\n0. Elsewhere to exit");
            int cont = 0;
            try{
                cont = inScanner.nextInt();
                inScanner.nextLine();
            }catch (Exception e){
                System.out.println("Invalid input.");
            }
            if(cont != 1){
                canContinue = false;
                System.out.println("Thanks for visiting our store! Bye!");
            }
        }
    }

    public static void viewBooks(Connection conn){
        Statement statement;
        try {
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from books");
//            Using methods already defined in MysqlConnectionDemo file to display results.
            MysqlConnectionDemo.printMetaData(rs);
            MysqlConnectionDemo.printResultSet(rs, new String[] { "Title", "Author", "Content" });
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("\n======= end of list =======\n");
    }
    public static void readBook(Connection conn, Scanner inScanner){
        System.out.print("Enter the title of the book you want to read: ");
        String bookTitle = inScanner.nextLine();
        Statement statement;
        try{
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("Select Title, Content from books where Title = '" +
                    bookTitle + "'");
            MysqlConnectionDemo.printMetaData(rs);
            MysqlConnectionDemo.printResultSet(rs, new String[]{"Title", "Content"});
        }catch(Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println("======== book read ========");
    }
    public static void registerBook(Connection conn, Scanner inScanner){
        System.out.println("Enter book's details");
        String bookTitle = null;
        String bookAuthor = null;
        String bookContent = null;
        try{
            System.out.print("Title: ");
            bookTitle = inScanner.nextLine();
            System.out.print("Author: ");
            bookAuthor = inScanner.nextLine();
            System.out.print("Content: ");
            bookContent = inScanner.nextLine();
        }catch (Exception e){
            System.out.println("Invalid input. Try again.");
            System.exit(-1);
        }
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.execute("create table if not exists books( id int primary key auto_increment, " +
                    "Title varchar(100) not null, Author varchar(100), Content varchar(500) not null)");
            statement.execute("insert into books(Title, Author, Content) values ('" + bookTitle + "', '" +
                    bookAuthor + "', '" + bookContent + "' )");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println("======= book registered successfully =======");
    }
    public static void updateBook(Connection conn, Scanner inScanner){
        Statement statement;
        String bookTitle = null;
        String fieldToUpdate = null;
        String newValue = null;
        System.out.println("Enter details of the book to update: ");
        try{
            System.out.print("Title: ");
            bookTitle = inScanner.nextLine();
            System.out.print("Field to update: ");
            fieldToUpdate = inScanner.nextLine();
            System.out.print("New value: ");
            newValue = inScanner.nextLine();
        }catch(Exception e){
            System.out.println("Invalid input! Try again.");
            System.exit(-1);
        }
        try{
            statement = conn.createStatement();
            statement.execute("update books set " + fieldToUpdate + " = '" + newValue + "' where Title = '" +
                    bookTitle + "'");
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println("======= book updated successfully =======");
    }
    public static void deleteBook(Connection conn, Scanner inScanner){
        Statement statement;
        String bookTitle = null;
        try{
            System.out.print("Title: ");
            bookTitle = inScanner.nextLine();
            statement = conn.createStatement();
            statement.execute("delete from books where Title = '" + bookTitle + "'");
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println("======= book is deleted =======");
    }
}