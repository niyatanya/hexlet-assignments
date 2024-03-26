package exercise;

// BEGIN
public class Cottage implements Home {
    double area;
    int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        return floorCount
               + " этажный коттедж площадью "
               + area
               + " метров";
    }

    public double getArea() {
        return area;
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
