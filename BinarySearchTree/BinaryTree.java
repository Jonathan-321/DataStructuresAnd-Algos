public class BinaryTree<T> {
    private Entry<T> root;

    public BinaryTree() {
        root = null;
    }

    public void insert(Comparable key, T value) {
        root = insert(root, null, key, value);
    }

    private Entry<T> insert(Entry<T> node, Entry<T> parent, Comparable key, T value) {
        if (node == null) {
            Entry<T> newEntry = new Entry<>(key, value);
            newEntry.parent = parent;
            return newEntry;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(node.left, node, key, value);
        } else if (cmp > 0) {
            node.right = insert(node.right, node, key, value);
        } else {
            // Update the value associated with the existing key
            node.value = value;
        }

        return node;
    }

    public T search(Comparable key) {
        Entry<T> entry = search(root, key);
        return (entry != null) ? entry.value : null;
    }

    private Entry<T> search(Entry<T> node, Comparable key) {
        if (node == null || key.compareTo(node.key) == 0) {
            return node;
        }

        if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    public T remove(Comparable key) {
        Entry<T> entry = search(root, key);
        if (entry != null) {
            root = remove(root, key);
            return entry.value;
        }
        return null;
    }

    private Entry<T> remove(Entry<T> node, Comparable key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            Entry<T> minEntry = findMin(node.right);
            node.key = minEntry.key;
            node.value = minEntry.value;
            node.right = remove(node.right, minEntry.key);
        }
        return node;
    }

    private Entry<T> findMin(Entry<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int height() {
        return height(root)-1;
    }

    private int height(Entry<T> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    private static class Entry<T> {
        private Comparable key;
        private T value;
        private Entry<T> parent;
        private Entry<T> left;
        private Entry<T> right;

        public Entry(Comparable key, T value) {
            this.key = key;
            this.value = value;
        }
    }
}