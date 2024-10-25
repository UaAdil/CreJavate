package Modules.module8.lab7;

public interface ICommand {
    void execute();
    void undo();
}

class LightOnCommand implements ICommand {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

class LightOffCommand implements ICommand {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}

class Light {
    public void on() {
        System.out.println("Light on.");
    }

    public void off() {
        System.out.println("Light off.");
    }
}

class TelevisionOnCommand implements ICommand {
    private Television television;

    public TelevisionOnCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.on();
    }

    @Override
    public void undo() {
        television.off();
    }
}

class TelevisionOffCommand implements ICommand {
    private Television television;

    public TelevisionOffCommand(Television television) {
        this.television = television;
    }

    @Override
    public void execute() {
        television.off();
    }

    @Override
    public void undo() {
        television.on();
    }
}

class Television {
    public void on() {
        System.out.println("TV is on.");
    }

    public void off() {
        System.out.println("TV is off.");
    }
}

class AirConditioner {
    public void on() {
        System.out.println("Conditioner is on.");
    }

    public void off() {
        System.out.println("Conditioner is off.");
    }
}

class AirConditionerOnCommand implements ICommand {
    private AirConditioner airConditioner;

    public AirConditionerOnCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.on();
    }

    @Override
    public void undo() {
        airConditioner.off();
    }
}

class AirConditionerOffCommand implements ICommand {
    private AirConditioner airConditioner;

    public AirConditionerOffCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.off();
    }

    @Override
    public void undo() {
        airConditioner.on();
    }
}


