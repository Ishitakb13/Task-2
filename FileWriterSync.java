package examscores;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterSync {
 private String filePath;

 public FileWriterSync(String filePath) {
 this.filePath = filePath;
 }

 public synchronized void writeStudent(Students s) {
 try (FileWriter writer = new FileWriter(filePath, true)) {
 writer.write(s.toCSV());
 System.out.println("Written: " + s.toCSV());
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
}