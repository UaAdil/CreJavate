package Modules.module10.hometask9;

class TV {
    public void turnOn() {
        System.out.println("TV is turned on.");
    }

    public void turnOff() {
        System.out.println("TV is turned off.");
    }

    public void setChannel(int channel) {
        System.out.println("TV channel set to " + channel + ".");
    }
}

class AudioSystem {
    public void turnOn() {
        System.out.println("Audio system is turned on.");
    }

    public void turnOff() {
        System.out.println("Audio system is turned off.");
    }

    public void setVolume(int volume) {
        System.out.println("Audio volume set to " + volume + ".");
    }
}

class DVDPlayer {
    public void play() {
        System.out.println("DVD is playing.");
    }

    public void pause() {
        System.out.println("DVD is paused.");
    }

    public void stop() {
        System.out.println("DVD is stopped.");
    }
}

class GameConsole {
    public void turnOn() {
        System.out.println("Game console is turned on.");
    }

    public void startGame(String gameName) {
        System.out.println("Starting game: " + gameName);
    }
}

class HomeTheaterFacade {
    private TV tv;
    private AudioSystem audioSystem;
    private DVDPlayer dvdPlayer;
    private GameConsole gameConsole;

    public HomeTheaterFacade(TV tv, AudioSystem audioSystem, DVDPlayer dvdPlayer, GameConsole gameConsole) {
        this.tv = tv;
        this.audioSystem = audioSystem;
        this.dvdPlayer = dvdPlayer;
        this.gameConsole = gameConsole;
    }

    public void startMovie() {
        System.out.println("Starting movie mode...");
        tv.turnOn();
        audioSystem.turnOn();
        audioSystem.setVolume(8);
        dvdPlayer.play();
    }

    public void endMovie() {
        System.out.println("Ending movie mode...");
        dvdPlayer.stop();
        audioSystem.turnOff();
        tv.turnOff();
    }

    public void startGame(String gameName) {
        System.out.println("Starting game mode...");
        tv.turnOn();
        gameConsole.turnOn();
        gameConsole.startGame(gameName);
    }

    public void listenToMusic() {
        System.out.println("Starting music mode...");
        tv.turnOn();
        audioSystem.turnOn();
        audioSystem.setVolume(5);
    }

    public void setVolume(int volume) {
        audioSystem.setVolume(volume);
    }
}


public class HomeTheater {
    public static void main(String[] args) {
        TV tv = new TV();
        AudioSystem audioSystem = new AudioSystem();
        DVDPlayer dvdPlayer = new DVDPlayer();
        GameConsole gameConsole = new GameConsole();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, audioSystem, dvdPlayer, gameConsole);

        homeTheater.startMovie();
        homeTheater.setVolume(10);
        homeTheater.endMovie();

        System.out.println();

        homeTheater.startGame("Watch Dogs");
        homeTheater.setVolume(7);

        System.out.println();

        homeTheater.listenToMusic();
    }
}

