import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * Class for the Snake game board.
 */
public class SnakeBoard extends JPanel {

    // Constants for the size of the board, in pixels
    public static final int BOARD_WIDTH = 400;
    public static final int BOARD_HEIGHT = 400;

    // Constants for the size of each snake joint, in pixels
    public static final int JOINT_SIZE = 10;

    // Constants for the initial number of joints in the snake
    public static final int INITIAL_SNAKE_LENGTH = 3;

    // The list of joints in the snake
    public List<SnakeJoint> snake;

    // The location of the apple on the board
    private SnakeJoint apple;

    // Constants for the colors of the snake and apple
    public static final Color SNAKE_COLOR = Color.GREEN;
    public static final Color APPLE_COLOR = Color.RED;

    /**
     * Constructor for the SnakeBoard class.
     */
    public SnakeBoard() {
        // Set the size of the board
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

        // Initialize the snake with INITIAL_SNAKE_LENGTH joints
        snake = new ArrayList<>();
        for (int i = 0; i < INITIAL_SNAKE_LENGTH; i++) {
            snake.add(new SnakeJoint(i * JOINT_SIZE, 0));
        }

        // Place the apple randomly on the board
        apple = new SnakeJoint((int) (Math.random() * BOARD_WIDTH), (int) (Math.random() * BOARD_HEIGHT));
    }

    /**
     * Paints the snake and the apple on the board.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the snake
        g.setColor(SNAKE_COLOR);
        for (SnakeJoint joint : snake) {
            g.fillRect(joint.getX(), joint.getY(), JOINT_SIZE, JOINT_SIZE);
        }

        // Draw the apple
        g.setColor(APPLE_COLOR);
        g.fillRect(apple.getX(), apple.getY(), JOINT_SIZE, JOINT_SIZE);
    }
}