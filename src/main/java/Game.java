public class Game {

    static Cell[][] gameField = new Cell[10][10];

    public static void main(String[] args) throws InterruptedException {

        int counter = 0;

        fillGameFieldWithDeadCellsByDefaultByDefault();
        setStateOfCellToAlive(gameField, 0, 2, Cell.CellState.ALIVE);
        setStateOfCellToAlive(gameField, 1, 0, Cell.CellState.ALIVE);
        setStateOfCellToAlive(gameField, 1, 2, Cell.CellState.ALIVE);
        setStateOfCellToAlive(gameField, 2, 1, Cell.CellState.ALIVE);
        setStateOfCellToAlive(gameField, 2, 2, Cell.CellState.ALIVE);

        while(true){
            System.out.println("generation: " + counter);
            counter++;

            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 10; col++) {
                    System.out.print(Game.gameField[row][col] + "  ");
                }
                System.out.println();
            }
            proceedToNextGeneration();
            Thread.sleep(500);
        }
    }

    private static void setStateOfCellToAlive(Cell[][] gameField, int row, int col, Cell.CellState alive) {
        gameField[row][col].setCellState(alive);
    }


    public static void fillGameFieldWithDeadCellsByDefaultByDefault() {
        for (int row = 0; row < Game.gameField.length; row++) {
            for (int col = 0; col < Game.gameField[row].length; col++) {
                Game.gameField[row][col] = new Cell(Cell.CellState.DEAD, row, col);
            }
        }
    }

    public static void proceedToNextGeneration() {
        checkNumberOfAliveNeighboursInAllCells();
        giveBirthOrKillCellDependingOnNumberOfAliveNeighbours();
    }

    private static void giveBirthOrKillCellDependingOnNumberOfAliveNeighbours() {
        for (int row = 0; row < Game.gameField.length; row++) {
            for (int col = 0; col < Game.gameField[row].length; col++) {
                if (Game.gameField[row][col].getNumberOfAliveNeighbours() < 2) {
                    setStateOfCellToAlive(Game.gameField, row, col, Cell.CellState.DEAD);
                } else if (Game.gameField[row][col].getNumberOfAliveNeighbours() == 3){
                    setStateOfCellToAlive(Game.gameField, row, col, Cell.CellState.ALIVE);
                } else if (Game.gameField[row][col].getNumberOfAliveNeighbours() > 3) {
                    setStateOfCellToAlive(Game.gameField, row, col, Cell.CellState.DEAD);
                }
            }
        }
    }

    private static void checkNumberOfAliveNeighboursInAllCells() {
        for (int row = 0; row < Game.gameField.length; row++) {
            for (int col = 0; col < Game.gameField[row].length; col++) {
                Game.gameField[row][col].checkForNeighboursForCurrentCell();
            }
        }
    }
}
