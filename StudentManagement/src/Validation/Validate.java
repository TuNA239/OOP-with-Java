/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

import Model.Student;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author TUF GAMING
 */
public class Validate {

    public Student getStudentById(List<Student> listStudent, int id) {
        //Loop through each element of list
        for (Student s : listStudent) {
            //Check id is match
            if (id == s.getId()) {
                return s;
            }
        }
        return null;
    }

    public int getPositiveInteger(String msg, String errMsg) {
        Scanner sc = new Scanner(System.in);
        //Loop until input is valid
        while (true) {
            try {
                System.out.print(msg);
                int input = Integer.parseInt(sc.nextLine());
                //Check number is not positive
                if (input <= 0) {
                    System.out.println(errMsg);
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                System.out.println(errMsg);
            }
        }
    }

    public String getInputString(String msg, String errMsg) {
        Scanner sc = new Scanner(System.in);
        String regex = "[A-Za-z ]+";
        //Loop until input is valid
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            //Check input is match with regex
            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println(errMsg);
            }
        }
    }

    public boolean checkInputYesNo(String msg) {
        Scanner sc = new Scanner(System.in);

        //Loop until input is valid
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            //Check input is Y or y
            if (input.trim().contentEquals("Y") || input.trim().contentEquals("y")) {
                return true;
            } //Check input is N or n
            else if (input.trim().contentEquals("N") || input.trim().contentEquals("n")) {
                return false;
            } else {
                System.out.println("Input is invalid. Please enter Y/y or N/n");
            }
        }
    }

    public boolean checkInputUpdateDelete(String msg) {
        Scanner sc = new Scanner(System.in);

        //Loop until input is valid
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            //Check input is U or u
            if (input.trim().contentEquals("U") || input.trim().contentEquals("u")) {
                return true;
            } //Check input is D or d
            else if (input.trim().contentEquals("D") || input.trim().contentEquals("d")) {
                return false;
            } else {
                System.out.println("Input is invalid. Please enter U/u or D/n");
            }
        }
    }

    public int inputStudentId(List<Student> listStudent) {
        Scanner sc = new Scanner(System.in);

        //Loop until input is valid
        while (true) {
            System.out.print("Student ID: ");
            boolean isExisted = false;

            try {
                int input = Integer.parseInt(sc.nextLine());
                //Check input is not positive
                if (input <= 0) {
                    System.out.println("ID is invalid. Please enter a positive integer!!");
                } else {
                    //Loop through each element of list student
                    for (Student s : listStudent) {
                        //Check id is duplicate
                        if (input == s.getId()) {
                            isExisted = true;
                            System.out.println("ID is existed. Please enter another ID!!");
                            break;
                        }
                    }
                    //Chec isExisted is false
                    if (!isExisted) {
                        return input;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("ID is invalid. Please enter a positive integer!!");
            }
        }
    }

    public String getInputSemester() {
        Scanner sc = new Scanner(System.in);
        //Loop until input is valid
        while (true) {
            System.out.print("Semester: ");
            String input = sc.nextLine();
            //Check input is valid
            if (input.trim().toUpperCase().contentEquals("SPRING")) {
                return "Spring";
            }else if(input.trim().toUpperCase().contentEquals("SUMMER")){
                return "Summer";
            } else if(input.trim().toUpperCase().contentEquals("FALL")){
                return "Fall";
            }
            else {
                System.out.println("Semester is invalid. Please enter again (Spring|Summer|Fall)!!");
            }
        }
    }

    public String getInputCourse() {
        Scanner sc = new Scanner(System.in);
        //Loop until input is valid
        while (true) {
            System.out.print("Course: ");
            String input = sc.nextLine();
            //Check input is valid
            if (input.trim().toUpperCase().contentEquals("JAVA")) {
                return "Java";
            }else if(input.trim().toUpperCase().contentEquals(".NET")){
                return ".Net";
            } else if(input.trim().toUpperCase().contentEquals("C/C++")){
                return "C/C++";
            }
            else {
                System.out.println("Course is invalid. Please enter again (Java|.NET|C/C++)!!");
            }
        }
    }
}
