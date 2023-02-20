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

    public Hashes(int tableSize) {
        this.tableSize = tableSize;
        hashArray = (LinkedListPractice<HashElement<K, V>>[]) new LinkedListPractice[tableSize];
        for (int i = 0; i < tableSize; i++) {
            hashArray[i] = new LinkedListPractice<HashElement<K, V>>();
        }
        maxLoadFactor = 0.75;
        numElements = 0;
    }

    public boolean add(K key, V value) {
        if (loadFactor() > maxLoadFactor) {
            resize(tableSize * 2);
        }
        HashElement<K, V> hashElement = new HashElement(key, value);
        int hashval = key.hashCode();
        hashval = hashval & 0x7FFFFFFF;
        hashval = hashval % tableSize;
        // hashArray[hashval].add(hashElement); LinkedListPractice is missing an add()
        // method
        numElements++;
        return true;
    }
}