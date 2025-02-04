public enum Dot {
    PLAYER(1), OPPONENT(2), EMPTY(3);

    private int value;
    Dot(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
