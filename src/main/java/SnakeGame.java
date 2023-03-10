import javax.swing.JFrame;

/**
 * Main class for the Snake game.
 */
public class SnakeGame {

    /**
     * Main method for the Snake game.
     */
    public static void main(String[] args) {
        // Create the game board
        SnakeBoard board = new SnakeBoard();

        // Set up the game window
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(board);
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener(board);  // Add the board as a key listener

        // Start the game loop
        while (true) {

            // Update the snake's position
            board.updateSnake();

            // Repaint the board
            board.repaint();

            // Sleep for a short time
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}