/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentclassification;

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

    public Student() {
    }

    public Student(String name, String className, double math, double chemistry, double physics, double average, String type) {
        this.name = name;
        this.className = className;
        this.math = math;
        this.chemistry = chemistry;
        this.physics = physics;
        this.average = average;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getChemistry() {
        return chemistry;
    }

    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    public double getPhysics() {
        return physics;
    }

    public void setPhysics(double physics) {
        this.physics = physics;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
