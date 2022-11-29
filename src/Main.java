import javax.management.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Main
{
    public static void main(String[] args) {
        Connection c=null;
        Statement stmt=null;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");

//getting connection
            c= DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system","234567890");
            System.out.println("database successfully opened");
            stmt=c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from company");

            while(rs.next()){

                System.out.print("id:" + rs.getInt("id")+"\n");
                System.out.print( "name:" + rs.getString("name")+"\n");
                System.out.print( "age:" + rs.getInt("age")+"\n");
                System.out.println( "address:" + rs.getString("address")+"\n");


            }

            stmt.close();
            c.close();
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName()+":"
                    +e.getMessage());
            System.exit(0);
        }
        System.out.println("table values");
    }
}