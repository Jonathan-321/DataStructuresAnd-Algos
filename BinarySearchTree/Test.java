import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        BinaryTree<Student> tree = new BinaryTree<>();

        // Read students from the CSV file and insert them into the binary tree
        String fileName = "testdata.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                tree.insert(id, new Student(id, name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Binary Tree Test");

        System.out.println("Binary Tree Height = " + tree.height());
        
        System.out.println("Search for 782209");
        Student student = tree.search(782209);
        if (student != null) {
            System.out.println("Search result: " + student.getId() + " - " + student.getName());
        } else {
            System.out.println("Search result: 782209 not found");
        }

        System.out.println("Removed 782209");
        tree.remove(782209);

        System.out.println("Search for 782209");
        student = tree.search(782209);
        if (student != null) {
            System.out.println("Search result: " + student.getId() + " - " + student.getName());
        } else {
            System.out.println("Search result: 782209 not found");
        }
    }
}