import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * Class for the Snake game board.
 */
public class SnakeBoard extends JPanel implements KeyListener {

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

    // The current direction of the snake
    private SnakeDirection direction;

    // Constants for the colors of the snake and apple
    public static final Color SNAKE_COLOR = Color.GREEN;
    public static final Color APPLE_COLOR = Color.RED;

    /**
     * Constructor for the SnakeBoard class.
     */
    public SnakeBoard() {
        // Set the size of the board
        int x = (BOARD_WIDTH - JOINT_SIZE) / 2;
        int y = (BOARD_HEIGHT - JOINT_SIZE) / 2;
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

        // Initialize the snake with INITIAL_SNAKE_LENGTH joints
        snake = new ArrayList<>();
        for (int i = 0; i < INITIAL_SNAKE_LENGTH; i++) {
            snake.add(new SnakeJoint(x, y));
        }

        // Set the initial direction of the snake to right
        direction = SnakeDirection.RIGHT;

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

    /**
     * Updates the position of the snake based on its current direction.
     */
    public void updateSnake() {
        // Get the current position of the snake's head
        SnakeJoint head = snake.get(0);
        int x = head.getX();
        int y = head.getY();

        // Calculate the new position of the snake's head based on the current direction
        if (direction == SnakeDirection.UP) {
            y -= JOINT_SIZE;
        } else if (direction == SnakeDirection.DOWN) {
            y += JOINT_SIZE;
        } else if (direction == SnakeDirection.LEFT) {
            x -= JOINT_SIZE;
        } else if (direction == SnakeDirection.RIGHT) {
            x += JOINT_SIZE;
        }

        // Check if the snake has collided with the walls or its own body
        if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT || snake.contains(new SnakeJoint(x, y))) {
            // Game over
            System.out.println("Game Over");
            System.exit(0);
        }

        // Update the position of the snake's head
        SnakeJoint newHead = new SnakeJoint(x, y);
        snake.add(0, newHead);

        // Check if the snake has eaten the apple
        if (checkApple(newHead)) {
            // Generate a new random location for the apple
            apple = new SnakeJoint((int) (Math.random() * BOARD_WIDTH), (int) (Math.random() * BOARD_HEIGHT));
        }
        else {
            // Remove the last joint of the snake if the snake has not eaten the apple
            snake.remove(snake.size() - 1);
        }
    }

    /**
     * Checks if the given SnakeJoint is the same as the apple.
     *
     * @param joint the SnakeJoint to check
     * @return true if the given SnakeJoint is the same as the apple, false otherwise
     */
    private boolean checkApple(SnakeJoint joint) {
        return apple.equals(joint);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Do nothing
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Do nothing
    }

    /**
     * Handles key press events.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // Get the key code for the pressed key
        int keyCode = e.getKeyCode();

        // Change the direction of the snake based on the key press
        if (keyCode == KeyEvent.VK_UP) {
            direction = SnakeDirection.UP;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            direction = SnakeDirection.DOWN;
        } else if (keyCode == KeyEvent.VK_LEFT) {
            direction = SnakeDirection.LEFT;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            direction = SnakeDirection.RIGHT;
        }
    }

    /**
     * Returns the list of joints in the snake.
     * @return the list of joints in the snake
     */
    public List<SnakeJoint> getSnake() {
        return snake;
    }

    /**
     * Returns the location of the apple on the board.
     * @return the location of the apple on the board
     */
    public SnakeJoint getApple() {
        return apple;
    }

    /**
     * Returns the current direction of the snake.
     * @return the current direction of the snake
     */
    public SnakeDirection getDirection() {
        return direction;
    }
}