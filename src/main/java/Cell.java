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

    public int checkHowManyAliveNeighboursGivenRowAndCol(Cell[][] gameField, int row, int col) {
        int aliveNeighbours = 0;

        if (row > 0 && col > 0 && gameField[row - 1][col - 1].getCellState() == CellState.ALIVE)
            aliveNeighbours++;
        if (row > 0 && gameField[row - 1][col].getCellState() == CellState.ALIVE)
            aliveNeighbours++;
        if (row > 0 && col < 9 && gameField[row - 1][col + 1].getCellState() == CellState.ALIVE)
            aliveNeighbours++;
        if (col > 0 && gameField[row][col - 1].getCellState() == CellState.ALIVE)
            aliveNeighbours++;
        if (col < 9 && gameField[row][col + 1].getCellState() == CellState.ALIVE)
            aliveNeighbours++;
        if (row < 9 && col > 0 && gameField[row + 1][col - 1].getCellState() == CellState.ALIVE)
            aliveNeighbours++;
        if (row < 9 && gameField[row + 1][col].getCellState() == CellState.ALIVE)
            aliveNeighbours++;
        if (row < 9 && col < 9 && gameField[row + 1][col + 1].getCellState() == CellState.ALIVE)
            aliveNeighbours++;

        return aliveNeighbours;
    }

    public void checkForNeighboursForCurrentCell() {
        numberOfAliveNeighbours = checkHowManyAliveNeighboursGivenRowAndCol(Game.gameField, row, col);
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
