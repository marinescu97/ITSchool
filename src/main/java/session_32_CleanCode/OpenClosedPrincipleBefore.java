package session_32_CleanCode;

public class OpenClosedPrincipleBefore {
}

class AreaCalculator {
    double calculateArea(Object shape) {
        if (shape instanceof Circle) {
            CircleB circle = (CircleB) shape;
            return Math.PI * circle.radius * circle.radius;
        }
        if (shape instanceof RectangleB) {
            RectangleB rectangle = (RectangleB) shape;
            return rectangle.lenght * rectangle.width;
        }

        return 0;
    }
}

class CircleB {
    double radius;
}

class RectangleB {
    double lenght, width;
}
