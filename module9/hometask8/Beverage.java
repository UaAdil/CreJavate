package Modules.module9.hometask8;

public interface Beverage {
    double getCost();
    String getDescription();
}

class Espresso implements Beverage {
    @Override
    public double getCost() {
        return 60.0;
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }
}

class Tea implements Beverage {
    @Override
    public double getCost() {
        return 40.0;
    }

    @Override
    public String getDescription() {
        return "Tea";
    }
}

// abstract decorator
abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
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
class Milk extends BeverageDecorator {
    public Milk(Beverage beverage) {
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

class Sugar extends BeverageDecorator {
    public Sugar(Beverage beverage) {
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

class WhippedCream extends BeverageDecorator {
    public WhippedCream(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getCost() {
        return super.getCost() + 15.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Whipped Cream";
    }
}

class CafeOrderSystem {
    public static void main(String[] args) {
        // making
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " : " + beverage.getCost());

        // adding
        beverage = new Milk(beverage);
        System.out.println(beverage.getDescription() + " : " + beverage.getCost());

        beverage = new Sugar(beverage);
        System.out.println(beverage.getDescription() + " : " + beverage.getCost());

        beverage = new WhippedCream(beverage);
        System.out.println(beverage.getDescription() + " : " + beverage.getCost());
    }
}
