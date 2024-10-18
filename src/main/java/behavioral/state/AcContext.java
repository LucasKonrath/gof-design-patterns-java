package behavioral.state;

public class AcContext implements State {

    private State acState;

    public void setAcState(State acState) {
        this.acState = acState;
    }

    public State getAcState() {
        return acState;
    }


    @Override
    public boolean doAction() {
        return acState.doAction();
    }
}
