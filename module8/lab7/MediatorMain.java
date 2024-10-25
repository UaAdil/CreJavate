package Modules.module8.lab7;

//Посредник - объектілерге басқа объектінің өзгеруін бақылауға және хабарламаларды автоматты түрде алуға мүмкіндік береді.
public class MediatorMain {
    public static void main(String[] args) {
        // create a mediator
        ChatMediator chatMediator = new ChatMediator();

        // create users
        User adil = new User(chatMediator, "Adil");
        User umar = new User(chatMediator, "Umar");
        User zhoni = new User(chatMediator, "Zhoni");

        chatMediator.registerColleague(adil);
        chatMediator.registerColleague(umar);
        chatMediator.registerColleague(zhoni);

        adil.send("Assalamu Aleikum!");
        umar.send("Ua Aleikummus Salam!");
        zhoni.send("What's up!");
    }
}
