public class Heap<E> {
    int lastPosition;
    int size;
    E[] array = (E[]) new Object[size];

    public void add(E obj) {
        array[++lastPosition] = obj;
        trickleUp(lastPosition);
    }

    public void swap(int from, int to) {
        E tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }

    public void trickleUp(int position) {
        if (position == 0) {
            return;
        }
        int parent = (int) Math.floor((position - 1) / 2);
        if (((comparable<E>) array[position]).compareTo(array.parent) > 0) {
            swap(position, parent);
            trickleUp(parent);
        }
    }
}
