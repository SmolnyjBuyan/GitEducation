package util;

public enum Operators {
    PLUS("+"), MINUS("-"), MULTI("*"), DIVIDE("/");
    private final String operator;

    Operators(String operator) {
        this.operator = operator;
    }

    public String operator() {
        return operator;
    }
}
