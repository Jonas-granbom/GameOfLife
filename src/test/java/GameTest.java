import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;

public class GameTest {

    @Test
    void allCellsAreDead() {
        for (int row = 0; row < Game.gameField.length; row++) {
            for (int col = 0; col < Game.gameField[row].length; col++) {
                Game.gameField[row][col] = new Cell(false);
            }
        }
        int numberOfAliveCells = 0;
        int MAX_ROWS = Game.gameField.length;
        int MAX_COLS = Game.gameField[0].length;

        for (int row = 0; row < MAX_ROWS; row++) {
            for (int col = 0; col < MAX_COLS; col++) {
                if (Game.gameField[row][col].isAlive()) {
                    numberOfAliveCells++;
                }
            }
        }
        assertEquals(numberOfAliveCells, 0);
    }
}

