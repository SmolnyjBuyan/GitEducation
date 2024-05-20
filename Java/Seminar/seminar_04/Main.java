public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(766);
        stack.push(567);
        stack.push(567);
        stack.push(567);
        stack.push(567);
        System.out.println(stack);

        stack.pop();  
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.empty());  
    }
}
