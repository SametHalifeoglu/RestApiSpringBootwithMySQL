package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {

    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://localhost/";

    private String dbName = "spring";
    private String dbUser = "root";
    private String dbPass = "";
    final private String encode = "?useUnicode=true&characterEncoding=utf-8";

    private Connection conn=null;
    private Statement st=null;

    public DB() {}


    public Statement connectDB() {
        try {
            if(conn!=null) {
                closeDB();
            }
            Class.forName(driver);
            conn=DriverManager.getConnection(url+dbName+encode, dbUser, dbPass);
            st=conn.createStatement();
            System.out.println("Connection successful!");
        } catch (Exception e) {
            System.err.println("Connection failed!" + e.getMessage());
        }

        return st;

    }

    public void closeDB() {
        try {
            if(st!=null) {
                st.close();
                System.out.println("Statement closed");
                st=null;
            }
            if(conn!=null) {
                conn.close();
                System.out.println("Connection closed");
                conn=null;
            }
        } catch (Exception e) {
            System.err.println("Closing Fault!");
        }

    }
}
