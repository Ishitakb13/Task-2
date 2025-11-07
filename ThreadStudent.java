package examscores;


public class ThreadStudent extends Thread {
private FileWriterSync writer;
private Students student;

public ThreadStudent(FileWriterSync writer, Students student) {
this.writer = writer;
this.student = student;
}

@Override
public void run() {
writer.writeStudent(student);
}
}
