import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SortingTest {
    public static void main(String[] args) {
        SortedList<Student> studentList = new SortedList<>();

        // Read data from CSV file and populate the studentList ArrayList
        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                studentList.add(new Student(id, name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("Testing Sorting Methods");

        // Insertion Sort Test
        System.out.println("Insertion Sort Test");
        long startTime = System.nanoTime();
        studentList.insertionSort();
        long endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime));
        printList(studentList);

        // Selection Sort Test
        System.out.println("Selection Sort Test");
        startTime = System.nanoTime();
        studentList.selectionSort();
        endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime));
        printList(studentList);

        // Quick Sort Test
        System.out.println("Quick Sort Test");
        startTime = System.nanoTime();
        studentList.quickSort();
        endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime));
       printList(studentList);

        // Merge Sort Test
        System.out.println("Merge Sort Test");
        startTime = System.nanoTime();
        studentList.mergeSort();
        endTime = System.nanoTime();
        System.out.println("Time: " + (endTime - startTime));
       printList(studentList);
    }

    private static void printList(SortedList<Student> studentList) {
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println();
    }

}



