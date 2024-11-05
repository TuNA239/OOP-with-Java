/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentsorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author TUF GAMING
 */
public class StudentSorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        System.out.println("====== Collection Sort Program ======");
        //Step 1: Input data
        InputStudentInfor(students);
        //Step 2: Sort name of student from A to Z
        SortStudent(students);
        //Step 3: Display the student information
        Display(students);
    }

    private static boolean checkInputYesNo() {
        Scanner sc = new Scanner(System.in);
        //Loop until user exit
        while (true) {
            String input = sc.nextLine();
            //Check length of input equal 1
            if (input.length() == 1) {
                char inputChar = input.charAt(0);
                //Check input is 'y' or 'Y'
                if (inputChar == 'y' || inputChar == 'Y') {
                    return true;
                }
                //Check input is 'n' or 'N'
                if (inputChar == 'n' || inputChar == 'N') {
                    return false;
                }
            }
            System.out.print("Do you want to enter more student information?(Y/N):");
        }
    }

    private static float InputMark() {
        Scanner sc = new Scanner(System.in);
        //Loop until input is valid
        while (true) {
            try {
                float mark = Float.parseFloat(sc.nextLine());
                //Check mark is >= 0 and <= 100
                if (mark >= 0 && mark <= 100) {
                    return mark;
                } else {
                    System.out.println("Please input mark in range [0-100]");
                }
            } catch (Exception e) {
                System.out.println("Input is invalid. Please input again!!");
            }
        }
    }

    private static String checkInputString() {
        Scanner sc = new Scanner(System.in);
        //Loop until input is valid
        while (true) {
            String input = sc.nextLine();
            //Check length of input equal 0
            if (input.length() == 0) {
                System.out.println("Input cannot be empty !!");
            } else {
                return input;
            }
        }
    }

    private static void AddStudent(List<Student> students) {
    Scanner sc = new Scanner(System.in);
    String regexName = "[A-Za-z ]+"; // Allow multiple names
    String regexClass = "[0-9A-Za-z]+$"; // Only 1 word allowed
    System.out.println("Please input student information ");
    String name;
    String classes;
    while (true) {
        try {
            System.out.print("Enter name: ");
            name = sc.nextLine();
            if (name.matches(regexName)) {
                break;
            } else {
                System.out.println("Name is invalid");
            }
        } catch (Exception e) {
            System.out.println("Name is invalid");
        }
    }

    while (true) {
        try {
            System.out.print("Enter classes: ");
            classes = sc.nextLine();
            if (classes.matches(regexClass)) {
                break;
            } else {
                System.out.println("Classes is invalid");
            }
        } catch (Exception e) {
            System.out.println("Classes is invalid");
        }
    }
    System.out.print("Mark: ");
    float mark = InputMark(); // Assuming InputMark() is a separate method
    students.add(new Student(name, mark, classes));
}

    private static void InputStudentInfor(List<Student> students) {
        AddStudent(students);
        //Loop until user exit
        while (true) {
            System.out.print("Do you want to enter more student information?(Y/N): ");
            if (checkInputYesNo()) {
                AddStudent(students);
            } else {
                break;
            }
        }
    }

    private static void SortStudent(List<Student> students) {
        //Check list is empty
        if (students.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        Collections.sort(students, new StudentComparator());
    }

    private static void Display(List<Student> students) {
        //Loop from the first element to last element of list
        for (int i = 0; i < students.size(); i++) {
            System.out.println("--------Student " + (i + 1) + "--------");
            System.out.println("Name: " + students.get(i).getName());
            System.out.println("Classes: " + students.get(i).getClasses());
            System.out.println("Mark: " + students.get(i).getMark());
        }
    }

}
