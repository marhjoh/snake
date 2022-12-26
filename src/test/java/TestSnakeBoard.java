import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSnakeBoard {

    // A dummy snakeBoard for testing the methods
    private SnakeBoard snakeBoard;

    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void setup() {
        snakeBoard = new SnakeBoard();
    }

    @Test
    @DisplayName("This method will test the initial length of the snake")
    void testInitialSnakeLength() {
        assertEquals(SnakeBoard.INITIAL_SNAKE_LENGTH, snakeBoard.getSnake().size());
    }

    @Test
    @DisplayName("This method will test the initial direction of the snake")
    void testInitialDirection() {
        assertEquals(SnakeDirection.RIGHT, snakeBoard.getDirection());
    }
}