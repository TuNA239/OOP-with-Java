/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student implements Comparable<Student> {

    private int id;
    private String name;
    private HashMap<String, List<String>> enrollment;

    public Student() {
    }

    public Student(int id, String name, HashMap<String, List<String>> enrollment) {
        this.id = id;
        this.name = name;
        this.enrollment = enrollment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, List<String>> getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(HashMap<String, List<String>> enrollment) {
        this.enrollment = enrollment;
    }

    @Override
    public int compareTo(Student t) {
        return t.name.compareTo(this.name);
    }

}
