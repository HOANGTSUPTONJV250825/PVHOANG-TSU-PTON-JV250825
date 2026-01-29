package EXERCISE141;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public static Students findInfor(int StudentID){
        Connection conn = null;
        CallableStatement stmt = null;
        Students students = null;
        try{
            conn = ConnecDB.getConnection();
            stmt = conn.prepareCall("{call find_student_by_ID(?)}");
            stmt.setInt(1,StudentID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                students = new Students();
                students.setID(rs.getInt("ID"));
                students.setName(rs.getString("Name"));
                students.setAge(rs.getInt("Age"));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnecDB.closeConnection(conn);
        }
        return students;
    }

    public static boolean updateInfor(Students students){
        Connection conn = null;
        CallableStatement stmt = null;
        try{
            conn = ConnecDB.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall("{call update_student(?,?,?)}");
            stmt.setInt(1,students.getID());
            stmt.setString(2,students.getName());
            stmt.setInt(3,students.getAge());
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

    public static List<Students> findAll(){
        Connection conn = null;
        CallableStatement stmt = null;
        List<Students> students = new ArrayList<>();
        try{
            conn = ConnecDB.getConnection();
            stmt = conn.prepareCall("{call FindAll()}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Students students1 = new Students();
                students1.setID(rs.getInt("ID"));
                students1.setName(rs.getString("Name"));
                students1.setAge(rs.getInt("Age"));
                students.add(students1);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnecDB.closeConnection(conn);
        }
        return students;
    }

    public static boolean delStudent(int delAge){
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnecDB.getConnection();
            stmt = conn.prepareCall("{call delete_students_by_age(?)}");
            stmt.setInt(1,delAge);
            stmt.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnecDB.closeConnection(conn);
        }
        return false;
    }
}
