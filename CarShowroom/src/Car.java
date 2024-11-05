/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author TUF GAMING
 */
enum Car {
    AUDI(new int[]{5500, 3000, 4500}, new Color[]{Color.WHITE, Color.YELLOW, Color.ORANGE}, new Day[]{Day.FRIDAY, Day.SUNDAY, Day.MONDAY}),
    MERCEDES(new int[]{5000, 6000, 8500}, new Color[]{Color.GREEN, Color.BLUE, Color.PURPLE}, new Day[]{Day.TUESDAY, Day.SATURDAY, Day.WEDNESDAY}),
    BMW(new int[]{2500, 3000, 3500}, new Color[]{Color.PINK, Color.RED, Color.BROWN}, new Day[]{Day.MONDAY, Day.SUNDAY, Day.THURSDAY});

    private final int[] prices;
    private final Color[] colors;
    private final Day[] days;

    Car(int[] prices, Color[] colors, Day[] days) {
        this.prices = prices;
        this.colors = colors;
        this.days = days;
    }

    public int[] getPrices() {
        return prices;
    }

    public Color[] getColors() {
        return colors;
    }

    public Day[] getDaySells() {
        return days;
    }

    public static Car getCar(String car) {
        try {
            return Car.valueOf(car.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}

