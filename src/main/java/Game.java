public class Game {

    static Cell[][] gameField = new Cell[10][10];

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
