import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
    private Node first = null; // maintains linked list
    private int size = 0; // tracks size

    private class Node {
        Item item;
        Node next;

        Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node(item, oldFirst);
        size++;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node x = first; // responsible for traversal

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
        Bag<String> fruitsEverEaten = new Bag<>();

        fruitsEverEaten.add("Banana");
        fruitsEverEaten.add("Blueberry");
        fruitsEverEaten.add("Watermelon");
        fruitsEverEaten.add("Apple");

        if (fruitsEverEaten.isEmpty()) System.out.println("I've never tried any fruits before!");
        else {
            System.out.printf("I've only ever tried %d fruits: %n", fruitsEverEaten.getSize());
            for (String s : fruitsEverEaten) System.out.println(s);
        }
    }
}
