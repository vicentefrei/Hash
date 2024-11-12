public class HashTableDJB2 extends HashTable {

    public HashTableDJB2(int size) {
        super(size);
    }

    @Override
    public int hash(String key) {
        long hash = 5381;
        for (char c : key.toCharArray()) {
            hash = ((hash << 5) + hash) + c;
        }
        return Math.abs((int) (hash % size));
    }
}
