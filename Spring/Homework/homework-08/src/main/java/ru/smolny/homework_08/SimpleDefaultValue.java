package ru.smolny.homework_08;

public class SimpleDefaultValue {
    public static Object get(Class<?> type) {
        if (type == boolean.class) return false;
        if (type == byte.class) return (byte)0;
        if (type == short.class) return (short)0;
        if (type == int.class) return 0;
        if (type == long.class) return 0L;
        if (type == float.class) return 0.0f;
        if (type == double.class) return 0.0d;
        if (type == char.class) return '\u0000';

        return null;
    }
}
