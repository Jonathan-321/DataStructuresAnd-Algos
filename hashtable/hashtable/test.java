package hashtable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class test {
    public static void main(String[] args) {
        String filePath = "HASHTABLE/hash.csv";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            /* // Testing HashTableLP with table size 100
            hashtableLP<Integer, Student> htlp = new hashtableLP<>(100);
            int collisionsLP = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                collisionsLP += htlp.put(id, new Student(id, name));
            }
            System.out.println("Test HashTableLP with table size 100");
            System.out.println("Number of Collisions = " + collisionsLP);
            Student studentLP = htlp.get(782209);
            System.out.println("Name = " + (studentLP != null ? studentLP.name : "not found"));
            htlp.remove(782209);
            System.out.println(htlp.get(782209) != null ? studentLP.name : "782209 not found");
            System.out.println();
            
            // Reset the reader to the beginning of the file
            reader.close(); */
            
            // Test HashTableDH with table size 100
            hashtableDH<Integer, Student> htdh100 = new hashtableDH<>(100);
            int collisionsDH100 = 0;
            String row100;
            while ((row100 = reader.readLine()) != null) {
                String[] hashtable = row100.split(",");
                int id = Integer.parseInt(hashtable[0]);
                String name = hashtable[1];
                collisionsDH100 += htdh100.put(id, new Student(id, name));
            }
            System.out.println("Test HashTableDH with table size 100");
            System.out.println("Number of Put Collisions = " + collisionsDH100);
            Student studentDH100 = htdh100.get(782209);
            System.out.println("Name = " + (studentDH100 != null ? studentDH100.name : "not found"));
            htdh100.remove(782209);
            System.out.println(htdh100.get(782209) != null ? studentDH100.name : "782209 not found");
            System.out.println();
            
            // Reset the reader to the beginning of the file
            reader.close();
            
            /* // Test HashTableDH with table size 200
            hashtableDH<Integer, Student> htdh200 = new hashtableDH<>(200);
            int collisionsDH200 = 0;
            String row200;
            while ((row200 = reader.readLine()) != null) {
                String[] hashtable = row200.split(",");
                int id = Integer.parseInt(hashtable[0]);
                String name = hashtable[1];
                collisionsDH200 += htdh200.put(id, new Student(id, name));
            }
            System.out.println("Test HashTableDH with table size 200");
            System.out.println("Number of Put Collisions = " + collisionsDH200);
            Student studentDH200 = htdh200.get(782209);
            System.out.println("Name = " + (studentDH200 != null ? studentDH200.name : "not found"));
            htdh200.remove(782209);
            System.out.println(htdh200.get(782209) != null ? studentDH200.name : "782209 not found");
            System.out.println();
             */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}