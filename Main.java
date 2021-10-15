package cs.vsu.ru.kapustin;

import cs.vsu.ru.kapustin.figures.*;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Picture p1 = new Picture(new Line(0, -1, 4), new VerticalParabola(3, 2, 0.125),
                new VerticalParabola(-4, 2, -0.25), new VerticalParabola(5, 4, -0.125),
                new Circle(-2, 0, 4));

        checkCorrectness(p1);

        double x = readNumber("x");
        double y = readNumber("y");

        SimpleColor color = p1.getColor(x, y);

        printColorForPoint(x, y, color);
    }

    private static void checkCorrectness(Picture p1) {
        if (ProgramTest.isCorrect(p1)) {
            System.out.println("The test was successful!");
        } else {
            System.out.print("Error! The program did not pass validation!");
            System.exit(1);
        }
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

    public static void printColorForPoint(double x, double y, SimpleColor color) {
        System.out.printf("(%s, %s) -> %s\n", x, y, color);
    }
}
