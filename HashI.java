public class HashI<K, V> {
    public int hashCode(String s) {
        int g = 31;
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = g * hash + s.charAt(i);
        }
        return hash;
    }
}