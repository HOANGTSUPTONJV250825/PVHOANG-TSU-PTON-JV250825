package EXERCISE144;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Untill {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/Banking";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection(){
        Connection conn;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        }catch (SQLException|ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void closeConnection(Connection conn){
        try{
            if (conn != null){
                conn.close();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
