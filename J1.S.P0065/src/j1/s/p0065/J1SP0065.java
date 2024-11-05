/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package j1.s.p0065;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author TUF GAMING
 */
public class J1SP0065 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Enter Student Information ---");
            System.out.print("Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Class Name: ");
            String className = scanner.nextLine();

            double math = 0, physics = 0, chemistry = 0;
            try {
                System.out.print("Math Mark (1-10): ");
                math = Double.parseDouble(scanner.nextLine());

                System.out.print("Physics Mark (1-10): ");
                physics = Double.parseDouble(scanner.nextLine());

                System.out.print("Chemistry Mark (1-10): ");
                chemistry = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Marks should be numbers.");
                continue;
            }

            // Check if marks are in the valid range
            if (math < 1 || math > 10 || physics < 1 || physics > 10 || chemistry < 1 || chemistry > 10) {
                System.out.println("Marks must be between 1 and 10.");
                continue;
            }

            // Create and add student to the list
            Student student = MarkCalculation.createStudent(name, className, math, chemistry, physics);
            students.add(student);

            // Ask user if they want to input another student
            System.out.print("Do you want to enter another student? (y/n): ");
            String more = scanner.nextLine().toLowerCase();
            if (!more.equals("y")) {
                break;
            }
        }

        // Classify students and get the percentage statistics
        MarkCalculation.averageStudent(students);
        HashMap<String, Double> statistics = MarkCalculation.getPercentTypeStudent(students);

        // Display results
        displayResult(students, statistics);
        scanner.close();
    }

    public static void displayResult(List<Student> students, HashMap<String, Double> statistics) {
        System.out.println("\nStudent Results:");
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Class: " + student.getClassName()
                    + ", Average: " + String.format("%.2f", student.getAverage()) + ", Type: " + student.getType());
        }

        System.out.println("\nStatistics by Type (%):");
        for (String type : statistics.keySet()) {
            System.out.println("Type " + type + ": " + String.format("%.2f", statistics.get(type)) + "%");
        }
    }

}
