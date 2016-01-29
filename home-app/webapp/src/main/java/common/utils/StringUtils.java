package common.utils;


public class StringUtils extends StringUtil {

	public StringUtils() {
	}


	public static String toCenterUpperCase(String destStr) {
		if (isEmpty(destStr))
			return destStr;
		String attribute = destStr;
		if (destStr.contains("_")) {
			attribute = destStr.toLowerCase().trim();
			String str;
			for (int index = -1; (index = attribute.indexOf("_")) != -1; attribute = (new StringBuilder(
					String.valueOf(attribute.substring(0, index).trim())))
					.append(str.substring(0, 1).toUpperCase()).append(
							str.substring(1)).toString()) {
				str = attribute.substring(index + 1).trim();
				if (!"".equals(str.trim()))
					continue;
				attribute = attribute.substring(0, index).trim();
				break;
			}

		}
		return attribute;
	}

	
	
	public static String firstToUpper(String str) {
		return (new StringBuilder(String.valueOf(str.substring(0, 1)
				.toUpperCase()))).append(str.substring(1)).toString();
	}

	public static String firstToLower(String str) {
		return (new StringBuilder(String.valueOf(str.substring(0, 1)
				.toLowerCase()))).append(str.substring(1)).toString();
	}

	public static String toSBC(String input) {
		String temp = "";
		for (int i = 0; i < input.length(); i++)
			temp = (new StringBuilder(String.valueOf(temp))).append(
					toSBC(input.charAt(i))).toString();

		return temp;
	}

	public static char toSBC(char input) {
		if (input > ' ' && input < '\177')
			input += '\uFEE0';
		return input;
	}

	public static String add(String destStr) {
		String numStr = isEmpty(destStr) ? "1" : (new StringBuilder(String
				.valueOf(Integer.parseInt(destStr) + 1))).toString();
		return numStr;
	}

}
