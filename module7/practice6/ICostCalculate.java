package Modules.module7.practice6;

public interface ICostCalculate {
    double calculateCost(double distance, int passengers, String serviceClass, boolean hasDiscount);
}

class AirplaneCostCalculation implements ICostCalculate {
    @Override
    public double calculateCost(double distance, int passengers, String serviceClass, boolean hasDiscount) {
        double basePrice = distance * 0.5;
        if ("business".equalsIgnoreCase(serviceClass)) {
            basePrice *= 2;
        }
        if (hasDiscount) {
            basePrice *= 0.9; // 10% discount
        }
        return basePrice * passengers; // total
    }
}

class TrainCostCalculation implements ICostCalculate {
    @Override
    public double calculateCost(double distance, int passengers, String serviceClass, boolean hasDiscount) {
        double basePrice = distance * 0.3;
        if ("business".equalsIgnoreCase(serviceClass)) {
            basePrice *= 1.5;
        }
        if (hasDiscount) {
            basePrice *= 0.85; // 15% discount
        }
        return basePrice * passengers;
    }
}

class BusCostCalculation implements ICostCalculate{
    @Override
    public double calculateCost(double distance, int passengers, String serviceClass, boolean hasDiscount) {
        double basePrice = distance * 0.1;
        if ("business".equalsIgnoreCase(serviceClass)) {
            basePrice *= 1.2;
        }
        if (hasDiscount) {
            basePrice *= 0.8; // 20% discount
        }
        return basePrice * passengers;
    }
}

class VipTransportCostCalculation implements ICostCalculate{
    @Override
    public double calculateCost(double distance, int passengers, String serviceClass, boolean hasDiscount) {
        double basePrice = distance * 1.5; // Vip high price
        if ("business".equalsIgnoreCase(serviceClass)) {
            basePrice *= 2;
        }
        if (hasDiscount) {
            basePrice *= 0.8;
        }
        return basePrice * passengers + 100;
    }
}


