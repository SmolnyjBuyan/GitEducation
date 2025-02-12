import java.util.Objects;

public class Cell {
    private final int x;
    private final int y;
    private CellState state;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        state = CellState.EMPTY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public boolean isEmpty() {
        return state == CellState.EMPTY;
    }

    public boolean isPlayer() {
        return state == CellState.PLAYER;
    }

    public boolean isOpponent() {
        return state == CellState.OPPONENT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return state == cell.state;
    }
}
