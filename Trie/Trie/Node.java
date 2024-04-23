package Trie;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


class Node {
    char data;
    boolean isEndOfWord;
    ArrayList<Node> children;
    ArrayList<Integer> locations;
    List<Integer> startOfWordIndex; 

    public Node(char data) {
        this.data = data;
        isEndOfWord = false;
        children = new ArrayList<>();
        locations = new ArrayList<>();
    }
}