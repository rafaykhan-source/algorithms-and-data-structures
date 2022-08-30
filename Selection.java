public class Selection {

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
        }
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) System.out.println(a[i]);
    }

    public static void main(String[] args) {
        String[] a = {"Banana", "Apple", "Cat", "Uwu"};

        sort(a);
        show(a);

    }
}
