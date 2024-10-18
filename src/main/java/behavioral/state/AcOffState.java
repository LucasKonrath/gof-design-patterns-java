package behavioral.state;

public class AcOffState implements State {

    @Override
    public boolean doAction() {
        System.out.println("AC turned off");
        return false;
    }
}
