package structural.bridge.abstractions;

import structural.bridge.implementors.Step;

public class Burger extends Food {

    public Burger(Step stepOne, Step stepTwo) {
        super(stepOne, stepTwo);
    }

    @Override
    public void makeFood() {
        System.out.print("Burger");
        stepOne.doStep();
        stepTwo.doStep();
    }
}
