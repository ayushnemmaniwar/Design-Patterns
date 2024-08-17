package com.PrototypePattern;

interface Prototype {
    Prototype clone();
}

class Computer implements Prototype {
    private String CPU;
    private String RAM;
    private String storage;
    private String graphicsCard;

    public Computer(String CPU, String RAM, String storage, String graphicsCard) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.storage = storage;
        this.graphicsCard = graphicsCard;
    }

    @Override
    public Computer clone() {
        return new Computer(this.CPU, this.RAM, this.storage, this.graphicsCard);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", storage='" + storage + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                '}';
    }
}

public class WithPrototype {
    public static void main(String[] args) {
        Computer computer1 = new Computer("Intel i9", "32GB", "1TB SSD", "NVIDIA RTX 3080");
        Computer computer2 = computer1.clone();

        System.out.println(computer1);
        System.out.println(computer2);
    }
}


