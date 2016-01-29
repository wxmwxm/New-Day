package common.utils;

/**
 * This class is used for ...   
 * @author wxm
 * @dateTime 2012-12-9 下午02:52:08
 * @describe 
 *
 */
public class ValidateRegexUtils {

	public static String SEX = "[0-1]";
	public static String INTEGER = "^-?[1-9]\\d*$";
	public static String POSITIVE_INTEGER = "^[1-9]\\d*$";
	public static String NEGATIVE_INTEGER = "^-[1-9]\\d*$";
	public static String NUM = "^([-]?)\\d*\\.?\\d+$";
	public static String POSITIVE_NUM = "^\\d*\\.?\\d+|0$";
	public static String NEGATIVE_NUM = "^-\\d*\\.?\\d+|0$";
	public static String DECIMAL = "^([-]?)[1-9]\\d*.\\d+\\d*|0.\\d*[1-9]\\d*$";
	public static String POSITIVE_NUMBER = "^[1-9]\\d*[.\\d\\d*]?|0.\\d*[1-9]\\d*$";
	public static String POSITIVE_DECIMAL = "^[1-9]\\d*.\\d+\\d*|0.\\d*[1-9]\\d*$";
	public static String NEGATIVE_NUMBER = "^-([1-9]\\d*[.\\d\\d*]?|0.\\d*[1-9]\\d*)$";
	public static String NEGATIVE_DECIMAL = "^-([1-9]\\d*.\\d+\\d*|0.\\d*[1-9]\\d*)$";
	public static String EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
	public static String COLOR = "^[a-fA-F0-9]{6}$";
	public static String URL = "^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$";
	public static String CHINESE = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$";
	public static String ASCII = "^[\\x00-\\xFF]+$";
	public static String ZIPCODE = "^\\d{6}$";
	public static String MOBILE = "^(13|14|15|18)[0-9]{9}$";
	public static String IP4 = "^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$";
	public static String EMPTY = "^(\\s+)$";
	public static String PICTURE = "(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)$";
	public static String RAR = "(.*)\\.(rar|zip|7zip|tgz)$";
	public static String DATE = "^\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}$";
	public static String ISO_DATETIME_FORMAT = "^\\d{4}(\\-)\\d{2}\\1\\d{2}[ ]\\d{2}:\\d{2}:\\d{2}$";
	public static String ISO_DATE_FORMAT = "^\\d{4}(\\-)\\d{2}\\1\\d{2}$";
	public static String QQ = "^[1-9]*[1-9][0-9]*$";
	public static String TEL = "^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{3,}))?$";
	public static String USERNAME = "^\\w+$";
	public static String LETTER = "^[A-Za-z]+$";
	public static String LETTER_U = "^[A-Z]+$";
	public static String LETTER_L = "^[a-z]+$";
	public static String ID_CARD = "^[1-9]([0-9]{13}|[0-9]{16})[Xx0-9]$";
	public static String PASSPORT = "^([PS]\\.\\d{7})|([GS]\\d{8})|(D\\d+)|(\\d{9})$";
	public static String USABLE_CABIN = "^[A-Z][A1-9]|[A-Z][1-9][A1-9]$";
	public static String AIRPORT = "^([A-Z]+|[0-9]+)[A-Z]+$";
	public static String BUSINESS_LICENCE_NO = "^\\d{13}$";
	public static String NO_SYMBOL = "[a-zA-Z0-9\\u4E00-\\u9FA5\\uF900-\\uFA2D\b\r]$";
	public static String MEMBER_NAME = "^[A-Za-z]|[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$";
	public static String MEMBER_NAME2 = "^[A-Za-z\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$";
	public static String PASSENGER = "^([\\u4E00-\\u9FA5\\uF900-\\uFA2D]*[A-Za-z]*[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+[A-Za-z]*[\\u4E00-\\u9FA5\\uF900-\\uFA2D]*)|([A-Za-z]+\\/[A-Za-z]+)|([A-Za-z]+\\/[A-Za-z]+ {1}[A-Za-z]+)$";
	public static String IPASSENGER = "^([A-Za-z]+\\/[A-Za-z]+)|([A-Za-z]+\\/[A-Za-z]+ {1}[A-Za-z]+)$";
	public static String PASSWORD = "^[\\dA-Za-z0-9(!@#$%&*_,./;)]{6,18}$";

	public ValidateRegexUtils() {
	}

}
