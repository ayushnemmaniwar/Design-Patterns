package com.CreationalPattern.Factory;

interface Door1 {
    String getDescription();
}

// Concrete implementations of Door
class WoodenDoor1 implements Door1 {
    @Override
    public String getDescription() {
        return "A wooden door";
    }
}

class IronDoor1 implements Door1 {
    @Override
    public String getDescription() {
        return "An iron door";
    }
}

class GlassDoor1 implements Door1 {
    @Override
    public String getDescription() {
        return "A glass door";
    }
}

class DoorFactory {
    public static Door1 makeDoor(String material) {
        if(material.equalsIgnoreCase("wood"))
            return new WoodenDoor1();
        else if (material.equalsIgnoreCase("glass")) {
            return new GlassDoor1();
        } else if(material.equalsIgnoreCase("iron")) {
            return new IronDoor1();
        } else {
            throw new IllegalArgumentException("Unknown door material: " + material);
        }
    }
}

public class WithFactory {
    public static void main(String[] args) {
        Door1 woodenDoor = DoorFactory.makeDoor("wood");
        System.out.println(woodenDoor.getDescription());  // Output: A wooden door

        Door1 ironDoor = DoorFactory.makeDoor("iron");
        System.out.println(ironDoor.getDescription());  // Output: An iron door

        Door1 glassDoor = DoorFactory.makeDoor("glass");
        System.out.println(glassDoor.getDescription());  // Output: A glass door

        // Adding a new type of door (e.g., SecurityDoor)
        // No modification needed in existing client code
       Door1 securityDoor = DoorFactory.makeDoor("security");
        System.out.println(securityDoor.getDescription());  // Output: A security door
    }
}
