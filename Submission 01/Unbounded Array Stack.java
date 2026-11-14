public class UnboundedArrayStack {

    private int[] arr;
    private int top;
    
    public UnboundedArrayStack() {
        arr = new int[2];
        top = -1;
    }

    // Resize the array
    private void resize(int newCapacity) {

        int[] newArr = new int[newCapacity];

        for (int i = 0; i <= top; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    // Push operation
    public void push(int value) {

        // Increase size if array is full
        if (top == arr.length - 1) {
            resize(arr.length * 2);
        }

        arr[++top] = value;

        System.out.println(value + " pushed");
    }

    // Pop operation
    public int pop() {

        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }

        int removed = arr[top];
        arr[top] = 0;
        top--;

        // Decrease size when usage is low
        if (arr.length > 2 && top + 1 <= arr.length / 4) {
            resize(arr.length / 2);
        }

        return removed;
    }

    public void display() {

        System.out.print("Stack: ");

        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        System.out.println("Current Capacity: " + arr.length);
    }

    public static void main(String[] args) {

        UnboundedArrayStack s =
                new UnboundedArrayStack();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        s.display();

        System.out.println("Popped: " + s.pop());
        System.out.println("Popped: " + s.pop());
        System.out.println("Popped: " + s.pop());

        s.display();
    }
}
