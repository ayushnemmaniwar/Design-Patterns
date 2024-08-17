interface Pizza {
    int getCost();
}

class Margherita implements Pizza {

    @Override
    public int getCost() {
        return 100;
    }
}

class Farmhouse implements Pizza {

    @Override
    public int getCost() {
        return 120;
    }
}

class Mexican implements Pizza {

    @Override
    public int getCost() {
        return 200;
    }
}

interface PizzaDecorator extends Pizza {

}

// We can directly implement the Pizza interface, but there's a problem.
// If a new method like `removeTopping` is added, we need to override it in every Pizza class (e.g., Mexican, Farmhouse, etc.).
// We can solve this problem by using the PizzaDecorator interface.

class Vegtoppling implements PizzaDecorator {
    Pizza pizza;
    public Vegtoppling(Pizza pizza) {
        this.pizza=pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 20;
    }
}

class Extracheese implements PizzaDecorator {

    Pizza pizza;
    public Extracheese(Pizza pizza) {
        this.pizza=pizza;
    }
    @Override
    public int getCost() {
        return pizza.getCost() + 10;
    }
}

public class DecoratorPattern {
    public static void main(String [] args) {
        Margherita margherita = new Margherita();
        Pizza margheritaAndExtracheese = new Extracheese(margherita);
        Pizza margheritaAndExtracheeseAndVegtoppling = new Vegtoppling(margheritaAndExtracheese);
        System.out.println(margheritaAndExtracheeseAndVegtoppling.getCost());
        System.out.println(margheritaAndExtracheese.getCost());

    }
}
