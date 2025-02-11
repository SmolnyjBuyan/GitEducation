public enum GameOverStatus {
    STATE_DRAW(0, "WE HAVE A TIE!"),
    STATE_WIN_PLAYER(1, "YOU WIN!"),
    STATE_WIN_OPPONENT(2, "YOU LOSE!");

    private final int value;
    private final String message;

    GameOverStatus(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }
}
