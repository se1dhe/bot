package dev.se1dhe.core.util;



public class CommonUtil {
	/**
	 * @param intValue     the value
	 * @param defaultValue the default value
	 * @return intValue as int if its valid integer value, defaultValue otherwise
	 */
	public static int parseInt(String intValue, int defaultValue) {
		try {
			return Integer.parseInt(intValue);
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	/**
	 * @param text the text
	 * @return {@code true} if text can be parsed as long, {@code false}
	 */
	public static boolean isDigit(String text) {
		try {
			Long.parseLong(text);
			return true;
		} catch (Throwable t) {
			return false;
		}
	}
	
	/**
	 * @param text - the text to check
	 * @return {@code true} if {@code text} is integer, {@code false} otherwise
	 */
	public static boolean isInteger(String text) {
		if ((text == null) || text.isEmpty()) {
			return false;
		}
		try {
			Integer.decode(text);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * @param text - the text to check
	 * @return {@code true} if {@code text} is float, {@code false} otherwise
	 */
	public static boolean isFloat(String text) {
		if ((text == null) || text.isEmpty()) {
			return false;
		}
		try {
			Float.parseFloat(text);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * @param text - the text to check
	 * @return {@code true} if {@code text} is double, {@code false} otherwise
	 */
	public static boolean isDouble(String text) {
		if ((text == null) || text.isEmpty()) {
			return false;
		}
		try {
			Double.parseDouble(text);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * @param <T>      the type
	 * @param name     the text to check
	 * @param enumType the enum type
	 * @return {@code true} if {@code text} is enum, {@code false} otherwise
	 */
	public static <T extends Enum<T>> boolean isEnum(String name, Class<T> enumType) {
		if ((name == null) || name.isEmpty()) {
			return false;
		}
		try {
			Enum.valueOf(enumType, name);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
