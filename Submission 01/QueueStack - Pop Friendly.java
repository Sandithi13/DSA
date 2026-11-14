import java.util.LinkedList;
import java.util.Queue;

public class PopFriendlyQueueStack {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation - O(n)
    public void push(int value) {

        q2.add(value);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        System.out.println(value + " pushed");
    }

    // Pop operation - O(1)
    public int pop() {

        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return q1.remove();
    }

    public void display() {
        System.out.println("Stack: " + q1);
    }

    public static void main(String[] args) {

        PopFriendlyQueueStack s =
                new PopFriendlyQueueStack();

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        System.out.println("Popped: " + s.pop());

        s.display();
    }
}
