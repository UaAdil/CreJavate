package Modules.module9.lab8;

//Декоратор позволяет объекту добавлять к нему новые возможности,
// не меняя при этом сам исходный объект.
// Напрмер, у нас есть базовый объект - кофе,
// к которому мы хотим добавить что-то новое - молоко, сахар и т.д.
// не меняя сам рецепт кофе. Каждый раз, когда мы добавляем что-то,
// это добавляет функциональность, но не изменяет оригинальный кофе.

public interface IBeverage {
    double getCost();
    String getDescription();
}

class Coffee implements IBeverage {
    @Override
    public double getCost() {
        return 60.0;
    }

    @Override
    public String getDescription() {
        return "Coffee";
    }
}

abstract class BeverageDecorator implements IBeverage {
    protected IBeverage beverage;

    public BeverageDecorator(IBeverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double getCost() {
        return beverage.getCost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }
}

// decorators
class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(IBeverage beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return super.getCost() + 10.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }
}

class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(IBeverage beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return super.getCost() + 5.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }
}

class ChocolateDecorator extends BeverageDecorator {
    public ChocolateDecorator(IBeverage beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return super.getCost() + 15.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Chocolate";
    }
}

class DecoratorTest {
    public static void main(String[] args) {
        IBeverage beverage = new Coffee();
        System.out.println(beverage.getDescription() + " : " + beverage.getCost());

        beverage = new MilkDecorator(beverage);
        System.out.println(beverage.getDescription() + " : " + beverage.getCost());

        beverage = new SugarDecorator(beverage);
        System.out.println(beverage.getDescription() + " : " + beverage.getCost());

        beverage = new ChocolateDecorator(beverage);
        System.out.println(beverage.getDescription() + " : " + beverage.getCost());
    }
}
