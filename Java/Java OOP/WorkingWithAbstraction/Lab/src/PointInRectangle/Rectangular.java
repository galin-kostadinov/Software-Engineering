package PointInRectangle;

public class Rectangular {
    private Point bottomLeft;
    private Point topRight;

    public Rectangular(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        boolean checkX = point.getCoordinateX() >= this.bottomLeft.getCoordinateX() && point.getCoordinateX() <= this.topRight.getCoordinateX();
        boolean checkY = point.getCoordinateY() >= this.bottomLeft.getCoordinateY() && point.getCoordinateY() <= this.topRight.getCoordinateY();

        return checkX && checkY;
    }
}
