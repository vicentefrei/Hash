public class HashTableSumAscii extends HashTable {

    public HashTableSumAscii(int size) {
        super(size);
    }

    @Override
    public int hash(String key) {
        int sum = 0;
        for (char c : key.toCharArray()) {
            sum += c * 31;
        }
        return Math.abs(sum % size);
    }
}
