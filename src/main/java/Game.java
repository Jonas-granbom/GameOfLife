public class Game {

    static Cell[][] gameField = new Cell[10][10];

    public static void main(String[] args) throws InterruptedException {

        int counter = 0;

        allCellsAreDeadByDefault();
        gameField[0][2].setAlive(true);
        gameField[1][0].setAlive(true);
        gameField[1][2].setAlive(true);
        gameField[2][1].setAlive(true);
        gameField[2][2].setAlive(true);

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


    public static void allCellsAreDeadByDefault() {
        for (int row = 0; row < Game.gameField.length; row++) {
            for (int col = 0; col < Game.gameField[row].length; col++) {
                Game.gameField[row][col] = new Cell(false, row, col);
            }
        }
    }

    public static void proceedToNextGeneration() {

        checkNeighbourStatusInAllCells();
        giveBirthOrKillCellDependingOnNeighbourStatus();
    }

    private static void giveBirthOrKillCellDependingOnNeighbourStatus() {
        for (int row = 0; row < Game.gameField.length; row++) {
            for (int col = 0; col < Game.gameField[row].length; col++) {
                if (Game.gameField[row][col].getNumberOfAliveNeighbours() < 2) {
                    Game.gameField[row][col].setAlive(false);
                } else if (Game.gameField[row][col].getNumberOfAliveNeighbours() == 3){
                    Game.gameField[row][col].setAlive(true);
                } else if (Game.gameField[row][col].getNumberOfAliveNeighbours() > 3) {
                    Game.gameField[row][col].setAlive(false);
                }
            }
        }
    }

    private static void checkNeighbourStatusInAllCells() {
        for (int row = 0; row < Game.gameField.length; row++) {
            for (int col = 0; col < Game.gameField[row].length; col++) {
                Game.gameField[row][col].checkForNeighboursForCurrentCell();
            }
        }
    }
}
