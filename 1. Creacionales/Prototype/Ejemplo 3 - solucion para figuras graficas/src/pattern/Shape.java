package pattern;

public class Shape implements GraphicPrototype {
    private final String type;
    private final String color;
    private final int x;
    private final int y;

    public Shape(String type, String color, int x, int y) {
        this.type = type;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public Shape copy() { return new Shape(type, color, x, y); }
    public Shape moveTo(int newX, int newY) { return new Shape(type, color, newX, newY); }
    public String describe() { return type + " " + color + " en (" + x + "," + y + ")"; }
}
