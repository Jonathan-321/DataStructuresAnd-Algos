package Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

class Trie {
    private Node root;

    public Trie() {
        root = new Node('\0');
    }

    public void insert(String word, int location) {
        Node current = root;
        for (char c : word.toCharArray()) {
            Node child = findChild(current, c);
            if (child == null) {
                child = new Node(c);
                current.children.add(child);
            }
            current = child;
        }
        current.isEndOfWord = true;
        current.locations.add(location);
    }

    private Node findChild(Node node, char c) {
        for (Node child : node.children) {
            if (child.data == c) {
                return child;
            }
        }
        return null;
    }

    public ArrayList<Integer> search(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            Node child = findChild(current, c);
            if (child == null) {
                return new ArrayList<>();
            }
            current = child;
        }
        return current.isEndOfWord ? current.locations : new ArrayList<>();
    }

    public void sort() {
        sortUtil(root);
    }

    private void sortUtil(Node node) {
        node.children.sort(Comparator.comparing(n -> n.data));
        for (Node child : node.children) {
            sortUtil(child);
        }
    }
}