package cs.vsu.ru.kapustin;

import cs.vsu.ru.kapustin.figures.*;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static final Line L1 = new Line (0, -1, 4);
    public static final VerticalParabola P1 = new VerticalParabola(3, 2, 0.125);
    public static final VerticalParabola P2 = new VerticalParabola(-4, 2, -0.25);
    public static final VerticalParabola P3 = new VerticalParabola(5, 4, -0.125);
    public static final Circle C1 = new Circle(-2, 0, 4);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Test.getColor();

        double x = readNumber("x");
        double y = readNumber("y");

        printColorForPoint(x, y);
    }

    private static double readNumber(String coordinateType) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter value " + coordinateType + ": ");
        double num;

        while (!scn.hasNextDouble()) {
            System.out.print("Invalid value! Please, try again: ");
            scn.next();
        }
        num = scn.nextDouble();

        if (num > 10 || num < -10) {
            System.out.println("Invalid value! Modulo number must be less than 10!");
            System.out.println("Please, try again...");
            if (coordinateType.equals("x")) {
                return readNumber("x");
            } else {
                return readNumber("y");
            }
        }

        return num;
    }

    public static SimpleColor getColor(double x, double y) {
        if (P1.isPointInsideParabola(x, y) && P3.isPointInsideParabola(x, y)) {
            return SimpleColor.YELLOW;
        }
        if (C1.isPointInsideCircle(x, y) && L1.isPointAboveLine(x, y) && !P1.isPointInsideParabola(x, y) &&
                !P2.isPointInsideParabola(x, y) && !P3.isPointInsideParabola(x, y))  {
            return SimpleColor.GREEN;
        }
        if (x < 2 && !L1.isPointAboveLine(x, y) && !P1.isPointInsideParabola(x, y) && !P3.isPointInsideParabola(x, y)) {
            return SimpleColor.YELLOW;
        }
        if (C1.isPointInsideCircle(x, y) && !L1.isPointAboveLine(x, y) && P2.isPointInsideParabola(x, y)) {
            return SimpleColor.GREEN;
        }
        if (C1.isPointInsideCircle(x, y) && P1.isPointInsideParabola(x, y)) {
            return SimpleColor.GRAY;
        }
        if (P2.isPointInsideParabola(x, y) && !C1.isPointInsideCircle(x, y) && !P3.isPointInsideParabola(x, y)) {
            return SimpleColor.BLUE;
        }
        if (P3.isPointInsideParabola(x, y) && L1.isPointAboveLine(x, y) && !C1.isPointInsideCircle(x, y)) {
            return SimpleColor.ORANGE;
        }
        if (C1.isPointInsideCircle(x, y) && !L1.isPointAboveLine(x, y) && P3.isPointInsideParabola(x, y) &&
                !P2.isPointInsideParabola(x, y)) {
            return SimpleColor.GRAY;
        }
        if (P3.isPointInsideParabola(x, y) && C1.isPointInsideCircle(x, y) && L1.isPointAboveLine(x, y) &&
                P2.isPointInsideParabola(x, y)) {
            return SimpleColor.BLUE;
        }
        if (L1.isPointAboveLine(x, y) && C1.isPointInsideCircle(x, y) && !P2.isPointInsideParabola(x, y) &&
                P3.isPointInsideParabola(x, y)) {
            return SimpleColor.ORANGE;
        }
        if (C1.isPointInsideCircle(x, y) && P2.isPointInsideParabola(x, y) && !P3.isPointInsideParabola(x, y)) {
            return SimpleColor.GRAY;
        }
        if (P3.isPointInsideParabola(x, y) && !P1.isPointInsideParabola(x, y) && !P2.isPointInsideParabola(x, y) &&
                !C1.isPointInsideCircle(x, y)) {
            return SimpleColor.BLUE;
        }
        if (P1.isPointInsideParabola(x, y) && !C1.isPointInsideCircle(x, y) && !P3.isPointInsideParabola(x, y)) {
            return SimpleColor.ORANGE;
        }
        if (!L1.isPointAboveLine(x, y) && P2.isPointInsideParabola(x, y) && !C1.isPointInsideCircle(x, y)) {
            return SimpleColor.GRAY;
        }
        if (!L1.isPointAboveLine(x, y) && !P1.isPointInsideParabola(x, y) && !P3.isPointInsideParabola(x, y) && x > 4) {
            return SimpleColor.ORANGE;
        }
        return SimpleColor.WHITE;
    }

    public static void printColorForPoint(double x, double y) {
        System.out.printf("(%s, %s) -> %s\n", x, y, getColor(x, y));
    }
}
