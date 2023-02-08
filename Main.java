import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
    }
}

// Vector lists grow by 100% of its size every time it gets full
// Vectors are synchronized - only a single thread can access that method
// ArrayList grow by 50% of its size every time it gets full
// ArrayLists are not synchronized