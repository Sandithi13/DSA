import java.util.Stack;

public class EnqueueFriendlyStackQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Enqueue operation - O(1)
    public void enqueue(int value) {

        s1.push(value);

        System.out.println(value + " enqueued");
    }

    // Dequeue operation - O(n)
    public int dequeue() {

        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // Transfer elements from s1 to s2
        if (s2.isEmpty()) {

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    public void display() {

        System.out.print("Queue: ");

        // Display elements in FIFO order
        for (int i = s2.size() - 1; i >= 0; i--) {
            System.out.print(s2.get(i) + " ");
        }

        for (int i = 0; i < s1.size(); i++) {
            System.out.print(s1.get(i) + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        EnqueueFriendlyStackQueue q =
                new EnqueueFriendlyStackQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        System.out.println("Dequeued: " + q.dequeue());

        q.display();
    }
}
