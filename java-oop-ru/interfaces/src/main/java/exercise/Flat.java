package exercise;

// BEGIN
import java.lang.Override;

public class Flat implements Home {
    double area;
    double balconyArea;
    int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public String toString() {
        return "Квартира площадью "
                + getArea()
                + " метров на "
                + floor
                + " этаже";
    }

    public int compareTo(Home another) {
        if (this.getArea() == another.getArea()) {
            return 0;
        } else if (this.getArea() > another.getArea()) {
            return 1;
        }
        return -1;
    }
}
// END
