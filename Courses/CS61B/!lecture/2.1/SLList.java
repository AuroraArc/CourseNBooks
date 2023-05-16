/** An SLList is a list of integers, which is not a naked linked list.
 * Rebranding: IntList -> IntNode
 * Bureaucracy: SLList
 * Access Control: public -> private
 * Nested Class: IntNode inside SLList
 */
public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(0, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    // Adds x to the front of the list.
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }

    // Returns the first item in the list.
    public int getFirst() {
        return sentinel.next.item;
    }

    // Adds an item to the end of the list. (iteratively)
    public void addLast(int x) {
        size++;

        IntNode p = sentinel;

        // Move p until it reaches the end of the list.
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    /* private static int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }

        return 1 + size(p.next);
    }
     public int size() {
        return size(first);
    }
     */

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer */
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.getFirst());
        L.addLast(20);
        System.out.println(L.size());
    }
}
