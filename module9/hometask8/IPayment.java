package Modules.module9.hometask8;

public interface IPayment {
    void processPayment(double amount);
}

class PayPalPayment implements IPayment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " via PayPal.");
    }
}

class KaspiPaymentService {
    public void makeTransaction(double totalAmount) {
        System.out.println("Making transaction of " + totalAmount + " via Kaspi.");
    }
}

class KaspiPaymentAdapter implements IPayment {
    private KaspiPaymentService kaspiService;

    public KaspiPaymentAdapter(KaspiPaymentService kaspiService) {
        this.kaspiService = kaspiService;
    }

    @Override
    public void processPayment(double amount) {
        kaspiService.makeTransaction(amount);
    }
}

class HalykPaymentService {
    public void pay(double amount) {
        System.out.println("Processing payment of " + amount + " via Halyk.");
    }
}

class HalykPaymentAdapter implements IPayment {
    private HalykPaymentService halykService;

    public HalykPaymentAdapter(HalykPaymentService halykService) {
        this.halykService = halykService;
    }

    @Override
    public void processPayment(double amount) {
        halykService.pay(amount);
    }
}

class PaymentSystemClient {
    public static void main(String[] args) {
        IPayment paypalProcessor = new PayPalPayment();
        paypalProcessor.processPayment(100.0);

        KaspiPaymentService kaspiService = new KaspiPaymentService();
        IPayment kaspiAdapter = new KaspiPaymentAdapter(kaspiService);
        kaspiAdapter.processPayment(200.0);

        HalykPaymentService halykService = new HalykPaymentService();
        IPayment halykAdapter = new HalykPaymentAdapter(halykService);
        halykAdapter.processPayment(300.0);
    }
}

