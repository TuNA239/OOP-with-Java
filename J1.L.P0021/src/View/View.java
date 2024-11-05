/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author TUF GAMING
 */
import Model.Student;
import java.util.List;
import java.util.Scanner;

public class View {
    private final Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
    }

    public int getMainMenuChoice() {
        System.out.print("Choose an option: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public Student getStudentDetails() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter semester: ");
        String semester = scanner.nextLine();
        System.out.print("Enter course name (Java, .Net, C/C++): ");
        String courseName = scanner.nextLine();
        return new Student(id, name, semester, courseName);
    }

    public String getStudentNameToSearch() {
        System.out.print("Enter student name (or part of it) to search: ");
        return scanner.nextLine();
    }

    public String getStudentIdForUpdateOrDelete() {
        System.out.print("Enter student ID to update/delete: ");
        return scanner.nextLine();
    }

    public String getUpdateOrDeleteChoice() {
        System.out.print("Do you want to update (U) or delete (D) the student? ");
        return scanner.nextLine();
    }

    public void displayStudents(List<Student> students) {
        students.forEach(System.out::println);
    }

    public void displayReport(List<String> report) {
        report.forEach(System.out::println);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
