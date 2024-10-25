package Modules.module8.hometask7;

interface ICommand {
    void execute();
    void undo();
}

class Light {
    void on() {
        System.out.println("Light is ON");
    }
    void off() {
        System.out.println("Light is OFF");
    }
}

class LightOnCommand implements ICommand {
    private final Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.on();
    }
    public void undo() {
        light.off();
    }
}

class LightOffCommand implements ICommand {
    private final Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.off();
    }
    public void undo() {
        light.on();
    }
}

class RemoteControl {
    private ICommand lastCommand;

    public void setCommand(ICommand command) {
        lastCommand = command;
        command.execute();
    }

    public void undoCommand() {
        if (lastCommand != null) {
            lastCommand.undo();
        }
    }
}

public class SmartHome {
    public static void main(String[] args) {
        Light light = new Light();
        ICommand lightOn = new LightOnCommand(light);
        ICommand lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(lightOn);
        remote.undoCommand();
    }
}
