package Trie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.List;

class Test {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String text = readTextFile("Trie/John.txt");
        int currentLocation = 0;

        StringBuilder word = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(c);
            } else {
                if (word.length() > 0) {
                    trie.insert(word.toString(), currentLocation - word.length());
                    word.setLength(0);
                }
            }
            currentLocation++;
        }

        if (word.length() > 0) {
            trie.insert(word.toString(), currentLocation - word.length());
        }

        trie.sort();

        String searchWord = "Word";
        System.out.println("Searching for " + searchWord);


        ArrayList<Integer> locations = trie.search(searchWord);
    if (!locations.isEmpty()) {
        System.out.println("Found, at: ");
        for (int i = 0; i < locations.size(); i++) {
            System.out.println("Location: " + locations.get(i));
        }
    } else {
        System.out.println(searchWord + " not found");
    }


    SwingUtilities.invokeLater(() -> {
        new TrieUI(trie, text);
    });}


    
    public static String readTextFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}