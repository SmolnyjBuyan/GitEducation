public enum CellState {
    PLAYER(GameOverStatus.STATE_WIN_PLAYER),
    OPPONENT(GameOverStatus.STATE_WIN_OPPONENT),
    EMPTY(GameOverStatus.STATE_DRAW);

    private final GameOverStatus gameOverStatus;

    CellState(GameOverStatus gameOverStatus) {
        this.gameOverStatus = gameOverStatus;
    }

    public GameOverStatus getGameOverStatus() {
        return gameOverStatus;
    }
}
