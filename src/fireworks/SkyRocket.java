package fireworks;

import de.ur.mi.oop.colors.Color;

public class SkyRocket {

    private final Rocket rocket;
    private Flare[] flares;
    private int remainingFuseTimeInMs;
    private boolean exploded;
    private boolean gone;

    public SkyRocket(int xPos, int yPos, float radius, float guideLength, int fuseTimeInMs, float velocity, Color color) {
        rocket = new Rocket(xPos, yPos, radius, guideLength, velocity, color);
        exploded = false;
        remainingFuseTimeInMs = fuseTimeInMs;
    }

    public void update(long deltaTime) {
        if (!exploded) {
            updateRocket(deltaTime);
        } else {
            updateFlares(deltaTime);
        }
    }

    private void updateRocket(long deltaTime) {
        remainingFuseTimeInMs -= deltaTime;
        if (remainingFuseTimeInMs <= 0) {
            flares = FireworkFactory.createFlares(rocket.getXPos(), rocket.getYPos(), rocket.getColor());
            exploded = true;
            return;
        }
        rocket.update();
    }

    private void updateFlares(long deltaTime) {
        for (Flare flare : flares) {
            if (flare.hasGone()) {
                gone = true;
                break;
            } else {
                flare.update(deltaTime);
            }
        }
    }

    public boolean hasGone() {
        return gone;
    }

    public void draw() {
        if (!exploded) {
            rocket.draw();
        } else {
            for (Flare flare : flares) {
                flare.draw();
            }
        }
    }

}
