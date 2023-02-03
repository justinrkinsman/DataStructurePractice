public class Main {
    public static void main(String[] args) {
        Array numbers = new Array(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        System.out.println(numbers.indexOf(100));
        numbers.print();
    }
}

// Vector lists grow by 100% of its size every time it gets full
    // Vectors are synchronized - only a single thread can access that method
// ArrayList grow by 50% of its size every time it gets full
    // ArrayLists are not synchronized