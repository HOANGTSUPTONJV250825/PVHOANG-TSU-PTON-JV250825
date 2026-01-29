package EXERCISE144;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankingManager {

    public static boolean transferFunds(int IDFrom,int IDTo, double Amount){
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = Untill.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall("{call transfer_funds(?,?,?)}");
            stmt.setInt(1,IDFrom);
            stmt.setInt(2,IDTo);
            stmt.setDouble(3,Amount);
            stmt.executeUpdate();
            conn.commit();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Untill.closeConnection(conn);
        }
        return false;
    }
}
