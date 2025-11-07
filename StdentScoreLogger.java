package examscores;

public class StdentScoreLogger {

public static void main(String[] args) {
 FileWriterSync writer = new FileWriterSync("students.csv");

 Students s1 = new Students("Steve", 102, 85);
 Students s2 = new Students("Dustin", 103, 90);

 Thread t1 = new ThreadStudent(writer, s1);
 Thread t2 = new ThreadStudent(writer, s2);

 t1.start();
 t2.start();

 try {
 t1.join();
 t2.join();
 } catch (InterruptedException e) {
 e.printStackTrace();
 }

 System.out.println("All Student Thread scores are written successfully!");
 }
}
