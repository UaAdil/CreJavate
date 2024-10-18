package Modules.module7.lab6;

//Pattern Strategy
public interface IShipping {
    double calculateShippingCost(double weight, double distance);
}

class StandardShipping implements IShipping {
    @Override
    public double calculateShippingCost(double weight, double distance) {
        return weight * 0.5 + distance * 0.1;
    }
}

class ExpressShipping implements IShipping {
    @Override
    public double calculateShippingCost(double weight, double distance) {
        return (weight * 0.75 + distance * 0.2) + 10;
    }
}

class InternationalShipping implements IShipping {
    @Override
    public double calculateShippingCost(double weight, double distance) {
        return weight * 1.0 + distance * 0.5 + 15;
    }
}

// additionally

class NightShipping implements IShipping {
    @Override
    public double calculateShippingCost(double weight, double distance) {
        return (weight * 0.6 + distance * 0.15) + 20;
    }
}



