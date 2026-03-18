import java.sql.*;

public class DemoJDBC { // No 'throw' here
    public static void main(String[] args) throws Exception { // 'throws' goes here
        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "x";
        String sql = "select sname from student where sid = 1";
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass); // Added .getConnection

        System.out.println("Connection established");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        String name = rs.getString("sname");
        System.out.println("Student name is" + name);
        con.close();
        System.out.println("Connection closed");
    }
}