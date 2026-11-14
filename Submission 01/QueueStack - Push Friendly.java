import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation - O(1)
    public void push(int value) {
        q1.add(value);
        System.out.println(value + " pushed");
    }

    // Pop operation - O(n)
    public int pop() {

        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int removed = q1.remove();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return removed;
    }

    public void display() {
        System.out.println("Stack: " + q1);
    }

    public static void main(String[] args) {

        QueueStack s = new QueueStack();

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        System.out.println("Popped: " + s.pop());

        s.display();
    }
}
