package Modules.module8.lab7;

public abstract class Beverage {
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    private void boilWater() {
        System.out.println("Boiling water...");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup...");
    }

    protected abstract void brew();
    protected abstract void addCondiments();
}

class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon...");
    }
}

class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Brewing coffee...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk...");
    }
}

class HotChocolate extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Mixing hot chocolate powder...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding whipped cream...");
    }
}
