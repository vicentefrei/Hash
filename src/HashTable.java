import java.util.LinkedList;

public abstract class HashTable {
    protected LinkedList<String>[] table;
    protected int size;
    protected int collisions;
    protected int[] collisionCounts; // Adicionando um array para contar colisões por índice

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        this.collisionCounts = new int[size]; // Inicializamos o array de contagem de colisões
        for (int i = 0; i < size; i++) {
            this.table[i] = new LinkedList<>();
        }
        this.collisions = 0;
    }

    public abstract int hash(String key);

    public void insert(String key) {
        int index = hash(key);
        if (!table[index].isEmpty()) {
            collisions++;
            collisionCounts[index]++; // Incrementamos a contagem de colisões para o índice específico
        }
        table[index].add(key);
    }

    public boolean search(String key) {
        int index = hash(key);
        return table[index].contains(key);
    }

    public int getCollisions() {
        return collisions;
    }

    public void printCollisions() {
        System.out.println("Índices com colisões:");
        for (int i = 0; i < table.length; i++) {
            if (table[i].size() > 1) {
                System.out.println("Índice " + i + ": " + table[i].size() + " elementos (Colisões: " + collisionCounts[i] + ")");
            }
        }
    }
}
