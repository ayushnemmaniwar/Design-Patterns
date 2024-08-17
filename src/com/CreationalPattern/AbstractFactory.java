package com.CreationalPattern;

interface Door {
    String getDescription();
}
class WoodenDoor implements Door {
    @Override
    public String getDescription() {
        return "Wooden";
    }
}

class GlassDoor implements Door {

    @Override
    public String getDescription() {
        return "Glass";
    }
}
abstract class AbstractFactoryMethod {
    abstract Door createDoor();
}

class WoodenDoorFactory extends AbstractFactoryMethod {

    @Override
    Door createDoor() {
        return new WoodenDoor();
    }
}

class GlassDoorFactory extends AbstractFactoryMethod {

    @Override
    Door createDoor() {
        return new GlassDoor();
    }
}

class AbstractFactoryBuilder {
    public static Door createDoor(AbstractFactoryMethod abstractFactoryMethod) {
        return abstractFactoryMethod.createDoor();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        Door door1 = AbstractFactoryBuilder.createDoor(new WoodenDoorFactory());
        System.out.println(door1.getDescription());
        Door door2 = AbstractFactoryBuilder.createDoor(new GlassDoorFactory());
        System.out.println(door2.getDescription());
    }

}
