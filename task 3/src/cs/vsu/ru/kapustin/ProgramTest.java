package cs.vsu.ru.kapustin;

import java.util.Objects;

public class ProgramTest {

    static boolean isCorrect(Picture p1) {
        double[] valuesX = {-1, -1, 0, 1, 3, 3, 0, 1.1, 0, -7, -1, -2, 1, 0, 10, -8};
        double[] valuesY = {-0.1, -2, 0, 0, -1, 3, -3, 2.2, 3.3, -1, -4, -1.5, 4, -6, 2, 2};

        SimpleColor[] correctColors = {SimpleColor.GREEN, SimpleColor.BLUE, SimpleColor.ORANGE, SimpleColor.GRAY,
                SimpleColor.BLUE, SimpleColor.YELLOW, SimpleColor.GREEN, SimpleColor.YELLOW, SimpleColor.GRAY,
                SimpleColor.BLUE, SimpleColor.ORANGE, SimpleColor.GRAY, SimpleColor.ORANGE, SimpleColor.GRAY,
                SimpleColor.ORANGE, SimpleColor.WHITE};

        System.out.println("The program is being tested...");
        for (int i = 0; i < 16; i++) {
            System.out.printf("(%s, %s) -> %s, ", valuesX[i], valuesY[i], p1.getColor(valuesX[i], valuesY[i]));
            System.out.printf("correct color -> %s\n", correctColors[i]);

            if (!Objects.equals(p1.getColor(valuesX[i], valuesY[i]), correctColors[i])) {
                return false;
            }
        }
        return true;
    }
}