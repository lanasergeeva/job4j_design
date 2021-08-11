package ru.job4j.ood.ocp;

public class ExampleOCPCalculator {

    private static class Rectangle {
        public double length;
        public double width;
    }

    private static class Circle {
        public double radius;
    }

    private static class AreaCalculator {
        public double calculateRectangleArea(Rectangle rectangle) {
            return rectangle.length * rectangle.width;
        }

        public double calculateCircleArea(Circle circle) {
            return (22 / 7) * circle.radius * circle.radius;
        }
    }
}
