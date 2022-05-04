package jdbc;
import java.sql.*;

public class MysqlConnectionDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Connection conn = connectToDatabase("com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/jdbc_demo?characterEncoding=latin1",
                    "peter",
                    "2021");
            Statement statement;
            statement = conn.createStatement();
//			statement.execute("create table person(id int primary key auto_increment, " +
//                    "firstname varchar(250), lastname varchar(250),"
//					+ "gender varchar(25))");
//			statement.execute("insert into person(firstname, lastname, gender) " +
//                   "values('Hashimweyesu', 'Jean de Dieu', 'MALE')");
            ResultSet rs = statement.executeQuery("select * from person");
            printMetaData(rs);
            printResultSet(rs, new String[]{ "id", "firstname", "lastname", "gender" });

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection connectToDatabase( String driver, String url, String username, String password) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Something wrong with the driver.");
            System.exit(-1);
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Something went wrong while connecting to the database");
            System.exit(-1);
        }
        if(conn != null) {
            System.out.println("Successfully connected to DB....");
            return conn;
        }

        System.out.println("Connection failed");
        return null;
    }
    public static void printResultSet(ResultSet rs, String[] fields ) throws Exception{
        if(!(rs.next())){
            System.out.println("Nothing found!");
        }
        do{
            for(int i=0; i< fields.length; i++){
                System.out.print(rs.getString(fields[i]) + "\t");
            }
            System.out.print("\n");
        }while(rs.next());
    }
    public static void printMetaData(ResultSet rs) throws Exception{
        System.out.println("DB: " + rs.getMetaData().getCatalogName(1) +
                "  Table: " + rs.getMetaData().getTableName(1));
        System.out.println("Table description: ");
        for(int i=1; i<=rs.getMetaData().getColumnCount(); i++) {
            System.out.print(rs.getMetaData().getColumnName(i) + "\t");
        }
        System.out.print("\n");
    }
}