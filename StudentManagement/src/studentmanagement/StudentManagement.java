/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagement;

import Controller.Controller;
import Model.Student;
import View.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author TUF GAMING
 */
public class StudentManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        List<String> course = new ArrayList<>();
//        List<String> course2 = new ArrayList<>();
//        List<String> course3 = new ArrayList<>();
//        List<String> course4 = new ArrayList<>();
//
//        course.add("Java");
//        course.add("C/C++");
//        course.add(".Net");
//
//        course2.add("Java");
//
//        course3.add(".Net");
//        course3.add("C/C++");
//
//        course4.add("C/C++");
//
//        HashMap<String, List<String>> enrollment = new HashMap<>();
//        HashMap<String, List<String>> enrollment2 = new HashMap<>();
//        HashMap<String, List<String>> enrollment3 = new HashMap<>();
//
//        enrollment.put("Spring", course);
//        enrollment.put("Fall", course4);
//
//        enrollment2.put("Summer", course3);
//        enrollment2.put("Fall", course4);
//
//        enrollment3.put("Spring", course2);
//        enrollment3.put("Fall", course);
//
//        Student s = new Student(0, "Dang Que Anh", enrollment);
//        Student s1 = new Student(1, "Thanh An", enrollment);
//        Student s2 = new Student(2, "An Nguyen", enrollment);
//
//        List<Student> ls = new ArrayList<>();
//        ls.add(s);
//        ls.add(s1);
//        ls.add(s2);
//
//        View v = new View();
////        v.displayListStudent(ls);
//        v.displayReport(ls);

        Controller c = new Controller();
        c.start();


    }

}
