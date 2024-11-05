/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentclassification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author TUF GAMING
 */
public class StudentClassification {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("====== Management Student Program ======");
        List<Student> listStudent = new ArrayList<>();

        //Get student data
        listStudent = getStudentData();

        //Get student type statistic
        HashMap<String, Double> statistic = getPercentTypeStudent(listStudent);

        //Display result
        displayResult(listStudent, statistic);
    }

    private static String inputName() {
        Scanner sc = new Scanner(System.in);
        String regexName = "[A-Za-z ]+";
        //Loop until input is valid
        while (true) {
            System.out.print("Name: ");
            String name = sc.nextLine();
            //Check inputted name match with condition
            if (name.matches(regexName)) {
                return name;
            } else {
                System.out.println("Name is invalid. Please input again !!!");
            }
        }

    }

    private static String inputClass() {
        Scanner sc = new Scanner(System.in);
        String regexClass = "[0-9A-Za-z]+";
        //Loop until input is valid
        while (true) {
            System.out.print("Classes: ");
            String classes = sc.nextLine();
            //Check inputted name match with condition
            if (classes.matches(regexClass)) {
                return classes;
            } else {
                System.out.println("Classes is invalid. Please input again !!!");
            }
        }

    }

    private static double inputMark(String subject) {
        Scanner sc = new Scanner(System.in);

        //Loop until input is valid
        while (true) {
            
            try {
                System.out.print(subject + ": ");
                double mark = Double.parseDouble(sc.nextLine());
                //Check number in range [0-10]
                if (mark >= 0 && mark <= 10) {
                    return mark;
                } else {
                    System.out.println("Mark must be in range [0-10]. Please input again !!");
                }

            } catch (Exception e) {
                System.out.println("Mark is invalid. Please input number in range [0-10] !!");
            }
        }
    }

    private static boolean checkInputYesNo() {
        Scanner sc = new Scanner(System.in);
        //Loop until user exit
        while (true) {
            System.out.print("Do you want to enter more student information?(Y/N): ");
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
        }
    }

    private static List<Student> getStudentData() {
        List<Student> listStudent = new ArrayList<>();
        boolean flag = true;

        //Loop until user exit
        while (flag) {
            String name = inputName();
            String classes = inputClass();
            double math = inputMark("Math");
            double chemistry = inputMark("Chemistry");
            double physics = inputMark("Physics");

            Student std = createStudent(name, classes, math, chemistry, physics);
            listStudent.add(std);
            flag = checkInputYesNo();
        }
        return listStudent;
    }

    private static Student createStudent(String name, String className, double math, double chemistry, double physics) {
        double avg = (math + physics + chemistry) / 3;
        String type;

        //Check avg
        if (avg > 7.5) {
            type = "A";
        } else if (avg >= 6 && avg <= 7.5) {
            type = "B";
        } else if (avg >= 4 && avg < 6) {
            type = "C";
        } else {
            type = "D";
        }

        return new Student(name, className, math, chemistry, physics, avg, type);
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

    public static void displayResult(List<Student> students, HashMap<String, Double> statistics) {
        //Loop through each element of list
        for (Student std : students) {
            System.out.println("------ Student" + students.indexOf(std) + 1 + " Info ------");
            System.out.println("Name: " + std.getName());
            System.out.println("Classes: " + std.getClassName());
            System.out.println("AVG: " + std.getAverage());
            System.out.println("Type: " + std.getType());
        }
        
        System.out.println("-------Classification Info-------");
        //Loop throguh each element of hash map
        for (String type: statistics.keySet()) {
            System.out.println("Type " + type + ": " + statistics.get(type) + "%");
        }
    }

    
    
}
