import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    // stack representation
    Item[] items = (Item[]) new Object[2];
    // tracks stack size and assists item retrieval
    private int N = 0;

    public int getSize() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) a[i] = items[i];
        items = a;
    }

    public void push(Item item) {
        if (N == items.length) resize(2 * items.length);
        items[N++] = item;
    }

    public Item pop() {
        if (N == (items.length / 4)) resize(items.length / 2);
        Item popped = items[--N];
        items[N] = null;
        return popped;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        // used for array traversal
        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            if (i == 0) throw new NoSuchElementException();
            return items[--i];
        }

        public void remove() {
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> fruits = new ResizingArrayStack<>();

        fruits.push("Banana");
        fruits.push("Earthworm");
        String popped = fruits.pop();
        System.out.println("An " + popped + " was popped from the stack of fruits!");
        fruits.push("Blueberry");
        fruits.push("Apple");

        System.out.printf("There are %d fruits in the stack %n", fruits.getSize());
        for (String s : fruits) System.out.println(fruits.pop());

        if (fruits.isEmpty()) System.out.println("You have no fruits remaining.");
    }
}
