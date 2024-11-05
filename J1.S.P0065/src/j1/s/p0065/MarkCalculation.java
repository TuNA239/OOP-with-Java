/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0065;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author TUF GAMING
 */
public class MarkCalculation {

    public static Student createStudent(String name, String className, double math, double chemistry, double physics) {
        return new Student(name, className, math, chemistry, physics);
    }

    public static List<Student> averageStudent(List<Student> students) {
        for (Student student : students) {
            student.classifyType();
        }
        return students;
    }

    public static HashMap<String, Double> getPercentTypeStudent(List<Student> students) {
        int totalStudents = students.size();
        HashMap<String, Integer> typeCount = new HashMap<>();
        typeCount.put("A", 0);
        typeCount.put("B", 0);
        typeCount.put("C", 0);
        typeCount.put("D", 0);

        for (Student student : students) {
            String type = student.getType();
            typeCount.put(type, typeCount.get(type) + 1);
        }

        HashMap<String, Double> typePercentage = new HashMap<>();
        for (String type : typeCount.keySet()) {
            typePercentage.put(type, (typeCount.get(type) * 100.0) / totalStudents);
        }

        return typePercentage;
    }
}
