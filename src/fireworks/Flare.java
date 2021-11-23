package fireworks;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.graphics.Circle;

public class Flare {

    private final float xVelocity;
    private final float yVelocity;
    private final Circle flare;
    private final float maxLifeTime;
    private float lifeTime;

    public Flare(float xPos, float yPos, float xVelocity, float yVelocity, float maxLifetime, float radius, Color color) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.maxLifeTime = maxLifetime;
        this.flare = new Circle(xPos, yPos, radius, color);
    }

    public void update(long deltaTime) {
        lifeTime += deltaTime;
        flare.move(xVelocity, yVelocity);
    }

    public boolean hasGone() {
        return (lifeTime > maxLifeTime);
    }

    public void draw() {
        flare.draw();
    }

}
