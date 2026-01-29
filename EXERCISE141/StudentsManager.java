package EXERCISE141;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;

public class StudentsManager {
    public static boolean addStudent(Students students){
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnecDB.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall("{call add_students(?,?)}");
            stmt.setString(1,students.getName());
            stmt.setInt(2,students.getAge());
            stmt.executeUpdate();
            conn.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnecDB.closeConnection(conn);
        }
        return false;
    }
}
