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
                if (Game.gameField[row][col].getCellState() == Cell.CellState.ALIVE) {
                    numberOfAliveCells++;
                }
            }
        }
        assertEquals(numberOfAliveCells, 0);
    }

    @Test
    void allCellsAreDeadExceptRow5Col4() {
        Game.allCellsAreDeadByDefault();
        setStateOfCellToAlive(5, 4);
        List<String> aliveCells = new ArrayList<>();

        for (int row = 0; row < MAX_ROWS; row++) {
            for (int col = 0; col < MAX_COLS; col++) {
                if (Game.gameField[row][col].getCellState() == Cell.CellState.ALIVE) {
                    aliveCells.add("R" + row + "C" + col);
                }
            }
        }
        assertEquals(aliveCells.get(0), "R5C4");
    }

    @Test
    void checkHowManyNeighboursOfRow5Col4AreAlive() {
        Game.allCellsAreDeadByDefault();
        setStateOfCellToAlive(5, 4);
        setStateOfCellToAlive(5, 5);
        setStateOfCellToAlive(4, 4);
        setStateOfCellToAlive(6, 4);
        setStateOfCellToAlive(8, 1);
        int row = 5;
        int col = 4;

        int numberOfAliveNeighboursOfGivenRowAndCol = Game.gameField[row][col].checkHowManyAliveNeighboursGivenRowAndCol(Game.gameField, row, col);

        assertEquals(3, numberOfAliveNeighboursOfGivenRowAndCol);
    }

    @Test
    void aliveCellWithNoAliveNeighboursDies(){
        Game.allCellsAreDeadByDefault();
        setStateOfCellToAlive(5, 5);
        Game.proceedToNextGeneration();

        assertEquals(Game.gameField[5][5].getCellState(), Cell.CellState.DEAD);
    }

    @Test
    void ifThreeAliveNeighboursCellWillComeToLife(){
        Game.allCellsAreDeadByDefault();
        setStateOfCellToAlive(4, 4);
        setStateOfCellToAlive(4, 5);
        setStateOfCellToAlive(5, 4);
        Game.proceedToNextGeneration();
        assertEquals(Game.gameField[5][5].getCellState(), Cell.CellState.ALIVE);
    }
    private void setStateOfCellToAlive(int row, int col) {
        Game.gameField[row][col].setCellState(Cell.CellState.ALIVE);
    }
}

