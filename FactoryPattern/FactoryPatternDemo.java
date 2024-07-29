public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();  // Drawing a Circle

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();  // Drawing a Rectangle

        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();  // Drawing a Square
    }
}
