package behavioral.command;

public class OpenCameraCommand implements Command {

    private MobilePlatformReceiver mobilePlatform;

    public OpenCameraCommand(MobilePlatformReceiver mobilePlatform){
        this.mobilePlatform = mobilePlatform;
    }

    @Override
    public void execute() {
        this.mobilePlatform.openCamera();
    }
}
