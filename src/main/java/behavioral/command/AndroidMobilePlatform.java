package behavioral.command;

public class AndroidMobilePlatform implements MobilePlatformReceiver {
    @Override
    public void openCamera() {
        System.out.println("Opening camera in Android");
    }
}
