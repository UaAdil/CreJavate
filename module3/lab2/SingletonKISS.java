package Modules.module3.lab2;

class SimpleService {
    public void DoSomething() {
        System.out.println("Doing something...");
    }
}

class Client {
    private SimpleService service;

    public Client(SimpleService service) {
        this.service = service;
    }
    public void Execute() {
        service.DoSomething();
    }
}

public class SingletonKISS {
        public static void main(String[] args) {
            SimpleService service = new SimpleService();
            Client client = new Client(service);
            client.Execute();
    }

}
