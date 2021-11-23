package fireworks;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.graphics.Circle;
import de.ur.mi.oop.graphics.Line;
import de.ur.mi.oop.graphics.Rectangle;

public class Rocket {

    private final float velocity;
    private final float guideLength;
    private final Circle nose;
    private final Rectangle body;
    private final Line guide;

    public Rocket(float xPos, float yPos, float radius, float guideLength, float velocity, Color color) {
        this.velocity = velocity;
        this.guideLength = guideLength;
        nose = new Circle(xPos, yPos, radius, color);
        body = new Rectangle(xPos - radius, yPos, radius * 2, radius * 5, color);
        guide = new Line(0, 0, 0, 0, color);
    }

    public Color getColor() {
        return nose.getColor();
    }

    public float getXPos() {
        return nose.getXPos();
    }

    public float getYPos() {
        return nose.getYPos();
    }

    public void update() {
        nose.move(0, velocity);
        body.move(0, velocity);
        guide.setStartAndEndPoint(nose.getXPos(), nose.getYPos(), nose.getXPos(), nose.getYPos() + guideLength);
    }

    public void draw() {
        nose.draw();
        body.draw();
        guide.draw();
    }
}
