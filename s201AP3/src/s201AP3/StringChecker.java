package s201AP3;

public interface StringChecker {
	StringChecker sc1 = new CodeWordChecker(5,8,"$");
	StringChecker sc2 = new CodeWordChecker("pass");
	boolean isValid(String str);
}
