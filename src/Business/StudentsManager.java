package Business;

import Entity.Student;
import Untill.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;

public class StudentsManager {
    public static List<Student> findAll(){
        Connection conn = null;
        CallableStatement stmt = null;
        List<Student> students = new ArrayList<>();
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareCall("{call get_all_students()}");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setStudentID(rs.getInt("student_id"));
                student.setStudentName(rs.getString("full_name"));
                student.setStudentDateOfBirth(rs.getDate("date_of_birth"));
                student.setStudentEmail(rs.getString("email"));
                students.add(student);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return students;
    }

    public static boolean AddStudents(Student student){
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall("{call add_student(?,?,?)}");
            stmt.setString(1,student.getStudentName());
            stmt.setDate(2,new Date(student.getStudentDateOfBirth().getTime()));
            stmt.setString(3,student.getStudentEmail());
            stmt.executeUpdate();
            conn.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return false;
    }

    public static Student FindInforStudent(int inID){
        Connection conn = null;
        CallableStatement stmt = null;
        Student student = null;
        try {
            conn = ConnectionDB.getConnection();
            stmt = conn.prepareCall("{call find_student_by_id(?)}");
            stmt.setInt(1,inID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                student = new Student();
                student.setStudentID(rs.getInt("student_id"));
                student.setStudentName(rs.getString("full_name"));
                student.setStudentDateOfBirth(rs.getDate("date_of_birth"));
                student.setStudentEmail(rs.getString("email"));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return student;
    }

    public static boolean updateInfor(Student student){
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall("{call update_student(?,?,?,?)}");
            stmt.setInt(1,student.getStudentID());
            stmt.setString(2,student.getStudentName());
            stmt.setDate(3,new Date(student.getStudentDateOfBirth().getTime()));
            stmt.setString(4,student.getStudentEmail());
            stmt.executeUpdate();
            conn.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return false;
    }

    public static boolean deleteInfor(Student student){
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareCall("{call delete_student(?)}");
            stmt.setInt(1,student.getStudentID());
            stmt.executeUpdate();
            conn.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn);
        }
        return false;
    }
}
