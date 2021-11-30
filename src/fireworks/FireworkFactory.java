package fireworks;

import config.Config;
import de.ur.mi.oop.colors.Color;

public class FireworkFactory {

    private static final Color[] FIREWORK_COLORS = {Config.RED, Config.YELLOW, Config.GREEN, Config.BLUE};
    private static final int MIN_FUSE_TIME_IN_MS = 500;
    private static final int MAX_FUSE_TIME_IN_MS = 1500;
    private static final int ROCKET_START_X_POSITION_OFFSET = 50;
    private static final int ROCKET_START_Y_POSITION_OFFSET = 50;
    private static final int ROCKET_MIN_SPEED = 5;
    private static final int ROCKET_MAX_SPEED = 10;
    private static final float ROCKET_RADIUS = 6;
    private static final float GUIDE_LENGTH = 70;
    private static final float FLARE_RADIUS = 2;
    private static final int NUMBER_OF_FLARES_PER_ROCKET = 10;
    private static final int FLARE_LIFE_TIME = 1000;

    public static SkyRocket createRandomRocket(int worldWidth, int worldHeight) {
        int fuseTime = getRandomNumberBetween(MIN_FUSE_TIME_IN_MS, MAX_FUSE_TIME_IN_MS);
        int speed = getRandomNumberBetween(ROCKET_MIN_SPEED, ROCKET_MAX_SPEED);
        int xPos = getRandomNumberBetween(ROCKET_START_X_POSITION_OFFSET, worldWidth - ROCKET_START_X_POSITION_OFFSET);
        int yPos = worldHeight + ROCKET_START_Y_POSITION_OFFSET;
        Color color = getRandomColor();
        return new SkyRocket(xPos, yPos, ROCKET_RADIUS, GUIDE_LENGTH, fuseTime, -speed, color);
    }

    public static SkyRocket[] createRandomSetOfRockets(int worldWidth, int worldHeight, int count) {
        SkyRocket[] rockets = new SkyRocket[count];
        for (int i = 0; i < rockets.length; i++) {
            rockets[i] = createRandomRocket(worldWidth, worldHeight);
        }
        return rockets;
    }

    public static Flare[] createFlares(float originX, float originY, Color color) {
        Flare[] flares = new Flare[NUMBER_OF_FLARES_PER_ROCKET];
        int currentFlaresTargetDirection = 0;
        for (int i = 0; i < flares.length; i++) {
            float xVelocity = (float) (Math.cos(Math.toRadians(currentFlaresTargetDirection)));
            float yVelocity = (float) (Math.sin(Math.toRadians(currentFlaresTargetDirection)));
            flares[i] = new Flare(originX, originY, xVelocity, yVelocity, FLARE_LIFE_TIME, FLARE_RADIUS, color);
            currentFlaresTargetDirection += (360 / flares.length);
        }
        return flares;
    }

    private static int getRandomNumberBetween(int min, int max) {
        return (int) (min + (Math.random() * ((max - min) + 1)));
    }

    private static Color getRandomColor() {
        int index = getRandomNumberBetween(0, FIREWORK_COLORS.length - 1);
        return FIREWORK_COLORS[index];
    }

}
