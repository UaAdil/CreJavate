package Modules.module4.lab3;

interface IWorker {
    void work();
}

interface IEater {
    void eat();
}

interface ISleeper {
    void sleep();
}

class HumanWorker implements IWorker, IEater, ISleeper {
    @Override
    public void work() {
        System.out.println("Human is working.");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Human is sleeping.");
    }
}

class RobotWorker implements IWorker {
    @Override
    public void work() {
        System.out.println("Robot is working.");
    }
}

public class Main {
    public static void main(String[] args) {
        IWorker humanWorker = new HumanWorker();
        humanWorker.work();
        ((IEater) humanWorker).eat();
        ((ISleeper) humanWorker).sleep();

        IWorker robotWorker = new RobotWorker();
        robotWorker.work();
    }
}
