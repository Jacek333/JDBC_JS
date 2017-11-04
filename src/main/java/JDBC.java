import java.sql.*;

public class JDBC {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/j1b";
    // Database credentials
    static final String USER = "root";
    static final String PASS = "";
    String sql;


    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM adresy";
            ResultSet rs = stmt.executeQuery(sql);
            sql = "INSERT INTO adresy (id_adresu, ulica, numer_domu, numer_mieszkania, kod_pocztowy, miasto) VALUES (101, 'Wiązowa','5','10', '85-333', 'Bydgoszcz', )";
            int result = stmt.executeUpdate(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id_adresu = rs.getInt("id_adresu");
                String ulica = rs.getString("ulica");
                int numer_domu = rs.getInt("numer_domu");
                int numer_mieszkania = rs.getInt("numer_mieszkania");
                int kod_pocztowy = rs.getInt("kod_pocztowy");
                String miasto = rs.getString("miasto");
                //Display values
                System.out.print("ID: " + id_adresu);
                System.out.print(", Age: " + ulica);
                System.out.print(", Numer Domu: " + numer_domu);
                System.out.println(", Numer Mieszkania: " + numer_mieszkania);
                System.out.println(", Kod Pocztowy: " + kod_pocztowy);
                System.out.println(", Miasto: " + miasto);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        System.out.println("Goodbye!");
    }//end main
}//end JDBC