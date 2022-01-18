public class Cell {

    private CellState cellState;
    private final int row;
    private final int col;
    private int numberOfAliveNeighbours;

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
        int FIRST_CELL = 0;
        int LAST_CELL = 9;

        aliveNeighbours = rowAboveCell(gameField, aliveNeighbours, FIRST_CELL, LAST_CELL);
        aliveNeighbours = sameRowAsCell(gameField, aliveNeighbours, FIRST_CELL, LAST_CELL);
        aliveNeighbours = rowBelowCell(gameField, aliveNeighbours, FIRST_CELL, LAST_CELL);

        return aliveNeighbours;
    }

    private int rowBelowCell(Cell[][] gameField, int aliveNeighbours, int firstCell, int lastCell) {
        if (row < lastCell && col > firstCell && gameField[nextRow(row)][previousColumn(col)].getCellState() == CellState.ALIVE) {
            aliveNeighbours++;
        }
        if (row < lastCell && gameField[nextRow(row)][col].getCellState() == CellState.ALIVE) {
            aliveNeighbours++;
        }
        if (row < lastCell && col < lastCell && gameField[nextRow(row)][nextColumn(col)].getCellState() == CellState.ALIVE) {
            aliveNeighbours++;
        }
        return aliveNeighbours;
    }

    private int sameRowAsCell(Cell[][] gameField, int aliveNeighbours, int firstCell, int lastCell) {
        if (col > firstCell && gameField[row][previousColumn(col)].getCellState() == CellState.ALIVE) {
            aliveNeighbours++;
        }
        if (col < lastCell && gameField[row][nextColumn(col)].getCellState() == CellState.ALIVE) {
            aliveNeighbours++;
        }
        return aliveNeighbours;
    }

    private int rowAboveCell(Cell[][] gameField, int aliveNeighbours, int firstCell, int lastCell) {
        if (row > firstCell && col > firstCell && gameField[previousRow(row)][previousColumn(col)].getCellState() == CellState.ALIVE) {
            aliveNeighbours++;
        }
        if (row > firstCell && gameField[previousRow(row)][col].getCellState() == CellState.ALIVE) {
            aliveNeighbours++;
        }
        if (row > firstCell && col < lastCell && gameField[previousRow(row)][nextColumn(col)].getCellState() == CellState.ALIVE) {
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

    public void checkForNeighboursForCurrentCell() {
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
