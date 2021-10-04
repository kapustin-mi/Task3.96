package cs.vsu.ru.kapustin;

import static cs.vsu.ru.kapustin.Main.printColorForPoint;

class Test {

    @org.junit.jupiter.api.Test
    public static void getColor() {
        printColorForPoint(-8, 2); //white
        printColorForPoint(-7, -1); //blue
        printColorForPoint(-2, -1.5); //gray
        printColorForPoint(-1, -0.1); //green
        printColorForPoint(-1, -2); //blue
        printColorForPoint(0, -6); // gray
        printColorForPoint(-1, -4); //orange
        printColorForPoint(0, 0); //orange
        printColorForPoint(0, -3); //green
        printColorForPoint(0, 3.3); //gray
        printColorForPoint(1, 4); //orange
        printColorForPoint(1, 0); //gray
        printColorForPoint(1.1, 2.2); //yellow
        printColorForPoint(3, -1); //blue
        printColorForPoint(10, 2); //orange
        printColorForPoint(3, 3); //yellow
        System.out.println("======================");
    }
}