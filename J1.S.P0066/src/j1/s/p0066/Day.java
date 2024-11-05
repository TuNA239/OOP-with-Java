/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0066;

/**
 *
 * @author TUF GAMING
 */
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public static Day getDay(String day) {
        try {
            return Day.valueOf(day.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
