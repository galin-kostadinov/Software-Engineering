package classBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        validateSide(length, "Length");
        this.length = length;
    }

    private void validateSide(double value, String sideName) {
        if (value <= 0) {
            throw new IllegalArgumentException(sideName + " cannot be zero or negative.");
        }
    }

    private void setWidth(double width) {
        validateSide(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        validateSide(height, "Height");
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return 2 * length * width + this.calculateLateralSurfaceArea();
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.height * (length + width);
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Surface Area - %.2f", calculateSurfaceArea()))
                .append(System.lineSeparator())
                .append(String.format("Lateral Surface Area - %.2f", calculateLateralSurfaceArea()))
                .append(System.lineSeparator())
                .append(String.format("Volume - %.2f", calculateVolume()));

        return sb.toString();
    }
}
