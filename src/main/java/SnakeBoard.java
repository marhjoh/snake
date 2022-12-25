import java.awt.*;

import javax.swing.JPanel;

/**
 * Class for the Snake game board.
 */
public class SnakeBoard extends JPanel {

    // Constants for the size of the board, in pixels
    public static final int BOARD_WIDTH = 400;
    public static final int BOARD_HEIGHT = 400;

    /**
     * Constructor for the SnakeBoard class.
     */
    public SnakeBoard() {
        // Set the size of the board
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
    }
}