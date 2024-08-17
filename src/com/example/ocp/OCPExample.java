package com.example.ocp;

//We need to change the below class behaviour when new shape is added
class ShapeDrawer {
    public void drawShape(String shapeType) {
        if (shapeType.equals("circle")) {
            System.out.println("Drawing a circle");
            //logic
        } else if (shapeType.equals("square")) {
            System.out.println("Drawing a square");
            //logic
        }
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
        //logic
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
        //logic
    }
}

//Adding Triangle on basis of OCP

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Triangle");
        //logic
    }
}



public class OCPExample {
    public static void main(String[] args) {
        //OCP is not followed
        ShapeDrawer drawer = new ShapeDrawer();
        System.out.println("OCP is not followed");
        drawer.drawShape("circle");
        drawer.drawShape("square");
        //With OCP
        System.out.println("With OCP");
        Shape circle = new Circle();
        Shape square = new Square();
        circle.draw();
        square.draw();
        //Now adding a triangle will extend the class without modifying it
        Shape triangle = new Triangle();
        triangle.draw();
    }
}
