package examscores;

public class Students {
	 private String name;
	 private int roll;
	 private int marks;

	 public Students(String name, int roll, int marks) {
	 this.name = name;
	 this.roll = roll;
	 this.marks = marks;
	 }

	 public String toCSV() {
	 return name + "," + roll + "," + marks + "\n";
	 }
	}
