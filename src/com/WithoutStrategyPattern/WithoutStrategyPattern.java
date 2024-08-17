package com.WithoutStrategyPattern;

class Vehicle {
    public void drive() {
        System.out.println("Normal Drive");
    }
}

class SportsVehicle extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Sports Drive");
    }
}

class OffRoad extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Sports Drive");
    }
}

class PassengerVehicle extends Vehicle {

}
public class WithoutStrategyPattern {
    public static void main(String []args) {
        Vehicle vehicle = new PassengerVehicle();
        vehicle.drive();
        //If you observe offroad vehicle and sports vehicle has the same driving strategy
        //And if there are more capabilities like seating,fuel then we can expect lot of
        //Code duplication. To avoid that we can use Strategy Design Pattern
    }
}
