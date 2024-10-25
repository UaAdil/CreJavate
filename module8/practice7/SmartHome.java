package Modules.module8.practice7;

import java.util.Stack;

//Паттерн "Команда"
interface Command {
    void execute();
    void undo();
}

class Light {
    public void on() { System.out.println("Light is ON"); }
    public void off() { System.out.println("Light is OFF"); }
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) { this.light = light; }

    public void execute() { light.on(); }
    public void undo() { light.off(); }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) { this.light = light; }

    public void execute() { light.off(); }
    public void undo() { light.on(); }
}

class RemoteControl {
    private Stack<Command> commandHistory = new Stack<>();
    private Command[] buttons;
    private Command undoCommand;

    public RemoteControl(int slotCount) {
        buttons = new Command[slotCount];
    }

    public void setCommand(int slot, Command command) {
        buttons[slot] = command;
    }

    public void pressButton(int slot) {
        if (buttons[slot] != null) {
            buttons[slot].execute();
            commandHistory.push(buttons[slot]);
            undoCommand = buttons[slot];
        } else {
            System.out.println("No command assigned to this button.");
        }
    }

    public void undoButton() {
        if (!commandHistory.isEmpty()) {
            undoCommand.undo();
            commandHistory.pop();
        } else {
            System.out.println("No command to undo.");
        }
    }
}

// Main class for testing
public class SmartHome {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl(5);
        Light livingRoomLight = new Light();

        LightOnCommand lightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand lightOff = new LightOffCommand(livingRoomLight);

        remote.setCommand(0, lightOn);
        remote.setCommand(1, lightOff);

        // Execute and undo commands
        remote.pressButton(0);
        remote.undoButton();
        remote.pressButton(1);
        remote.undoButton();
    }
}
