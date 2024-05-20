// В классе MyQueue реализуйте очередь для типа данных Integer с помощью LinkedList со следующими методами:

// enqueue() - помещает элемент в конец очереди
// dequeue() - возвращает первый элемент из очереди и удаляет его
// first() - возвращает первый элемент из очереди, не удаляя
// getElements() - возвращает все элементы в очереди

// Пример

// queue.enqueue(1);
// queue.enqueue(10);
// queue.enqueue(15);
// queue.enqueue(5);
// System.out.println(queue.getElements());

// Результат:

// [1, 10, 15, 5]

// queue.dequeue();
// queue.dequeue();
// System.out.println(queue.getElements());

// Результат:

//  [15, 5]
// System.out.println(queue.first());

// Результат:

// 15

import java.util.LinkedList;

public class Task_02 {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(76);
        queue.enqueue(234);
        queue.enqueue(232);
        queue.enqueue(786);
        queue.enqueue(546);
        queue.enqueue(5467);

        System.out.println(queue.getElements());
        System.out.println(queue.dequeue());
        System.out.println(queue.getElements());
        System.out.println(queue.first());
        System.out.println(queue.getElements());

    }
}

class MyQueue<T> {
    private LinkedList<T> ll = new LinkedList<>();

    public void enqueue(T element) {
        ll.add(element);
    }

    public LinkedList<T> getElements() {
        return ll;
    }

    public T dequeue(){
        return ll.pollFirst();
    }

    public T first() {
        return ll.peekFirst();
    }
}