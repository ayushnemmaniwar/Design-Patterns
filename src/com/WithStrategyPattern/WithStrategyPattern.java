package com.WithStrategyPattern;

interface DriveStrategy {
    public void Drive();
}

class NormalDrive implements DriveStrategy {

    @Override
    public void Drive() {
        System.out.println("Normal Drive");
    }
}

class SportsDrive implements DriveStrategy {

    @Override
    public void Drive() {
        System.out.println("Sports Drive");
    }
}

class Vehicle {
    DriveStrategy driveStrategy;
    Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy=driveStrategy;
    }
    public void drive() {
        driveStrategy.Drive();
    }
}
class NormalVehicle extends Vehicle {

    NormalVehicle() {
        super(new NormalDrive());
    }
}

class SportsVehicle extends Vehicle {
    SportsVehicle() {
        super(new SportsDrive());
    }
}

class OffRoadVehicle extends Vehicle {
    OffRoadVehicle() {
        super(new SportsDrive());
    }
}

public class WithStrategyPattern {
    public static void main(String []args) {
        Vehicle normalVehicle = new NormalVehicle();
        Vehicle sportsVehicle = new SportsVehicle();
        Vehicle offRoadVehicle = new OffRoadVehicle();

        normalVehicle.drive();  // Normal Drive
        sportsVehicle.drive();  // Sports Drive
        offRoadVehicle.drive();  // Off-road Drive
    }
}
