package s201AP3;

/**
/**
 * 
 * @author Caleb P
 *
 */
/**
 * 
 * Declaring this header get's you one point
 *
 */
public class CodeWordChecker  implements StringChecker{
	/**
	 * Declaring these variables also gets you one point
	 */
	private int minLength;
	private int maxLength;
	private String notAllowed;
	
	public static void main(String[] args) {
		System.out.println(sc1.isValid("happy"));
		System.out.println(sc1.isValid("happy$"));
		System.out.println(sc1.isValid("Code"));
		System.out.println(sc1.isValid("happyCode"));
		
		System.out.println(sc2.isValid("MyPass"));
		System.out.println(sc2.isValid("Mypassport"));
		System.out.println(sc2.isValid("happy"));
		System.out.println(sc2.isValid("1,000,000,000,000,000"));

	}

	/**
	 * Declaring these next two methods get's another point
	 * @param minLen minimum length for the whole string
	 * @param maxLen max length for the string
	 * @param symbol the string not allowed in the whole string
	 * 
	 * Also, using three parameters get's you another point
	 */
	public CodeWordChecker(int minLen, int maxLen, String symbol) {
		minLength = minLen;
		maxLength = maxLen;
		notAllowed = symbol;
	}
	/**
	 * Declaring this parameter get's you one point
	 * @param symbol
	 */
	public CodeWordChecker(String symbol) {
		minLength = 6;
		maxLength= 20;
		notAllowed = symbol;
	}
	/**
	 * Declaring the header get's you one point
	 * Also, checking for that it is in between allowed lengths gets you +1
	 * Checking for any unwanted string gets you another point
	 * And also returns true if it is between min and max length, and does not contain unwanted string, this get's you one point, the last one possible for this question
	 */
	public boolean isValid(String str) {
		return str.length() >= minLength && str.length() <= maxLength && str.indexOf(notAllowed) == -1;
	}
}
