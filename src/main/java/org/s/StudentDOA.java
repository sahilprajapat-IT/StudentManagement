package org.s;

import java.sql.*;
import java.util.Scanner;

public class StudentDOA {

    public static void addStudent(Student s) throws SQLException {
        String qry = "Insert into studentdb.students(id,name,roll_number,age,class)  values(?,?,?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(qry)){
            pstmt.setInt(1,s.getId());
            pstmt.setString(2, s.getName());
            pstmt.setInt(3, s.getRollno());
            pstmt.setInt(4, s.getAge());
            pstmt.setString(5, s.getClasss());


            int rowsInserted = pstmt.executeUpdate();
            if(rowsInserted>0){
                System.out.println("Student \"" + s.getName() + "\" (ID: " + s.getId() + ") added successfully.");
            }
        }

    }
    public static void getAllStudents(){
        String qry = "Select * from studentdb.students";
        try(Connection conn =DatabaseConnection.getConnection(); Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(qry);
            while(rs.next()){
                System.out.println("ID->"+rs.getInt(1)+"\nNAME->"+rs.getString(2)+"\nRollNumber->"+rs.getInt(3)+"\nAge->"+rs.getInt(4)+"\nClass->"+rs.getString(5)+"\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateValue() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Id of student you want to change");
        int nid = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new name ");
        String newName = sc.nextLine();
        System.out.println("Enter new Roll Number ");
        int newrollno = sc.nextInt();
        System.out.println("Enter new Age ");
        int newage = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new class ");
        String newclass = sc.nextLine();

        String qry = "update studentdb.students set name=?,roll_number =?,age=?,class=? where id=?";
        try(Connection conn = DatabaseConnection.getConnection();PreparedStatement pstmt = conn.prepareStatement(qry)){
            pstmt.setString(1,newName);
            pstmt.setInt(2,newrollno);
            pstmt.setInt(3,newage);
            pstmt.setString(4,newclass);
            pstmt.setInt(5,nid);
            int rs = pstmt.executeUpdate();
            if(rs>0) {
                System.out.println("Student record updated successfully (ID: " + nid + ").");
            }
            else
                System.out.println("No student found with ID: " + nid + ". Update failed.");
        }
    }
    public static void deletStudent() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Id of student you want to delete : ");
        int nid = sc.nextInt();
        String qry = "Delete from studentdb.students where id =?";
        try(Connection conn = DatabaseConnection.getConnection();PreparedStatement pstmt = conn.prepareStatement(qry)){
            pstmt.setInt(1,nid);
            int rs =pstmt.executeUpdate();
            if(rs>0) {
                System.out.println(rs + " record(s) deleted successfully. ");
            }
            else
                System.out.println("Student Id not found ");
        }

    }
}
