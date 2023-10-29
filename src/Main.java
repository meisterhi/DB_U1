
import java.sql.*;
import java.util.Properties;

public class Main {

    
    public static void main(String[] args) {
        
        final Properties props = new Properties();
        props.setProperty("user", "student2");
        props.setProperty("password", "student");
        props.setProperty("ssl", "true");
        final String url = "jdbc:postgresql://141.64.89.149/world";
        

    try{
        Connection conn = DriverManager.getConnection(url, props);    

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM mytable WHERE columnfoo = 500"); //TODO: add Quarry
        while (rs.next()) {
        System.out.print("Column 1 returned "); // TODO: Add meaning
        System.out.println(rs.getString(1));
            }
        rs.close();
        st.close();
    } catch (SQLException  e) {
        // TODO: handle exception
        System.err.println("Failed establishing Connection \n" + e);
        
    }

    }

}