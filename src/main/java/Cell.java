public class Cell {

    private CellState cellState;
    private final int row;
    private final int col;
    private int numberOfAliveNeighbours;
    private int FIRST_CELL = 0;
    private int LAST_CELL = 9;

    enum CellState {
        ALIVE,
        DEAD
    }

    public Cell(CellState state, int row, int col) {
        cellState = state;
        this.row = row;
        this.col = col;
    }
    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public CellState getCellState() {
        return cellState;
    }

    public int checkHowManyAliveNeighboursGivenRowAndCol(Cell[][] gameField) {
        int aliveNeighbours = 0;

        aliveNeighbours = rowAboveCell(gameField, aliveNeighbours);
        aliveNeighbours = sameRowAsCell(gameField, aliveNeighbours);
        aliveNeighbours = rowBelowCell(gameField, aliveNeighbours);

        return aliveNeighbours;
    }

    private int rowBelowCell(Cell[][] gameField, int aliveNeighbours) {
        if (row < LAST_CELL && col > FIRST_CELL && gameField[nextRow(row)][previousColumn(col)].getCellState() == CellState.ALIVE) {
            aliveNeighbours++;
        }
        if (row < LAST_CELL && gameField[nextRow(row)][col].getCellState() == CellState.ALIVE) {
            aliveNeighbours++;
        }
        if (row < LAST_CELL && col < LAST_CELL && gameField[nextRow(row)][nextColumn(col)].getCellState() == CellState.ALIVE) {
            aliveNeighbours++;
        }
        return aliveNeighbours;
    }

    private int sameRowAsCell(Cell[][] gameField, int aliveNeighbours) {
        if (col > FIRST_CELL && gameField[row][previousColumn(col)].getCellState() == CellState.ALIVE) {
            aliveNeighbours++;
        }
        if (col < LAST_CELL && gameField[row][nextColumn(col)].getCellState() == CellState.ALIVE) {
            aliveNeighbours++;
        }
        return aliveNeighbours;
    }

    private int rowAboveCell(Cell[][] gameField, int aliveNeighbours) {
        if (row > FIRST_CELL && col > FIRST_CELL && gameField[previousRow(row)][previousColumn(col)].getCellState() == CellState.ALIVE) {
            aliveNeighbours++;
        }
        if (row > FIRST_CELL && gameField[previousRow(row)][col].getCellState() == CellState.ALIVE) {
            aliveNeighbours++;
        }
        if (row > FIRST_CELL && col < LAST_CELL && gameField[previousRow(row)][nextColumn(col)].getCellState() == CellState.ALIVE) {
            aliveNeighbours++;
        }
        return aliveNeighbours;
    }

    private int nextRow(int row) {
        return row + 1;
    }

    private int nextColumn(int col) {
        return col + 1;
    }

    private int previousColumn(int col) {
        return col - 1;
    }

    private int previousRow(int row) {
        return row - 1;
    }

    public void UpdateNumberOfAliveNeighboursForCurrentCell() {
        numberOfAliveNeighbours = checkHowManyAliveNeighboursGivenRowAndCol(Game.gameField);
    }

    public int getNumberOfAliveNeighbours() {
        return numberOfAliveNeighbours;
    }

    @Override
    public String toString() {
        if (this.getCellState() == CellState.ALIVE) {
            return "▇";
        } else {
            return "▒";
        }
    }
}
