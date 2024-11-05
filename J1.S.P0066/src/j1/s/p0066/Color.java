/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0066;

/**
 *
 * @author TUF GAMING
 */
enum Color {
    WHITE, YELLOW, ORANGE, GREEN, BLUE, PURPLE, PINK, RED, BROWN, NO_COLOR;

    public static Color getColor(String color) {
        try {
            return Color.valueOf(color.toUpperCase().replace(" ", "_"));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
