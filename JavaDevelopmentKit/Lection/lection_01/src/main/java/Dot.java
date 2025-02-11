public enum Dot {
    PLAYER(1, GameOverStatus.STATE_WIN_PLAYER),
    OPPONENT(2, GameOverStatus.STATE_WIN_OPPONENT),
    EMPTY(0, GameOverStatus.STATE_DRAW);

    private final int value;
    private final GameOverStatus gameOverStatus;

    Dot(int value, GameOverStatus gameOverStatus) {
        this.value = value;
        this.gameOverStatus = gameOverStatus;
    }

    public int getValue() {
        return value;
    }

    public GameOverStatus getGameOverStatus() {
        return gameOverStatus;
    }
}
