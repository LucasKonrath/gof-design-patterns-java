package structural.facade;

import java.util.stream.Stream;

public class KonamiCodeFacade {

    private Key up = new UpKey();

    private Key down = new DownKey();

    private Key left = new LeftKey();

    private Key right = new RightKey();

    private Key b = new BKey();

    private Key a = new AKey();

    private Key start = new StartKey();

    public void konamiCode(){
        Stream.of(up, up, down, down, left, right, left, right, b, a, start)
                .forEach(Key::press);
    }
}
