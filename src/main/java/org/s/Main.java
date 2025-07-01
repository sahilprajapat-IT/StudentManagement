package org.s;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            // Menu
            System.out.println("\n========= Student Management System =========");
            System.out.println("1. Add Students");
            System.out.println("2. View ALL Students");
            System.out.println("3. Update Student ");
            System.out.println("4. Delete Student ");
            System.out.println("5. Exit");
            System.out.println("Enter your Choice: ");
            int choices = sc.nextInt();
            switch(choices){
                case 1:
                    System.out.println("Enter Id ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter name ");
                    String name  = sc.nextLine();
                    System.out.println("Enter Rollno ");
                    int rollno = sc.nextInt();
                    System.out.println("Enter Age ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter class ");
                    String classs = sc.nextLine();
                    Student s = new Student(id,name,rollno,age,classs);
                    try{
                        StudentDOA.addStudent(s);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    try{
                        StudentDOA.getAllStudents();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    try{
                        StudentDOA.updateValue();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    try{
                        StudentDOA.deletStudent();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    System.out.println("Exiting the program ");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}