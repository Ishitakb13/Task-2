package examscores;

import static org.junit.Assert.*;  
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;               

public class FileWriterSyncTest {

    @Test
    public void testSingleStudentWrite() throws IOException {
        FileWriterSync writer = new FileWriterSync("test_students.csv");
        Students s1 = new Students("Alice", 101, 95);

        writer.writeStudent(s1);

        BufferedReader br = new BufferedReader(new FileReader("test_students.csv"));
        String line = br.readLine();
        br.close();

        assertEquals("Alice,101,95", line);
    }

    @Test
    public void testMultipleThreadWrites() throws InterruptedException, IOException {
        FileWriterSync writer = new FileWriterSync("test_students.csv");

        Students s1 = new Students("Steve", 102, 85);
        Students s2 = new Students("Dustin", 103, 90);

        Thread t1 = new ThreadStudent(writer, s1);
        Thread t2 = new ThreadStudent(writer, s2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        BufferedReader br = new BufferedReader(new FileReader("test_students.csv"));
        String line1 = br.readLine();
        String line2 = br.readLine();
        br.close();

        assertNotNull(line1);
        assertNotNull(line2);
    }
}
