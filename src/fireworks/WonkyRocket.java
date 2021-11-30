package fireworks;

import de.ur.mi.oop.colors.Color;

public class WonkyRocket extends Rocket {

    private static final int MAX_DRIFT = 10;

    private boolean moveLeft = true;
    private int currentDrift = 0;

    public WonkyRocket(float xPos, float yPos, float radius, float guideLength, float velocity, Color color) {
        super(xPos, yPos, radius, guideLength, velocity, color);
    }

    @Override
    public void update() {
        if (moveLeft) {
            move(-3, getVelocity());
        } else {
            move(3, getVelocity());
        }
        currentDrift++;
        if (currentDrift >= MAX_DRIFT) {
            moveLeft = !moveLeft;
            currentDrift = 0;
        }
    }
}
