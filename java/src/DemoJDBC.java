import java.sql.*;

public class DemoJDBC { // No 'throw' here
    public static void main(String[] args) throws Exception { // 'throws' goes here
        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "x";

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass); // Added .getConnection

        System.out.println("Connection established");
    }
}