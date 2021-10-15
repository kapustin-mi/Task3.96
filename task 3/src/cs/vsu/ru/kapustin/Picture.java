package cs.vsu.ru.kapustin;

import cs.vsu.ru.kapustin.figures.*;

public class Picture {

    private final Line L1;
    private final VerticalParabola P1;
    private final VerticalParabola P2;
    private final VerticalParabola P3;
    private final Circle C1;

    public Picture (Line L1, VerticalParabola P1, VerticalParabola P2, VerticalParabola P3, Circle C1) {
        this.L1 = L1;
        this.P1 = P1;
        this.P2 = P2;
        this.P3 = P3;
        this.C1 = C1;
    }
    
    public SimpleColor getColor(double x, double y) {
        if (C1.isPointInsideCircle(x, y) && L1.isPointAboveLine(x, y)) {
            if (!P1.isPointInsideParabola(x, y) && !P2.isPointInsideParabola(x, y) && !P3.isPointInsideParabola(x, y)) {
                return SimpleColor.GREEN;
            }
            if (P3.isPointInsideParabola(x, y) && P2.isPointInsideParabola(x, y)) {
                return SimpleColor.BLUE;
            }
            if (!P2.isPointInsideParabola(x, y) && P3.isPointInsideParabola(x, y)) {
                return SimpleColor.ORANGE;
            }
        }
        if (!P2.isPointInsideParabola(x, y) && P3.isPointInsideParabola(x, y)) {
            if (C1.isPointInsideCircle(x, y) && !L1.isPointAboveLine(x, y)) {
                return SimpleColor.GRAY;
            }
            if (!P1.isPointInsideParabola(x, y) && !C1.isPointInsideCircle(x, y)) {
                return SimpleColor.BLUE;
            }
        }
        if (P1.isPointInsideParabola(x, y) && P3.isPointInsideParabola(x, y)) {
            return SimpleColor.YELLOW;
        }
        if (C1.isPointInsideCircle(x, y) && !L1.isPointAboveLine(x, y) && P2.isPointInsideParabola(x, y)) {
            return SimpleColor.GREEN;
        }
        if (x < 2 && !L1.isPointAboveLine(x, y) && !P1.isPointInsideParabola(x, y) && !P3.isPointInsideParabola(x, y)) {
            return SimpleColor.YELLOW;
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
        if (C1.isPointInsideCircle(x, y) && P2.isPointInsideParabola(x, y) && !P3.isPointInsideParabola(x, y)) {
            return SimpleColor.GRAY;
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
}
