package com.BuilderPattern;
class Computer {
    private String CPU;
    private String RAM;

    // Optional parameters
    private String storage;
    private String graphicsCard;

    public Computer(ComputerBuilder computerBuilder) {
        this.CPU = computerBuilder.CPU;
        this.RAM = computerBuilder.RAM;
        this.storage = computerBuilder.storage;
        this.graphicsCard = computerBuilder.graphicsCard;
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

    public static class ComputerBuilder {
        private String CPU;
        private String RAM;

        // Optional parameters
        private String storage;
        private String graphicsCard;

        public ComputerBuilder(String CPU,String RAM) {
            this.CPU=CPU;
            this.RAM=RAM;
        }

        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGraphicCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }


}


public class BuilderPattern {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder("Intel I9","256GB SSD").setGraphicCard("aa").build();
        System.out.println(computer);
    }
}
