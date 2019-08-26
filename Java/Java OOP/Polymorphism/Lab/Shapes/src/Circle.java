public class Circle extends Shape {
    private double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.radius);
    }

    @Override
    public void calculateArea() {
        super.setArea(Math.PI * this.radius * this.radius);
    }

    public final double getRadius() {
        return radius;
    }
}
