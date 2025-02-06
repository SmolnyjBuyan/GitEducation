public enum Dot {
    PLAYER(1), OPPONENT(2), EMPTY(0);

    private final int value;

    Dot(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
