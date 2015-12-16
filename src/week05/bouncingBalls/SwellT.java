package week05.bouncingBalls;

/**
 * Created by georgipavlov on 16.12.15.
 */
public class SwellT implements Runnable {
    @Override
    public void run() {
        if(Game.shell.startShell) {
            Game.shell.tick();
        }
    }
}
