package Modules.module9.practice8;

public interface IInternalDeliveryService {
    void deliverOrder(String orderId);
    String getDeliveryStatus(String orderId);
}

class InternalDeliveryService implements IInternalDeliveryService {
    @Override
    public void deliverOrder(String orderId) {
        System.out.println("Delivering order " + orderId + " via internal service.");
    }

    @Override
    public String getDeliveryStatus(String orderId) {
        return "Order " + orderId + " is in transit.";
    }
}


// adapters / внешняя система
class ExternalLogisticsServiceA {
    public void shipItem(int itemId) {
        System.out.println("Shipping item " + itemId + " via External Service A.");
    }

    public String trackShipment(int shipmentId) {
        return "Tracking status for item " + shipmentId + ": In transit.";
    }
}

class ExternalLogisticsServiceB {
    public void sendPackage(String packageInfo) {
        System.out.println("Sending package " + packageInfo + " via External Service B.");
    }

    public String checkPackageStatus(String trackingCode) {
        return "Status for " + trackingCode + ": Delivered.";
    }
}

// adapters / внешние службы
class LogisticsAdapterA implements IInternalDeliveryService {
    private ExternalLogisticsServiceA serviceA;

    public LogisticsAdapterA(ExternalLogisticsServiceA serviceA) {
        this.serviceA = serviceA;
    }

    @Override
    public void deliverOrder(String orderId) {
        int itemId = Integer.parseInt(orderId);
        serviceA.shipItem(itemId);
    }

    @Override
    public String getDeliveryStatus(String orderId) {
        int shipmentId = Integer.parseInt(orderId);
        return serviceA.trackShipment(shipmentId);
    }
}
class LogisticsAdapterB implements IInternalDeliveryService {
    private ExternalLogisticsServiceB serviceB;

    public LogisticsAdapterB(ExternalLogisticsServiceB serviceB) {
        this.serviceB = serviceB;
    }

    @Override
    public void deliverOrder(String orderId) {
        serviceB.sendPackage(orderId);
    }

    @Override
    public String getDeliveryStatus(String orderId) {
        return serviceB.checkPackageStatus(orderId);
    }
}

// фабрика
class DeliveryServiceFactory {
    public static IInternalDeliveryService getDeliveryService(String serviceType) {
        switch (serviceType) {
            case "internal":
                return new InternalDeliveryService();
            case "externalA":
                return new LogisticsAdapterA(new ExternalLogisticsServiceA());
            case "externalB":
                return new LogisticsAdapterB(new ExternalLogisticsServiceB());
            default:
                throw new IllegalArgumentException("Unknown service type: " + serviceType);
        }
    }
}


class LogisticsSystem {
    public static void main(String[] args) {
        // use Internal service
        IInternalDeliveryService internalService = DeliveryServiceFactory.getDeliveryService("internal");
        internalService.deliverOrder("123");
        System.out.println(internalService.getDeliveryStatus("123"));

        // use external system A
        IInternalDeliveryService externalServiceA = DeliveryServiceFactory.getDeliveryService("externalA");
        externalServiceA.deliverOrder("456");
        System.out.println(externalServiceA.getDeliveryStatus("456"));

        // use external system B
        IInternalDeliveryService externalServiceB = DeliveryServiceFactory.getDeliveryService("externalB");
        externalServiceB.deliverOrder("789");
        System.out.println(externalServiceB.getDeliveryStatus("789"));
    }
}
