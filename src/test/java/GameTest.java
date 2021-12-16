import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    void cellIsDead() {
        Cell cell = new Cell(false, 1, 1);
        Game game = new Game(cell);
        boolean isAlive = false;
        assertEquals(game.cell.isAlive(), isAlive);
    }
}