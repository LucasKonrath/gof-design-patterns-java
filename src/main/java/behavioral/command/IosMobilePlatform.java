package behavioral.command;

public class IosMobilePlatform implements MobilePlatformReceiver {
    @Override
    public void openCamera() {
        System.out.println("Opening camera in iOS");
    }
}
