import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSnakeBoard {

    // A dummy snakeBoard for testing the methods
    private SnakeBoard snakeBoard;
    private SnakeJoint snakeJoint;

    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void setup() {
        snakeBoard = new SnakeBoard();
        snakeJoint = new SnakeJoint((int) (Math.random() * 400), (int) (Math.random() * 400));
    }

    @Test
    @DisplayName("This method will test the SnakeBoard constructor")
    void testSnakeBoardConstructor(){
        assertEquals(3, snakeBoard.getSnake().size());
        assertEquals(SnakeDirection.RIGHT, snakeBoard.getDirection());
        assertNotEquals(snakeJoint.toString(), snakeBoard.getApple().toString());
    }
}