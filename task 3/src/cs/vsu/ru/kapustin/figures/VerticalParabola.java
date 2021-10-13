package cs.vsu.ru.kapustin.figures;

public class VerticalParabola {
    double x0;
    double y0;
    double a;

    public VerticalParabola(int x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean isPointInsideParabola(double x, double y) {
        if (a > 0) {
            return y > a * Math.pow(x - x0, 2) + y0;
        } else {
            return y < a * Math.pow(x - x0, 2) + y0;
        }
    }
}
