package java;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListStack<Item> implements Iterable<Item> {
    private Node first = null;
    private int size = 0;

    private class Node {
        Item item;
        Node next;

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node(item, oldFirst);
        size++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<Item> {
        // responsible for list traversal
        Node x = first;

        public boolean hasNext() {
            return x != null;
        }

        public Item next() {
            if (x == null) throw new NoSuchElementException();
            Item item = x.item;
            x = x.next;
            return item;
        }

        public void remove() {
        }
    }

    public static void main(String[] args) {
        LinkedListStack<String> fruits = new LinkedListStack<>();

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
