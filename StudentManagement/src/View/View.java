/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Student;
import Validation.Validate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author TUF GAMING
 */
public class View {

    Validate val = new Validate();

    public void displayMenu() {
        System.out.println("============== STUDENT MANAGEMENT ==============");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
    }

    public void displayStudentInfor(Student s) {
        //Loop through each enrollment of student
        for (Map.Entry<String, List<String>> en : s.getEnrollment().entrySet()) {
            //Loop through each element of list
            for (String course : en.getValue()) {
                System.out.printf("%-15s\t | %-8s | %-8s", s.getName(), en.getKey(), course);
                System.out.println("");
            }
        }
    }

    public void displayListStudent(List<Student> listStudent) {
        System.out.println("============== STUDENT LIST ==============");
        System.out.printf("%-15s\t | %-8s | %-8s", "Name", "Semester", "Course");
        System.out.println("\n==========================================");

        //Loop through each element of list student
        for (Student s : listStudent) {
            displayStudentInfor(s);
        }
    }

    public void displayReport(List<Student> listStudent) {
        //Check list student is empty
        if(listStudent.isEmpty()){
            System.out.println("There are no student!!!");
        }else{
            HashMap<Integer, HashMap<String, Integer>> recorder = new HashMap<>();

            // Loop through each element of list student
            for (Student s : listStudent) {
                HashMap<String, Integer> counter = new HashMap<>();

                // Loop through each element of enrollment
                for (Map.Entry<String, List<String>> entry : s.getEnrollment().entrySet()) {
                    // Loop through each course of enrollment
                    for (String course : entry.getValue()) {
                        counter.put(course, counter.getOrDefault(course, 0) + 1);
                    }
                }
                recorder.put(s.getId(), counter);
            }

            // Loop through each element of recorder
            for (Map.Entry<Integer, HashMap<String, Integer>> entry : recorder.entrySet()) {
                try {
                    Student s = val.getStudentById(listStudent, entry.getKey());
                    if (s != null) {
                        // Loop through each element of counter
                        for (Map.Entry<String, Integer> courseEntry : entry.getValue().entrySet()) {
                            System.out.printf("%-15s\t | %-8s | %-3d\n", s.getName(), courseEntry.getKey(), courseEntry.getValue());
                        }
                    }
                } catch (NullPointerException e) {
                    System.out.println("Student with ID " + entry.getKey() + " not found.");
                }
            }
        }
        
        
    }

}
