/**
 * Class for a joint in the snake.
 */
public class SnakeJoint {

    // The x and y coordinates of the joint, in pixels
    private int x;
    private int y;

    /**
     * Constructor for the SnakeJoint class.
     *
     * @param x the x coordinate of the joint
     * @param y the y coordinate of the joint
     */
    public SnakeJoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x coordinate of the joint.
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y coordinate of the joint.
     */
    public int getY() {
        return y;
    }

}