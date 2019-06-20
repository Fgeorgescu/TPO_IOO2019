package utils;

public class Utils {

	public static boolean isStringNullOrEmpty(String string) {
		return (string == null) || "".equalsIgnoreCase(string);
	}
}
