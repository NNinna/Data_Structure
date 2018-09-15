//the class need to implement hashCode() and equals() methods 
//be establish a hashtable

public class Student {
	private int id;
	private String name;
	
	private static final int B = 31;
	
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		int code = 0;
		code =  code * B + ((Integer) id).hashCode();
		code =  code * B + this.name.hashCode();
		return code;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null) {
			return false;
		}
		
		if (this.getClass() != o.getClass()) {
			return false;
		}
		
		Student another = (Student) o;
		
		return this.id == another.id && this.name.toLowerCase().equals(another.name.toLowerCase());
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(this.id);
		builder.append(",");
		builder.append(this.name);
		builder.append("]");
		return builder.toString();
	}
	
}
