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

    /**
     * Compares this SnakeJoint object to the specified object.
     * The result is true if and only if the argument is not null
     * and is a SnakeJoint object with the same x and y coordinates as this object.
     *
     * @param o the object to compare this SnakeJoint against
     * @return true if the given object represents a SnakeJoint equivalent to this object, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SnakeJoint)) {
            return false;
        }
        SnakeJoint other = (SnakeJoint) o;
        return this.x == other.x && this.y == other.y;
    }

    /**
     * Returns a hash code for this SnakeJoint object.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
}