package org.s;

public class Student {
    private int id;
    private String name;
    private int rollno;
    private int age;
    private String classs;
     public Student(int id,String name,int rollno,int age,String classs){
        this.id = id;
        this.age = age;
        this.classs=classs;
        this.name = name;
        this.rollno = rollno;
    }
    public String getName(){
         return name;
    }

    public int getId() {
        return id;
    }
    public int getRollno() {
        return rollno;
    }
    public int getAge() {
        return age;
    }
    public String getClasss() {
        return classs;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    public void setName(String name) {
        this.name =name ;
    }
    public void setAge(int age ) {
        this.age = age;
    }
    public void setClasss(String classs) {
        this.classs = classs;
    }
    @Override
    public String toString() {
        return "Student{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", Rollno=" + rollno +
                ", Age=" + age +
                ", Classs='" + classs + '\'' +
                '}';
    }

}
