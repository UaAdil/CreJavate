package Modules.module4.practice3;

public interface IDelivery {
    void deliverOrder(Order order);
}

class CourierDelivery implements IDelivery {
    @Override
    public void deliverOrder(Order order) {
        System.out.println("Delivery by courier for the order: " + order);
    }
}

class PostDelivery implements IDelivery {
    @Override
    public void deliverOrder(Order order) {
        System.out.println("Delivery by mail for the order: " + order);
    }
}

class PickUpPointDelivery implements IDelivery {
    @Override
    public void deliverOrder(Order order) {
        System.out.println("Delivery to the pick-up point for the order: " + order);
    }
}

