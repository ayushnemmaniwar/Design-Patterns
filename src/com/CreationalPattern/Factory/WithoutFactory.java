package com.CreationalPattern.Factory;

// Door interface
 interface Door {
    String getDescription();
}

// Concrete implementations of Door
 class WoodenDoor implements Door {
    @Override
    public String getDescription() {
        return "A wooden door";
    }
}

 class IronDoor implements Door {
    @Override
    public String getDescription() {
        return "An iron door";
    }
}

 class GlassDoor implements Door {
    @Override
    public String getDescription() {
        return "A glass door";
    }
}
public class WithoutFactory {
    public static void main(String[] args) {
        // Creating objects directly in client code
        Door woodenDoor = new WoodenDoor();
        System.out.println(woodenDoor.getDescription());  // Output: A wooden door

        Door ironDoor = new IronDoor();
        System.out.println(ironDoor.getDescription());  // Output: An iron door

        Door glassDoor = new GlassDoor();
        System.out.println(glassDoor.getDescription());  // Output: A glass door

        // Adding a new type of door (e.g., SecurityDoor)
        // Requires modifying client code and creating a new class
        // Door securityDoor = new SecurityDoor();
        // System.out.println(securityDoor.getDescription());

    }
}
