public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(2 * (this.height + this.width));
    }

    @Override
    public void calculateArea() {
        super.setPerimeter(this.height * this.width);
    }

    public final Double getHeight() {
        return height;
    }

    public final Double getWidth() {
        return width;
    }

}
