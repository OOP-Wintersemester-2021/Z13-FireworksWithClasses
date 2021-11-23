import config.Config;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;
import fireworks.FireworkFactory;
import fireworks.SkyRocket;

public class FireworkWithClasses extends GraphicsApp {


    private SkyRocket[] fireworks;
    private long lastFrameTime;

    @Override
    public void initialize() {
        setCanvasSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        fireworks = FireworkFactory.createRandomSetOfRockets(getWidth(), getHeight(), Config.NUMBER_OF_ROCKETS);
        lastFrameTime = System.currentTimeMillis();
    }

    @Override
    public void draw() {
        long delta = System.currentTimeMillis() - lastFrameTime;
        lastFrameTime = System.currentTimeMillis();
        drawBackground(Config.BACKGROUND_COLOR);
        updateFireworks(delta);
        drawFireworks();
    }

    private void updateFireworks(long deltaTime) {
        for (int i = 0; i < fireworks.length; i++) {
            fireworks[i].update(deltaTime);
            if (fireworks[i].hasGone()) {
                fireworks[i] = FireworkFactory.createRandomRocket(getWidth(), getHeight());
            }
        }
    }

    private void drawFireworks() {
        for (SkyRocket rocket : fireworks) {
            rocket.draw();
        }
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch("FireworkWithClasses");
    }
}
