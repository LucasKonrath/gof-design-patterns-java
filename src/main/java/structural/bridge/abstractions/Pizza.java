package structural.bridge.abstractions;

import structural.bridge.implementors.Step;

public class Pizza extends Food {

    public Pizza(Step stepOne, Step stepTwo) {
        super(stepOne, stepTwo);
    }

    @Override
    public void makeFood() {
        System.out.print("Pizza");
        stepOne.doStep();
        stepTwo.doStep();
    }
}
