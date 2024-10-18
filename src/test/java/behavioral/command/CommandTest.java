package behavioral.command;

import org.junit.Test;

public class CommandTest {

    @Test
    public void test(){
        MobilePlatformReceiver ios = new IosMobilePlatform();

        OpenCameraCommand openCameraCommandIos = new OpenCameraCommand(ios);
        openCameraCommandIos.execute();

        MobilePlatformReceiver android = new AndroidMobilePlatform();
        OpenCameraCommand openCameraCommandAndroid = new OpenCameraCommand(android);
        openCameraCommandAndroid.execute();
    }
}
