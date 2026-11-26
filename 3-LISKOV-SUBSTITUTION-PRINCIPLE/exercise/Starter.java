// LSP Practice Exercise — starter code. Square silently breaks Rectangle's
// contract. Redesign so substituting Square for Rectangle can never surprise
// a caller. See README.md in this folder for the full task and requirements.

interface Shape{
    int getArea();
}

class Rectangle implements Shape{
    private int width;
    private int height;

    public Rectangle(int width, int height){
        if(width < 0 || height < 0)
        {
            throw new IllegalArgumentException("Dimensions must be positive");
        }
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square implements Shape {
    private int side;

    public Square(int side){
        if(side < 0)
        {
            throw new IllegalArgumentException("Side should be positive");
        }

        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}

public class Starter {

    public static void printArea(Shape shape) {
        System.out.println("Area: " + shape.getArea());
    }

    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 10);
        Shape square = new Square(5);

        printArea(rectangle);
        printArea(square);
    }
}
