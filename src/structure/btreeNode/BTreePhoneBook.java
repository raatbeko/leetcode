package structure.btreeNode;

// Узел B-Tree, который хранит ключи и ссылки на детей (как индексы в БД)
class BTreeNode {
    int t; // Минимальная степень - сколько детей может иметь узел
    int[] keys; // Ключи в узле
    BTreeNode[] children; // Дети узла
    int n; // Кол-во ключей в текущем узле
    boolean leaf; // Флаг, является ли узел листом (конечным узлом)

    public BTreeNode(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        this.keys = new int[2 * t - 1]; // Максимум ключей
        this.children = new BTreeNode[2 * t]; // Максимум детей
        this.n = 0;
    }
}

// Основной класс B-Tree, который моделирует индекс в базе данных
class BTree {
    private BTreeNode root;
    private int t;

    public BTree(int t) {
        this.t = t;
        this.root = null;
    }

    // Обход дерева (визуализация порядка ключей)
    public void traverse() {
        if (root != null) traverse(root);
    }

    private void traverse(BTreeNode node) {
        int i;
        for (i = 0; i < node.n; i++) {
            if (!node.leaf) traverse(node.children[i]);
            System.out.print(" " + node.keys[i]);
        }
        if (!node.leaf) traverse(node.children[i]);
    }

    // Поиск ключа, как при использовании индекса в БД
    public BTreeNode search(int key) {
        return root == null ? null : search(root, key);
    }

    private BTreeNode search(BTreeNode node, int key) {
        int i = 0;
        while (i < node.n && key > node.keys[i]) i++;

        if (i < node.n && node.keys[i] == key) return node;

        if (node.leaf) return null;

        return search(node.children[i], key);
    }

    // Вставка ключа, как при добавлении индекса
    public void insert(int key) {
        // Проверка на существование ключа
        if (search(key) != null) {
            System.out.println("Ключ " + key + " уже существует.");
            return;
        }

        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys[0] = key;
            root.n = 1;
        } else {
            if (root.n == 2 * t - 1) {
                BTreeNode newNode = new BTreeNode(t, false);
                newNode.children[0] = root;
                splitChild(newNode, 0, root);
                int i = newNode.keys[0] < key ? 1 : 0;
                insertNonFull(newNode.children[i], key);
                root = newNode;
            } else {
                insertNonFull(root, key);
            }
        }
    }

    // Вставка в неполный узел
    private void insertNonFull(BTreeNode node, int key) {
        int i = node.n - 1;
        if (node.leaf) {
            while (i >= 0 && node.keys[i] > key) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.n++;
        } else {
            while (i >= 0 && node.keys[i] > key) i--;
            if (node.children[i + 1].n == 2 * t - 1) {
                splitChild(node, i + 1, node.children[i + 1]);
                if (node.keys[i + 1] < key) i++;
            }
            insertNonFull(node.children[i + 1], key);
        }
    }

    // Разделение переполненного узла (как при балансировке индекса)
    private void splitChild(BTreeNode parent, int i, BTreeNode node) {
        BTreeNode newNode = new BTreeNode(t, node.leaf);
        newNode.n = t - 1;

        for (int j = 0; j < t - 1; j++)
            newNode.keys[j] = node.keys[j + t];

        if (!node.leaf)
            for (int j = 0; j < t; j++)
                newNode.children[j] = node.children[j + t];

        node.n = t - 1;

        for (int j = parent.n; j >= i + 1; j--)
            parent.children[j + 1] = parent.children[j];

        parent.children[i + 1] = newNode;

        for (int j = parent.n - 1; j >= i; j--)
            parent.keys[j + 1] = parent.keys[j];

        parent.keys[i] = node.keys[t - 1];
        parent.n++;
    }
}

// Пример использования B-Tree как телефонной книги
public class BTreePhoneBook {
    public static void main(String[] args) {
        BTree phoneBook = new BTree(3);

        // Добавляем телефонные записи (как в телефонной книге)
        int[] phoneNumbers = {123, 456, 789, 234, 567, 890, 345, 678};

        System.out.println("Добавляем номера телефонов в индекс:");
        for (int number : phoneNumbers) {
            System.out.println("Добавляем номер: " + number);
            phoneBook.insert(number);
        }

        System.out.println("\nОбход структуры телефонной книги:");
        phoneBook.traverse();

        // Поиск номера телефона
        int searchNumber = 567;
        System.out.println("\n\nИщем номер телефона: " + searchNumber);
        System.out.println(phoneBook.search(searchNumber) != null ? "Номер найден" : "Номер не найден");

        // Поиск отсутствующего номера
        int missingNumber = 999;
        System.out.println("\nИщем отсутствующий номер телефона: " + missingNumber);
        System.out.println(phoneBook.search(missingNumber) != null ? "Номер найден" : "Номер не найден");
    }
}

// Этот код демонстрирует, как B-Tree может представлять телефонную книгу.
// Индекс позволяет быстро находить номера телефонов, не перебирая их последовательно.
