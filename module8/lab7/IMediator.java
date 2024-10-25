package Modules.module8.lab7;

//Mediator интерфейсі хабарламаларды делдал арқылы жіберу үшін қолданылатын sendMessage () әдісін анықтайды.
//Colleague дерексіз сыныбы чат мүшелерін ұсынады. Әрбір қатысушының өзара әрекеттесетін делдалға сілтемесі бар.
//Chatmediator класы делдал интерфейсін жүзеге асырады және қатысушыларды тіркеуді, сондай-ақ хабарламаларды жіберуді басқарады.
//User класы-хабарламаларды жібере және қабылдай алатын нақты чат мүшесі.

import java.util.ArrayList;
import java.util.List;
public interface IMediator {
    void sendMessage(String message, Colleague colleague);
}

abstract class Colleague {
    protected IMediator mediator;

    public Colleague(IMediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receiveMessage(String message);
}

class ChatMediator implements IMediator {
    private List<Colleague> colleagues;

    public ChatMediator() {
        this.colleagues = new ArrayList<>();
    }
    public void registerColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void sendMessage(String message, Colleague sender) {
        for (Colleague colleague : colleagues) {
            if (colleague != sender) {
                colleague.receiveMessage(message);
            }
        }
    }
}

class User extends Colleague {
    private String name;

    public User(IMediator mediator, String name) {
        super(mediator);
        this.name = name;
    }

    public void send(String message) {
        System.out.println(this.name + " sends message: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(this.name + " received message: " + message);
    }
}
