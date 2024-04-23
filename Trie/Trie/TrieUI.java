package Trie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.JOptionPane;

class TrieUI extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    private JTextArea textArea;
    private Trie trie;
    private String text;

    public TrieUI(Trie trie, String text) {
        this.trie = trie;
        this.text = text;

        initComponents();
        initListeners();
        setupLayout();

        setTitle("Text Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
    }

    private void initComponents() {
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        textArea = new JTextArea(text);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
    }

    private void initListeners() {
        searchButton.addActionListener(e -> searchWord());
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel();
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        JScrollPane scrollPane = new JScrollPane(textArea);

        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void searchWord() {
        String word = searchField.getText();
        ArrayList<Integer> locations = trie.search(word); // pass the text parameter to the search method

        if (!locations.isEmpty()) {
            textArea.setText(text);
            Highlighter highlighter = textArea.getHighlighter();
            HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);

            for (int location : locations) {
                try {
                    highlighter.addHighlight(location, location + word.length(), painter);
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }

            textArea.setCaretPosition(0);
        } else {
            JOptionPane.showMessageDialog(this, word + " not found", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
