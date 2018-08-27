package test.callback;

public class Teacher implements Callback{
	private Student student;
	public Teacher(Student student){
		this.student= student ;
	}
	public void ask(){
		student.responce(this);
	}
	public void call(int answer) {
		System.out.println("´ð°¸ÊÇ£º"+answer);
	};
}
