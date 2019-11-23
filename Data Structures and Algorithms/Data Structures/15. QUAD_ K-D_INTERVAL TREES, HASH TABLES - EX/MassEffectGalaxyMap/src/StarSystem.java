public class StarSystem implements Comparable<StarSystem>{
    private String name;
    private int x;
    private int y;

    public StarSystem(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public double getDistance(StarSystem other) {
        return Math.sqrt(Math.pow(other.getX() - this.x, 2) + Math.pow(other.getY() - this.y, 2));
    }

    public boolean isInto(int x1, int y1, int x2, int y2) {
        return this.x >= x1 && this.x <= x2 && this.y >= y1 && this.y <= y2;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.getName(), this.getX(), this.getY());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != getClass()) return false;
        var that = (StarSystem) obj;
        return this.x == that.getX() && this.y == getY();
    }

    int getHashCode() {
        return 31 * this.getX() + this.getY();
    }

    @Override
    public int compareTo(StarSystem other) {
        if (this.x < other.getX()) return -1;
        if (this.x > other.getX()) return +1;
        if (this.y < other.getY()) return -1;
        if (this.y > other.getY()) return +1;

        return 0;
    }
}
