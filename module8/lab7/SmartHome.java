package Modules.module8.lab7;
// Паттерн Команда -  сұрауды немесе операцияны объектіге инкапсуляциялауға мүмкіндік береді.
// Бұл команданың жіберушісін оның орындаушысынан бөлуге, командалар тарихын сақтауға,
// оларды болдырмауға немесе қайталауға мүмкіндік береді.
class RemoteControl {
    private ICommand onCommand;
    private ICommand offCommand;

    public void setCommands(ICommand onCommand, ICommand offCommand) {
        this.onCommand = onCommand;
        this.offCommand = offCommand;
    }

    public void pressOnButton() {
        onCommand.execute();
    }

    public void pressOffButton() {
        offCommand.execute();
    }

    public void pressUndoButton() {
        onCommand.undo();
    }
}

public class SmartHome {
    public static void main(String[] args) {
        // create
        Light livingRoomLight = new Light();
        Television tv = new Television();

        // commands for control light
        ICommand lightOn = new LightOnCommand(livingRoomLight);
        ICommand lightOff = new LightOffCommand(livingRoomLight);

        // commands for control tv
        ICommand tvOn = new TelevisionOnCommand(tv);
        ICommand tvOff = new TelevisionOffCommand(tv);

        // create remote control
        RemoteControl remote = new RemoteControl();

        remote.setCommands(lightOn, lightOff);
        System.out.println("Control light:");
        remote.pressOnButton();
        remote.pressOffButton();
        remote.pressUndoButton();

        remote.setCommands(tvOn, tvOff);
        System.out.println("\nControl TV:");
        remote.pressOnButton();
        remote.pressOffButton();
    }
}

