/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Student;
import View.View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TUF GAMING
 */
public class Controller {

    List<Student> listStudent = new ArrayList<>();
    View v = new View();

    public void run() {
        while (true) {
            v.displayMainMenu();
            int choice = v.getMainMenuChoice();

            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    findAndSortStudent();
                    break;
                case 3:
                    updateOrDeleteStudent();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    v.showMessage("Exiting program...");
                    return;
                default:
                    v.showMessage("Invalid choice. Please try again.");
            }
        }
    }

    private void createStudent() {
        while (true) {
            Student student = v.getStudentDetails();
            listStudent.addStudent(student);
            v.showMessage("Student added successfully.");

            if (model.getAllStudents().size() >= 10) {
                view.showMessage("Do you want to add more students? (Y/N): ");
                String choice = view.getMainMenuChoice() == 'Y' ? "Y" : "N";
                if (!choice.equalsIgnoreCase("Y")) {
                    break;
                }
            }
        }
    }

    private void findAndSortStudent() {
        String name = v.getStudentNameToSearch();
        List<Student> foundStudents = model.findStudentsByName(name);
        if (foundStudents.isEmpty()) {
            v.showMessage("No student found.");
        } else {
            v.displayStudents(foundStudents);
        }
    }

    private void updateOrDeleteStudent() {
        String id = v.getStudentIdForUpdateOrDelete();
        Student student = model.findStudentById(id);

        if (student == null) {
            v.showMessage("Student not found.");
            return;
        }

        String choice = v.getUpdateOrDeleteChoice();
        if (choice.equalsIgnoreCase("U")) {
            Student updatedStudent = v.getStudentDetails();
            model.updateStudent(student, updatedStudent.getStudentName(), updatedStudent.getSemester(), updatedStudent.getCourseName());
            v.showMessage("Student information updated.");
        } else if (choice.equalsIgnoreCase("D")) {
            model.deleteStudent(student);
            v.showMessage("Student deleted.");
        } else {
            v.showMessage("Invalid choice.");
        }
    }

    private void generateReport() {
        List<String> report = v.generateReport();
        v.displayReport(report);
    }
}
