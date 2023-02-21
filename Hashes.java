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
        hashArray[hashval].addFirst(hashElement);
        numElements++;
        return true;
    }

    public boolean remove(K key, V value) {
        int hashval = key.hashCode();
        hashval = hashval & 0x7FFFFFFF;
        hashval = hashval % tableSize;
        // hashArray[hashval].remove(hashElement);
        numElements--;
        return true;
    }

    public V getValue(K key) {
        int hashval = key.hashCode() & 0x7FFFFFFF % tableSize;
        for (HashElement<K, V> hashElement : hashArray[hashVal]) {
            if (((Comparable<K>) key).compareTo(hashElement.key) == 0) {
                return hashElement.value;
            }
            return null;
        }
    }

    public void resize(int newSize) {
        LinkedListPractice<HashElement<K, V>>[] new_array = (LinkedListPractice<HashElement<K, V>>[]) new LinkedListPractice[newSize];
        for (int i = 0; i < newSize; i++) {
            new_array[i] = new LinkedListPractice<HashElement<K, V>>();
        }
        for (K key : this) {
            V value = getValue(key);
            HashElement<K, V> hashElement = new HashElement<K, V>(key, value);
            int hashVal = (key.hashCode() & 0x7FFFFFFF) % newSize;
            new_array[hashVal].add(hashElement);
        }
        hashArray = new_array;
        tableSize = newSize;
    }

    class IteratorHelper<T> {
        T[] keys;
        int position;

        public IteratorHelper() {
            keys = (T[]) Object[numElements]
            int p = 0;
            for (int i = 0; i < tableSize; i++) {
                LinkedListPractice<HashElement<K, V>> list = hashArray[i];
                for (HashElement<K, V> h: list) {
                    keys[p++] = (T) h.key();
                }
                position = 0;
            }
        }
    }
}