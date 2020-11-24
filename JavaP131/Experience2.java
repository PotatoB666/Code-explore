abstract class Shape{
    abstract float getArea();
}
class Triangle extends Shape{
    float height;
    float baseWidth;
    @Override
    float getArea() {
        return (float) (0.5 * height * baseWidth);
    }
}
class Square extends Shape{
    float width;

    @Override
    float getArea() {
        return width * width;
    }
}
class Circle extends Shape{
    static final float Pi = 3.14159f;
    float r;
    @Override
    float getArea() {
        return 2 * Pi * r;
    }
}
public class Experience2 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Square square = new Square();
        Circle circle = new Circle();
        triangle.height = 10;
        triangle.baseWidth = 5;
        square.width = 5;
        circle.r = 13;
        System.out.println(triangle.getArea());
        System.out.println(square.getArea());
        System.out.println(circle.getArea());

        Object[] objects = new Object[5];
        objects[0] = triangle;
        objects[1] = square;
        objects[2] = circle;
        objects[3] = 3.1415926535;
        objects[4] = 1.234567f;

        for(int i = 0 ;i<objects.length;i++){
            System.out.println(objects[i].toString());
        }


    }
}
