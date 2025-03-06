package org.example;

import java.io.DataInput;
import java.io.InputStream;

public class Parametrized <T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> {
    T variableT;
    V variableV;
    K variableK;

    public Parametrized(T variableT, V variableV, K variableK) {
        this.variableT = variableT;
        this.variableV = variableV;
        this.variableK = variableK;
    }

    public T getVariableT() {
        return variableT;
    }

    public V getVariableV() {
        return variableV;
    }

    public K getVariableK() {
        return variableK;
    }

    public void printVariablesClassNames() {
        System.out.println(getVariableT().getClass().getSimpleName());
        System.out.println(getVariableV().getClass().getCanonicalName());
        System.out.println(getVariableK().getClass().getName());
    }
}
