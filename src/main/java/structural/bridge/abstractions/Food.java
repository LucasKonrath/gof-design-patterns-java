package structural.bridge.abstractions;

import structural.bridge.implementors.Step;

public abstract class Food {
    protected Step stepOne;
    protected Step stepTwo;

    protected Food(Step stepOne, Step stepTwo) {
        this.stepOne = stepOne;
        this.stepTwo = stepTwo;
    }

    abstract public void makeFood();
}
