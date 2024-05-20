// Реализовать свой класс Stack size(), empty(), push(), peek(), pop().

public class MyStack {
    private int capacity = 3;
    private int size = 0;
    private int[] array = new int[capacity];
    private  int top = -1;

    private void addCapacity(){
        if (size == capacity) {
            capacity = capacity * 2;
            int[] temp = new int[capacity];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
        }
    }

    public boolean empty(){
        return top == -1;
    }

    public int size(){
        return size;
    }

    public void push(int value){
        addCapacity();
        array[++top] = value;
        size++;
    }

    public int peek(){
        return array[top];
    }

    public int pop(){
        if (empty()) {
            throw new RuntimeException("Stack is empty");
        }

        size--;
        return array[top--];
    }

    @Override
    public String toString() {
        if (empty()) return "[]";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            builder.append(array[i]).append(", ");
        }

        builder.delete(builder.length() - 2, builder.length());
        return String.format("[%s]", builder);
    }
}
