/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0065;

/**
 *
 * @author TUF GAMING
 */
public class Student {

    private String name;
    private String className;
    private double math;
    private double chemistry;
    private double physics;
    private double average;
    private String type;

    public Student(String name, String className, double math, double chemistry, double physics) {
        this.name = name;
        this.className = className;
        this.math = math;
        this.chemistry = chemistry;
        this.physics = physics;
        this.average = 0;
        this.type = "";
    }

    public double calculateAverage() {
        this.average = (this.math + this.chemistry + this.physics) / 3;
        return this.average;
    }

    public void classifyType() {
        double avg = calculateAverage();
        if (avg > 7.5) {
            this.type = "A";
        } else if (avg >= 6 && avg <= 7.5) {
            this.type = "B";
        } else if (avg >= 4 && avg < 6) {
            this.type = "C";
        } else {
            this.type = "D";
        }
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public double getAverage() {
        return average;
    }

    public String getType() {
        return type;
    }
}
