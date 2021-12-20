import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {

    int MAX_ROWS = Game.gameField.length;
    int MAX_COLS = Game.gameField[0].length;


    @Test
    void allCellsAreDead() {
        Game.allCellsAreDeadByDefault();

        int numberOfAliveCells = 0;

        for (int row = 0; row < MAX_ROWS; row++) {
            for (int col = 0; col < MAX_COLS; col++) {
                if (Game.gameField[row][col].isAlive()) {
                    numberOfAliveCells++;
                }
            }
        }
        assertEquals(numberOfAliveCells, 0);
    }

    @Test
    void allCellsAreDeadExceptRow5Col4() {
        Game.allCellsAreDeadByDefault();
        Game.gameField[5][4].setAlive(true);
        List<String> aliveCells = new ArrayList<>();

        for (int row = 0; row < MAX_ROWS; row++) {
            for (int col = 0; col < MAX_COLS; col++) {
                if (Game.gameField[row][col].isAlive()) {
                    aliveCells.add("R" + row + "C" + col);
                }
            }
        }
        assertEquals(aliveCells.get(0), "R5C4");
    }

    @Test
    void checkHowManyNeighboursOfRow5Col4AreAlive() {
        Game.allCellsAreDeadByDefault();
        Game.gameField[5][4].setAlive(true);
        Game.gameField[5][5].setAlive(true);
        Game.gameField[4][4].setAlive(true);
        Game.gameField[6][4].setAlive(true);
        Game.gameField[8][1].setAlive(true);
        int row = 5;
        int col = 4;

        int numberOfAliveNeighboursOfGivenRowAndCol = Game.gameField[row][col].checkHowManyAliveNeighboursGivenRowAndCol(Game.gameField, row, col);

        assertEquals(3, numberOfAliveNeighboursOfGivenRowAndCol);
    }

    @Test
    void aliveCellWithNoAliveNeighboursDies(){
        Game.allCellsAreDeadByDefault();
        Game.gameField[5][5].setAlive(true);
        Game.proceedToNextGeneration();

        assertEquals(Game.gameField[5][5].isAlive(), false);
    }
    @Test
    void ifThreeAliveNeighboursCellWillComeToLife(){
        Game.allCellsAreDeadByDefault();
        Game.gameField[4][4].setAlive(true);
        Game.gameField[4][5].setAlive(true);
        Game.gameField[5][4].setAlive(true);
        Game.proceedToNextGeneration();
        assertEquals(Game.gameField[5][5].isAlive(), true);
    }

}

