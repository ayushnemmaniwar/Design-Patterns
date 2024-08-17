// With Bridge Pattern

// Implementor (Logic is written here)
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int percent);
}

class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("Turning on TV");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off TV");
    }

    @Override
    public void setVolume(int percent) {
        System.out.println("Setting TV volume to " + percent + "%");
    }
}
class Radio implements Device {
    @Override
    public void turnOn() {
        System.out.println("Turning on Radio");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off Radio");
    }

    @Override
    public void setVolume(int percent) {
        System.out.println("Setting Radio volume to " + percent + "%");
    }
}

interface RemoteControl {
    void turnOn();
    void turnOff();
}

class BasicRemote implements RemoteControl {
    protected Device device;

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void turnOn() {
        device.turnOn();
    }

    @Override
    public void turnOff() {
        device.turnOff();
    }
}

class AdvancedRemote extends BasicRemote {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Muting device");
        device.setVolume(0);
    }
}



public class With_Bridge_Pattern {

    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl basicRemote = new BasicRemote(tv);
        basicRemote.turnOn();
        basicRemote.turnOff();

        AdvancedRemote advancedRemote = new AdvancedRemote(tv);
        advancedRemote.turnOn();
        advancedRemote.turnOff();
        advancedRemote.mute();

        Device radio = new Radio();
        RemoteControl basicRemoteForRadio = new BasicRemote(radio);
        basicRemoteForRadio.turnOn();
        basicRemoteForRadio.turnOff();

        RemoteControl advancedRemoteForRadio = new AdvancedRemote(radio);
        advancedRemoteForRadio.turnOn();
        advancedRemoteForRadio.turnOff();
        ((AdvancedRemote) advancedRemoteForRadio).mute();


    }
}
