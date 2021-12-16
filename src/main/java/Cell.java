public class Cell {

    private boolean isAlive;
    private final int xAxis;
    private final int yAxis;

    public Cell(boolean isAlive, int xAxis, int yAxis) {
        this.isAlive = isAlive;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }


}
