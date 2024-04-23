package complexities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Testclass {

    // we're going to write the data to a csv file so that we can import it into a spreadsheet
    // Starting from the first and then we'll alternating after every example  
    // to have five .csv files which we'll be importing into an excel spreadsheet for every 
    // algorithm that we're testing

    private static final String OUTPUT_FILE = "example1.csv"; 
    // we'll change this to example2.csv, example3.csv, example4.csv, example5.csv  
    // after every example 
    
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE))) {
            writer.write("n,timeMs,algorithmNum");
            writer.newLine();

            //  the following lines test each algorithm one by one we then 
            // import the data in a csv file into a spreadsheet and plot
            //  the data and see what the graphs look like
            //  we're going to use the data to see if I can match what the time complexity of each
            //  algorithm is from the theoritical analysis I did on paper.


            testAlgorithm(writer, 1, 100, 100000, 100);
           //testAlgorithm(writer, 2, 100, 100000, 100);
          // testAlgorithm(writer, 3, 100, 1000, 100);
         // testAlgorithm(writer, 4, 100, 100000, 100);
         //testAlgorithm(writer, 5, 100, 1000, 10);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // the following method is going to test a single algorithm
    // we're going to pass in the algorithm number, the starting value of n, the ending value of n
    // and the step size
    // we're going to run the algorithm 1000 times for each value of n
    // and then we're going to calculate the average time in milliseconds
    // for the algorithm to run on arrays of size n
    // and then we're going to write that data to the csv file
    public static void testAlgorithm(BufferedWriter writer, int algorithmNum, 
                                                                        int startN, int endN, int step) {
        try {
            for (int n = startN; n <= endN; n += step) {
                long totalTime = 0;
                for (int i = 0; i < 1000; i++) {
                    int[] arr = generateRandomArray(n);
                    long startTime = System.nanoTime();
                    runAlgorithm(algorithmNum, arr);
                    long endTime = System.nanoTime();
                    totalTime += endTime - startTime;
                }  

                // This following line calculates the average time in milliseconds
                // for the algorithm to run on arrays of size n
                // (totalTime / 1_000_000.0) converts nanoseconds to milliseconds
                // writer.flush() ensures that the line is written to the file immediately 


                double avgTimeMs = totalTime / 1_000_000.0; 
                writer.write(n + "," + avgTimeMs + "," + algorithmNum);
                writer.newLine();
                writer.flush(); 

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // the following method generates a random array of size n
    // with random values between 0 and Integer.MAX_VALUE
    // we're going to use this method to generate random arrays
    // to test our algorithms on
    // we're going to use the same array for each algorithm
    public static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * Integer.MAX_VALUE);
        }
        return arr;
    }
    
    public static void runAlgorithm(int algoNum, int[] arr) {
        switch(algoNum) {
            case 1: Algorithms.example1(arr); break;
            case 2: Algorithms.example2(arr); break;
            case 3: Algorithms.example3(arr); break;
            case 4: Algorithms.example4(arr); break;
            case 5: Algorithms.example5(arr, arr); break;
        }
    }
    
}
