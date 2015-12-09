/**
 * Lab 2: Debugging with Eclipse) <br />
 * The {@code HeapTree} class of integers only <br />
 * @author  MarcoXZh
 * @version 1.0.0
 */
public class HeapTree {

    /**
     * The {@code Node} class for {@code HeapTree}
     * @author  MarcoXZh
     * @version 1.0.0
     */
    class Node {
        int value;
        Node parent = null, lChild = null, rChild = null;
        /**
         * Constructor -- create a new node
         * @param value {@code int} value of the node
         */
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * Insert a new value into the heap
     * @param value     {@code int} the value to be inserted
     */
    public void insert(int value) {
        // TODO: Lab 2 Part 2-1 -- insert a value into the heap tree


    }

    /**
     * The heap sort procedure
     * @param numbers   {@code int[]} The integer array to be sorted
     */
    public static void sort(int[] numbers) {
        // TODO: Lab 2 Part 2-2 -- write heapsort using a tree to represent the heap


    }

    /**
     * Main entry: test the HeapSort
     * @param args      {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 200);
            System.out.print(numbers[i] + " ");
        } // for (int i = 0; i < numbers.length; i++)
        System.out.println();

        sort(numbers);

        for (int n: numbers)
            System.out.print(n + " ");
        System.out.println();
    }

}
