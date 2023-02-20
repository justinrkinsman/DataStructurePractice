public class Hashes<K, V> /* implements HashI<K, V> */ {
    class HashElement<K, V> implements Comparable<HashElement<K, V>> {
        K key;
        V value;

        public HashElement(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public int compareTo(HashElement<K, V> o) {
            return (((Comparable<K>) this.key).compareTo(o.key));
        }
    }

    int numElements /* current size */, tableSize /* size of array */;
    double maxLoadFactor /* the point at which we resize */;
    LinkedListPractice<HashElement<K, V>>[] hashArray; /* The hash array will be an array of linked lists */
}