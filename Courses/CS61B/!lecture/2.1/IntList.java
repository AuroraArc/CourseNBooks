public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }


    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }
    public static void main(String[] args) {
        IntList l = new IntList(15, null);
        l = new IntList(10, l);
        l = new IntList(5, l);
    }
}
