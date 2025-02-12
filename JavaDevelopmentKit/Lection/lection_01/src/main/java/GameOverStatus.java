public enum GameOverStatus {
    STATE_DRAW("WE HAVE A TIE!"),
    STATE_WIN_PLAYER("YOU WIN!"),
    STATE_WIN_OPPONENT("YOU LOSE!");

    private final String message;

    GameOverStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
