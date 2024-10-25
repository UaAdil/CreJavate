package Modules.module8.hometask7;

abstract class Beverage {
    public final void prepare() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    abstract void brew();

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    abstract void addCondiments();

    boolean customerWantsCondiments() {
        return true;
    }
}

class Tea extends Beverage {
    void brew() {
        System.out.println("Steeping the tea");
    }

    void addCondiments() {
        System.out.println("Adding lemon");
    }
}

class Coffee extends Beverage {
    void brew() {
        System.out.println("Dripping coffee through filter");
    }

    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

public class BeverageTest {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        tea.prepare();

        Beverage coffee = new Coffee();
        coffee.prepare();
    }
}
