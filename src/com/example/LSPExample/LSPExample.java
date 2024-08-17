package com.example.LSPExample;

//It violates LSP because Penguins can't fly so it does't require fly method.
//class Bird {
//    public void fly() {
//        System.out.println("I can fly");
//    }
//}
//
//class Penguin extends Bird {
//    @Override
//    public void fly() {
//        throw new UnsupportedOperationException("Penguins can't fly");
//    }
//}
//public class LSPExample {
//    public static void main(String[] args) {
//        Bird bird = new Bird();
//        bird.fly(); // Output: I can fly
//
//        Bird penguin = new Penguin();
//        penguin.fly(); // Throws UnsupportedOperationException
//    }
//}

abstract class Bird {
    public abstract void eat();
}

class FlyingBird extends Bird {
    public void fly() {
        System.out.println("I can fly");
    }

    @Override
    public void eat() {
        System.out.println("I can eat");
    }
}

class NonFlyingBird extends Bird {
    @Override
    public void eat() {
        System.out.println("I can eat");
    }
}

class Sparrow extends FlyingBird {
    // Sparrow inherits fly() and eat() methods
}

class Penguin extends NonFlyingBird {
    // Penguin inherits eat() method, but doesn't have fly() method
}

public class LSPExample {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        sparrow.eat(); // Output: I can eat
        ((FlyingBird) sparrow).fly(); // Output: I can fly

        Bird penguin = new Penguin();
        penguin.eat(); // Output: I can eat
        // No need to call fly(), as it's not supported by NonFlyingBirds
    }
}

