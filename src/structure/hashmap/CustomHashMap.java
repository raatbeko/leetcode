package structure.hashmap;

import java.util.Objects;

public class CustomHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Node<K, V>[] table;
    private int size = 0;

    public CustomHashMap() {
        table = new Node[INITIAL_CAPACITY];
    }

    // Внутренний класс для хранения элементов
    private static class Node<K, V> {
        final K key;
        V value;
        final int hash;
        Node<K, V> next;

        Node(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }

    // Метод для добавления элемента
    public void put(K key, V value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        Node<K, V> current = table[index];
        while (current != null) {
            if (current.hash == hash && Objects.equals(current.key, key)) {
                current.value = value; // обновляем значение, если ключ уже существует
                return;
            }
            current = current.next;
        }

        // Добавляем новый узел в начало списка
        Node<K, V> newNode = new Node<>(key, value, hash);
        newNode.next = table[index];
        table[index] = newNode;
        size++;

        if (size >= table.length * LOAD_FACTOR) {
            resize();
        }
    }

    // Метод для получения значения по ключу
    public V get(K key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        Node<K, V> current = table[index];
        while (current != null) {
            if (current.hash == hash && Objects.equals(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    // Метод для удаления элемента
    public void remove(K key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);

        Node<K, V> current = table[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (current.hash == hash && Objects.equals(current.key, key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Проверка наличия ключа
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // Хеширование ключа
    private int hash(K key) {
        return key == null ? 0 : key.hashCode() ^ (key.hashCode() >>> 16);
    }

    // Определение индекса в массиве
    private int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    // Увеличение размера массива и перераспределение элементов
    private void resize() {
        int newCapacity = table.length * 2;
        Node<K, V>[] newTable = new Node[newCapacity];

        for (Node<K, V> current : table) {
            while (current != null) {
                Node<K, V> next = current.next;

                int index = indexFor(current.hash, newCapacity);
                current.next = newTable[index];
                newTable[index] = current;

                current = next;
            }
        }
        table = newTable;
    }

    // Получить текущий размер
    public int size() {
        return size;
    }

    // Печать содержимого для наглядности
    public void printMap() {
        for (int i = 0; i < table.length; i++) {
            Node<K, V> current = table[i];
            if (current != null) {
                System.out.print("[" + i + "]: ");
                while (current != null) {
                    System.out.print(current.key + "=" + current.value + " -> ");
                    current = current.next;
                }
                System.out.println("null");
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);
        map.put("Grape", 4);

        // Проверка методов
        System.out.println("Apple: " + map.get("Apple")); // 1
        System.out.println("Banana: " + map.get("Banana")); // 2

        System.out.println("Contains 'Orange'? " + map.containsKey("Orange")); // true
        map.remove("Orange");
        System.out.println("Contains 'Orange'? " + map.containsKey("Orange")); // false

        map.printMap();
        System.out.println("Size: " + map.size());
    }
}

