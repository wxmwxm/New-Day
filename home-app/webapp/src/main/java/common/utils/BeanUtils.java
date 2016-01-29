package common.utils;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeanUtils {

	public static String getDBLink(String value) {
		return replaceStr(value, "*", "%");
	}
	
	
	/**
	 * 判断<code>subClass</code>是否是superClass的子类
	 * @param subClass
	 * @param superClass
	 * @return
	 */
	public static boolean isSubClass(Class<?> subClass, Class<?> superClass){
		   if(subClass == null || superClass == null)
			   return false;
		   if (subClass.equals(Object.class))
			   return false;
		   else{
			   Class<?> subClassSuper = subClass.getSuperclass();
			   if(subClassSuper != null){
				   if(subClassSuper.equals(superClass))
					   return true;
				   else
					   return isSubClass(subClass.getSuperclass(), superClass);
			   }else{
				   return false;
			   }
		   }
	}
	
	/**
	 * 判断List是否存在此对像
	 * @param list
	 * @param key
	 * @return
	 */
	public static boolean listExists(List<?> list, String key){
		if (list == null)
			return false;
		
		for (int i = 0; i < list.size(); i ++) {
			String o = (String)list.get(i);
			if (o == key)
				return true;
		}
		
		return false;
	}
	   
	/**
	 * 为空判断
	 * @param fields
	 * @return
	 */
    public static String isNull(String str, String ren) {
        if (str == null || str.length() == 0 || str.equals("null"))
        	return ren;
        else
        	return str;
    }
    
	/**
	 * 为空判断
	 * @param fields
	 * @return
	 */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str.equals("null");
    }

    /**
	 * 不为空判断
	 * @param fields
	 * @return
	 */
    public static boolean isNotEmpty(String str) {
        return str != null && str.length() > 0;
    }
	
	/**
	 * 为空判断
	 * @param fields
	 * @return
	 */
	public static boolean isObjectNull(Object fields) {
		boolean result = false;
		if (fields == null)
			result = true;
		return result;
	}
	
	/**
	 * 不为空判断
	 * @param fields
	 * @return
	 */
	public static boolean isObjectNotNull(Object fields) {
		boolean  result = false;
		if (fields != null)
			result = true;
		return result;
	}	
	
	/**
	 * 字符串替换函数
	 * sql = Util.replaceStr(sql, "@userid", baseAttrib.getUserid());
	 * @param strSource
	 * @param strFrom
	 * @param strTo
	 * @return
	 */
	public static String replaceStr(String strSource, String strFrom, String strTo) {
		if (strSource == null)
			return null;

		int i = 0;
		if ((i = strSource.indexOf(strFrom, i)) >= 0) {
			char[] cSrc = strSource.toCharArray();
			char[] cTo = strTo.toCharArray();
			int len = strFrom.length();
			StringBuffer buf = new StringBuffer(cSrc.length);
			buf.append(cSrc, 0, i).append(cTo);
			i += len;
			int j = i;
			while ((i = strSource.indexOf(strFrom, i)) > 0) {
				buf.append(cSrc, j, i - j).append(cTo);
				i += len;
				j = i;
			}
			buf.append(cSrc, j, cSrc.length - j);
			return buf.toString();
		}
		return strSource;
	}
	
	/**
	 * 解决下载中文文件名的乱代码处理
	 * @param s
	 * @return
	 */
	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					ex.printStackTrace();
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}	
	
	/**
	 * GBK
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String getChar(String str) throws Exception{
		if (str!=null)
			str = new String(str.getBytes("iso-8859-1"),"GBK");
		return str;		
	}
	
	/**
	 * 整型判断
	 * @param str
	 * @return
	 */
    public static boolean isInt(String str) {
        if(str == null)
            return false;
        int sz = str.length();
        for(int i = 0; i < sz; i++)
            if(!Character.isDigit(str.charAt(i)))
                return false;

        return true;
    }
    
    /**
     * support Numeric format:<br>
     * "33" "+33" "033.30" "-.33" ".33" " 33." " 000.000 "
     * @param str String
     * @return boolean
     */
   public static boolean isNumeric(String str) {
       int begin = 0;
       boolean once = true;
       if (str == null || str.trim().equals("")) {
           return false;
       }
       str = str.trim();
       if (str.startsWith("+") || str.startsWith("-")) {
           if (str.length() == 1) {
               // "+" "-"
               return false;
           }
           begin = 1;
       }
       for (int i = begin; i < str.length(); i++) {
           if (!Character.isDigit(str.charAt(i))) {
               if (str.charAt(i) == '.' && once) {
                   // '.' can only once
                   once = false;
               } else {
                   return false;
               }
           }
       }
       if (str.length() == (begin + 1) && !once) {
           // "." "+." "-."
           return false;
       }
       return true;
   }

   /**
     * support Integer format:<br>
     * "33" "003300" "+33" " -0000 "
     * @param str String
     * @return boolean
     */
   public static boolean isInteger(String str) {
       int begin = 0;
       if (str == null || str.trim().equals(""))
           return false;
       
       str = str.trim();
       if (str.startsWith("+") || str.startsWith("-")) {
           if (str.length() == 1) {
               // "+" "-"
               return false;
           }
           begin = 1;
       }
       for (int i = begin; i < str.length(); i++) {
           if (!Character.isDigit(str.charAt(i))) {
               return false;
           }
       }
       return true;
   }

   /**
    * using Regular Expression
    * support Integer format:<br>
    * "33" "003300" " -0000 "
    * @param str
    * @return
    */
   public static boolean isIntegerRegex(String str) {  
	   Pattern pattern = Pattern.compile("^[+\\-]?\\d+$");
	   Matcher matcher = pattern.matcher(str.trim());
	   return matcher.matches();
   }


   /**
    * using Regular Expression
    * 
    * support Numeric format:<br>
    * "33" "+33" "033.30" "-.33" ".33" " 000.000 "
    * @param str String
    * @return boolean
    */
   public static boolean isNumericRegex(String str) {
	   Pattern pattern = Pattern.compile("^[+\\-]?((\\d*\\.\\d+)|(\\d+))$");
	   Matcher matcher = pattern.matcher(str.trim());
	   return matcher.matches();
   }
   
   public static boolean isEmail(String str) { 
	   if (str == null || str.trim().equals(""))
           return false;
	   
	   String email1="@";   
	   String email2=".";   
	   if((str.indexOf(email1)!=-1)&&(str.indexOf(email2)!=-1))
		   return true;	      
       else   
	       return false;   
   }
   
   public static boolean isEmailRegex(String str){   
	   if (str == null || str.trim().equals(""))
           return false;
	   
	   Pattern pattern = Pattern.compile("^[_a-zA-Z0-9]+(\\.[_a-zA-Z0-9]+)*@[a-zA-Z0-9_-]+(\\.[a-z0-9A-Z-_]+)+$");   
	   Matcher matcher = pattern.matcher(str);   
	   return matcher.matches();   
   }   
   
   public static int StrToInt(String intstr) {
		if (intstr==null){
			return 0;
		}
		Integer integer;
		integer = Integer.valueOf(intstr);
		return integer.intValue();
	}

	public static String IntToStr(int value) {
		Integer integer = new Integer(value);
		return integer.toString();
	}

	public static float StrToFloat(String floatstr) {
		Float floatee;
		floatee = Float.valueOf(floatstr);
		return floatee.floatValue();
	}

	public static String FloatToStr(float value) {
		Float floatee = new Float(value);
		return floatee.toString();
	}

	 /**
	  * 要求舍入后返回BigDecimal类型
	  * @param dou  待舍入的数字
	  * @param scale 返回的BigDecimal对象的标度（scale）
	  * @param roundmode  舍入模式
	  * @return
	  */
	 public static BigDecimal getRound(double dou, int scale, int roundmode) {
		 BigDecimal paramNumber = new BigDecimal(dou);
		 return paramNumber.setScale(scale, roundmode);
	 }
	 
	 /**
	  * MD5
	  * @param str
	  * @return
	  * @throws Exception
	  */
	 public static String getMD5Str(String str) {  
        MessageDigest messageDigest = null;  
  
        try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();  
			messageDigest.update(str.getBytes("UTF-8"));
        } catch (Exception e) {
			e.printStackTrace();
		}			
  
        byte[] byteArray = messageDigest.digest();  
  
        StringBuffer md5StrBuff = new StringBuffer();  
  
        for (int i = 0; i < byteArray.length; i++) {              
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)  
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));  
            else  
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));  
        }  
  
        return md5StrBuff.toString();  
    }  
	 
}
