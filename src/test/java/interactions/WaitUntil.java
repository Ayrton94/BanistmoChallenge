package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class WaitUntil implements Interaction {
    private final int seconds;

    public WaitUntil(int seconds) {
        this.seconds = seconds;
    }

    public static WaitUntil forSeconds(int seconds) {
        return new WaitUntil(seconds);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}