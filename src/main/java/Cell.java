public class Cell {

    private boolean isAlive;
    private int row;
    private int col;
    private int numberOfAliveNeighbours;

    public Cell(boolean isAlive, int row, int col) {
        this.isAlive = isAlive;
        this.row = row;
        this.col = col;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int checkHowManyAliveNeighboursGivenRowAndCol(Cell[][] gameField, int row, int col){
        int aliveNeighbours = 0;

        if (row > 0 && col > 0 && gameField[row - 1][col - 1].isAlive())
            aliveNeighbours++;
        if (row > 0 && gameField[row - 1][col].isAlive())
            aliveNeighbours++;
        if (row > 0 && col < 9 && gameField[row - 1][col + 1].isAlive())
            aliveNeighbours++;
        if (col > 0 && gameField[row][col - 1].isAlive())
            aliveNeighbours++;
        if (col < 9 && gameField[row][col + 1].isAlive())
            aliveNeighbours++;
        if (row < 9 && col > 0 && gameField[row + 1][col - 1].isAlive())
            aliveNeighbours++;
        if (row < 9 && gameField[row + 1][col].isAlive())
            aliveNeighbours++;
        if (row < 9 && col < 9 && gameField[row + 1][col + 1].isAlive())
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
        if (this.isAlive){
            return "▇";
        } else {
            return "▒";
        }
    }
}
