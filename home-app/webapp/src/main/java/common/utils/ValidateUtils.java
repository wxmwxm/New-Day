package common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used for ...   
 * @author wxm
 * @dateTime 2012-12-9 下午02:52:16
 * @describe 
 *
 */
public class ValidateUtils {

	public ValidateUtils() {
	}

	public static boolean validate(String validateData, String validateRegex) {
		boolean validateResult = false;
		if (StringUtils.isEmpty(validateData)
				|| StringUtils.isEmpty(validateRegex)) {
			return validateResult;
		} else {
			Pattern regex = Pattern.compile(validateRegex);
			Matcher matcher = regex.matcher(validateData);
			validateResult = matcher.matches();
			return validateResult;
		}
	}
}
