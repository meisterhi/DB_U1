
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        
        final Properties props = new Properties();
        props.setProperty("user", "student2");
        props.setProperty("password", "student");
        props.setProperty("ssl", "false");
        final String url = "jdbc:postgresql://141.64.89.149/world";
    
    try{
        Connection conn = DriverManager.getConnection(url, props);    
        getQuarry("SELECT COUNT(*) FROM CITY", conn);
        System.out.println("-------");
        getQuarry("SELECT name,population FROM CITY Order by population ASC ", conn);

    } catch (SQLException  e) {
        System.err.println("Failed establishing Connection \n" + e);      
    }
    }
    public static void getQuarry(String m, Connection conn) throws SQLException{
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(m);
        while (rs.next()) {
            //System.out.print("Row " +rs.getRow() + " returned"); // TODO: Add meaning
            int colIndex = rs.getMetaData().getColumnCount();
            while (colIndex > 0) {
                System.out.print(" "+rs.getString(colIndex) );
                colIndex--;
            }
            System.err.println();
            
        }
        rs.close();
        st.close();
    }

}