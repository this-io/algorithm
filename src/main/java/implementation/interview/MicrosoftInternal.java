package implementation.interview;

public class MicrosoftInternal {
	public static void main(String[] args) {
		MicrosoftInternal m = new MicrosoftInternal();
		System.out.println(m.funct("google"));
		System.out.println(m.funct("Google"));
		System.out.println(m.funct("GOOGLE"));
		System.out.println(m.funct("GOoGLE"));
	}

	boolean funct(String s) {
		return s.matches("[A-Z]*|[a-z]*|[A-Z][a-z]*");
	}
}
