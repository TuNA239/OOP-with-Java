/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Student;
import Model.StudentComparator;
import Validation.Validate;
import View.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author TUF GAMING
 */
public class Controller {

    private List<Student> listStudent = new ArrayList<>();
    View v = new View();
    Validate val = new Validate();

    public void start() {
        Scanner sc = new Scanner(System.in);

        //Loop until user exit
        while (true) {
            v.displayMenu();
            int choice = val.getPositiveInteger("Enter your choice: ", "Input is invalid. Please enter a positive number!!");
            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    findAndSort();
                    break;
                case 3:
                    UpdateOrDelete();
                    break;
                case 4:
                    v.displayReport(listStudent);
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter again!!");

            }

        }

    }

    private void createStudent() {
        boolean flag = true;
        int count = 1;
        //Loop until user exit
        while (flag) {
            System.out.println("---------- Student " + count + " ----------");

            int id = val.inputStudentId(listStudent);
            String name = val.getInputString("Student name: ", "Name is invalid. Please enter again!!");
            String semester = val.getInputSemester();
            String course = val.getInputCourse();
            List<String> listCourse = new ArrayList<>();
            listCourse.add(course);
            HashMap<String, List<String>> enrollment = new HashMap<>();

            enrollment.put(semester, listCourse);
            Student s = new Student(id, name, enrollment);
            listStudent.add(s);
            count++;

            //Check count is greter 10
            if (count > 2) {
                flag = val.checkInputYesNo("Do you want to continue? (Y/N): ");
            }
        }

        v.displayListStudent(listStudent);
    }

    private void findAndSort() {
        //Check list student is empty
        if (listStudent.isEmpty()) {
            System.out.println("There are no student to find!!!");
        } else {
            String name = val.getInputString("Name of Student: ", "Input is invalid. Pleasae enter again!!");
            List<Student> matchedStudent = new ArrayList<>();
            StudentComparator comparator = new StudentComparator();
            //Loop through each element of list student
            for (Student s : listStudent) {
                //Check name is contained
                if (s.getName().contains(name)) {
                    matchedStudent.add(s);
                }
            }
            //Check list is empty
            if (matchedStudent.isEmpty()) {
                System.out.println("No students is found with given name!! ");
            } else {
                Collections.sort(listStudent, comparator);
                v.displayListStudent(matchedStudent);
            }
        }

    }

    private void UpdateOrDelete() {
        int id = val.getPositiveInteger("Student ID: ", "Input is invalid. Please enter a positive integer!!");

        try {
            Student s = val.getStudentById(listStudent, id);
            System.out.println("----------- Current Detail ----------");
            v.displayStudentInfor(s);
            boolean check = val.checkInputUpdateDelete("Do you want to update (U) or delete (D) student: ");
            //Check is true
            if (check) {
                String newName = val.getInputString("Enter new name (leave blank to keep current): ", "");
                String newSemester = val.getInputSemester();
                String newCourse = val.getInputCourse();

                // Cập nhật tên nếu có thay đổi
                if (!newName.isEmpty()) {
                    s.setName(newName);
                }

                // Cập nhật hoặc thêm thông tin khóa học
                if (!newSemester.isEmpty() && !newCourse.isEmpty()) {
                    List<String> courses = s.getEnrollment().getOrDefault(newSemester, new ArrayList<>());
                    if (!courses.contains(newCourse)) {
                        courses.add(newCourse);
                    }
                    s.getEnrollment().put(newSemester, courses);
                }

                System.out.println("Updated student details:");
                v.displayStudentInfor(s);
            } else if (!check) {
                listStudent.remove(s);
                System.out.println("Delete successfully!!!");
                v.displayListStudent(listStudent);
            }

        } catch (NullPointerException e) {
            System.out.println("Student not found with given ID!!");
        }
    }
}
