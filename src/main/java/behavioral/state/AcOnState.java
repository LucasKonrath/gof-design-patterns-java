package behavioral.state;

public class AcOnState implements State {

    @Override
    public boolean doAction() {
        System.out.println("AC turned on");
        return true;
    }
}
