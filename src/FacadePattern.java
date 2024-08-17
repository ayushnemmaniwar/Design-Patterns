class CPU {
    void start() {
        System.out.println("CPU started");
    }
    void execute() {
        System.out.println("CPU executing commands");
    }
    void shutDown() {
        System.out.println("CPU shut down");
    }
}

class Memory {
    void load() {
        System.out.println("Memory loaded");
    }
    void free() {
        System.out.println("Memory freed");
    }
}

class HardDrive {
    void readData() {
        System.out.println("Hard drive reading data");
    }
    void writeData() {
        System.out.println("Hard drive writing data");
    }
}

// Facade class
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        cpu.start();
        memory.load();
        hardDrive.readData();
        cpu.execute();
    }

    public void shutDownComputer() {
        cpu.shutDown();
        memory.free();
        hardDrive.writeData();
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        //without using Facade
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();

        cpu.start();
        memory.load();
        hardDrive.readData();
        cpu.execute();
        hardDrive.writeData();
        memory.free();
        cpu.shutDown();

        //Using facade Pattern
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
        computer.shutDownComputer();
    }
}
