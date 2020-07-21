package Test;

public class T1 extends Thread {
	public void go() {
		System.out.println("Go!");
	}

	public void run() {
		System.out.println("Run!");
	}

	public void begin() {
		System.out.println("Begin!");
	}

	public void execute() {
		System.out.println("Execute!");
	}

	public static void main(String[] args) {
		T1 myTest = new T1();
		myTest.start();
	}
}
