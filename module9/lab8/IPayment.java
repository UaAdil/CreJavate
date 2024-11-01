package Modules.module9.lab8;

// Адаптер используется, когда нужно приспособить интерфейс одного класса к интерфейсу другого,
// несовместимого с ним. К примеру, у нас есть зарядка с европейской вилкой,
// но розетка — американская. Адаптер поможет подключить зарядку,
// преобразуя вилку, чтобы она подошла к розетке.

// payment process
public interface IPayment {
    void processPayment(double amount);
    void refundPayment(double amount);
}

class InternalPayment implements IPayment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of " + amount + " via internal system.");
    }

    @Override
    public void refundPayment(double amount) {
        System.out.println("Refunding payment of " + amount + " via internal system.");
    }
}

class ExternalPaymentSystemA {
    public void makePayment(double amount) {
        System.out.println("Making payment of " + amount + " via External Payment System A.");
    }

    public void makeRefund(double amount) {
            System.out.println("Making refund of " + amount + " via External Payment System A.");
    }
}

class ExternalPaymentSystemB {
    public void sendPayment(double amount) {
        System.out.println("Sending payment of " + amount + " via External Payment System B.");
    }

    public void processRefund(double amount) {
        System.out.println("Processing refund of " + amount + " via External Payment System B.");
    }
}

// adapters
class PaymentAdapterA implements IPayment {
    private ExternalPaymentSystemA externalSystemA;

    public PaymentAdapterA(ExternalPaymentSystemA externalSystemA) {
        this.externalSystemA = externalSystemA;
    }

    @Override
    public void processPayment(double amount) {
        externalSystemA.makePayment(amount);
    }

    @Override
    public void refundPayment(double amount) {
        externalSystemA.makeRefund(amount);
    }
}

class PaymentAdapterB implements IPayment {
    private ExternalPaymentSystemB externalSystemB;

    public PaymentAdapterB(ExternalPaymentSystemB externalSystemB) {
        this.externalSystemB = externalSystemB;
    }

    @Override
    public void processPayment(double amount) {
        externalSystemB.sendPayment(amount);
    }

    @Override
    public void refundPayment(double amount) {
        externalSystemB.processRefund(amount);
    }
}

class PaymentMain {
    public static void main(String[] args) {
        IPayment internalProcessor = new InternalPayment();
        internalProcessor.processPayment(100.0);
        internalProcessor.refundPayment(50.0);

        ExternalPaymentSystemA externalSystemA = new ExternalPaymentSystemA();
        IPayment adapterA = new PaymentAdapterA(externalSystemA);
        adapterA.processPayment(200.0);
        adapterA.refundPayment(100.0);

        ExternalPaymentSystemB externalSystemB = new ExternalPaymentSystemB();
        IPayment adapterB = new PaymentAdapterB(externalSystemB);
        adapterB.processPayment(300.0);
        adapterB.refundPayment(150.0);
    }
}
