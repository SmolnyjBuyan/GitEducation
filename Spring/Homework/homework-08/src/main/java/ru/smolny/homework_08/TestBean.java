package ru.smolny.homework_08;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestBean {


    @LogTimeExecution
    public int sumWithForLoop(int N) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
        }
        return sum;
    }

    public void noLogMethod() {
        log.info("No log method has executed");
    }

    @LogTimeExecution
    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @RecoverException
    public int throwRuntimeException(int first, int second) {
        throw new RuntimeException();
    }

    @RecoverException
    public String throwNullPointerException() {
        throw new NullPointerException();
    }

    @RecoverException(noRecoverFor = {ClassCastException.class})
    public boolean throwIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    @RecoverException(noRecoverFor = {IndexOutOfBoundsException.class})
    public boolean throwIndexOutOfBoundsException() {
        throw new ArrayIndexOutOfBoundsException();
    }
}
