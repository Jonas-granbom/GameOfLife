public class Cell {

    private boolean isAlive;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int checkHowManyAliveNeighboursGivenRowAndCol(Cell[][] gameField, int row, int col){
        int aliveNeighbours = 0;

        if (row > 0 && col > 0 && gameField[row - 1][col - 1].isAlive()) {
            aliveNeighbours++;
        }
        if (row > 0 && gameField[row - 1][col].isAlive()) {
            aliveNeighbours++;
        }
        if (row > 0 && col < 9 && gameField[row - 1][col + 1].isAlive()) {
            aliveNeighbours++;
        }
        if (col > 0 && gameField[row][col - 1].isAlive()) {
            aliveNeighbours++;
        }
        if (col < 9 && gameField[row][col + 1].isAlive()) {
            aliveNeighbours++;
        }
        if (row < 9 && col > 0 && gameField[row + 1][col - 1].isAlive()) {
            aliveNeighbours++;
        }
        if (row < 9 && gameField[row + 1][col].isAlive()) {
            aliveNeighbours++;
        }
        if (row < 9 && col < 9 && gameField[row + 1][col + 1].isAlive()) {
            aliveNeighbours++;
        }

        return aliveNeighbours;
    }

    @Override
    public String toString() {
        if (this.isAlive){
            return "O";
        } else {
            return "X";
        }
    }
}
