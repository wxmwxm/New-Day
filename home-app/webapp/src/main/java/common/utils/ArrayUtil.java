package common.utils;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * This class is used for ...   
 * @author wxm
 * @dateTime 2012-12-9 下午02:27:25
 * @describe 
 *
 */
@SuppressWarnings("unchecked")
public class ArrayUtil {

	public static int arrayHashCode(Object[] a) {
		int ret = 0;
		if (a != null)
			for (Object o : a)
				ret = ret * 13 + o.hashCode();
		return ret;
	}

	public static boolean arrayEquals(Object[] a1, Object[] a2) {
		if (a1 == null && a2 == null)
			return true;
		if (a1 == null || a2 == null)
			return false;
		if (a1.length != a2.length)
			return false;
		for (int i = 0; i < a1.length; i++)
			if (!a1[i].equals(a2[i]))
				return false;
		return true;
	}
	
	public static <K, V> Map<K, V> toMap(Object[][] o) {
		Map<K, V> ret = new HashMap<K, V>();
		for (Object[] en : o) {
			ret.put((K) en[0], (V) en[1]);
		}
		return ret;
	}

	public static <T> T[] merge(T[] t1, T[] t2) {
		List<T> ret = new ArrayList<T>();
		ret.addAll(Arrays.asList(t1));
		ret.addAll(Arrays.asList(t2));
		return ret.toArray(t1);
	}

	public static boolean isEmpty(Collection<?> c) {
		return c == null || c.isEmpty();
	}

	public static boolean isEmpty(Object[] o) {
		return o == null || o.length == 0;
	}

	public static <T> boolean in(T o, T[] array) {
		for (int i = 0; i < array.length; i++) {
			if (o.equals(array[i]))
				return true;
		}
		return false;
	}

	public static <T> boolean in(T o, Collection<T> array) {
		for (T a : array) {
			if (o.equals(a))
				return true;
		}
		return false;
	}

	// TODO: 需要优化
	public static boolean in(Object array, Object array2) {
		if (array == null || array2 == null)
			return false;
		Object[] os = asArray(array);
		Object[] os2 = asArray(array2);
		for (int i = 0; i < os.length; i++) {
			for (int j = 0; j < os2.length; j++) {
				if (os[i] instanceof String && os2[j] instanceof String) {
					if (((String) os[i]).trim()
							.equals(((String) os2[j]).trim()))
						return true;
				} else if (os[i] instanceof String && os2[j] instanceof Boolean) {
					if (os[i].equals(os2[j].toString()))
						return true;
				} else {
					if (os[i].equals(os2[j]))
						return true;
				}
			}
		}
		return false;
	}

	public static String arr2Str(int[] os) {
		return join(os);
	}

	public static String arr2Str(String[] os) {
		return join(os);
	}

	public static String join(Object o) {
		return join(o, ",");
	}

	public static String join(Object o, String split) {
		if (o == null)
			return null;
		Object[] arr = asArray(o);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(split);
		}
		if (sb.length() > 0)
			sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static Object[] asArray(Object o) {
		return asArray(o, true);
	}

	public static Object[] asArray(Object o, boolean splitString) {
		if (o == null)
			return new Object[0];

		if (o instanceof Collection) {
			Collection c = (Collection) o;
			return c.toArray(new Object[c.size()]);
		} else if (o instanceof String[] && ((String[]) o).length == 1) {
			if (splitString)
				return ((String[]) o)[0].split(",");
			else
				return (String[]) o;
		} else if (o.getClass().isArray()) {
			Object[] ret = new Object[Array.getLength(o)];
			for (int i = 0; i < ret.length; i++)
				ret[i] = Array.get(o, i);
			return ret;
		} else if (o instanceof String && splitString) {
			String s = (String) o;
			return StringUtil.split(s).toArray();
		} else {
			return new Object[] { o };
		}
	}

	public static int index(Object[] array, Object match) {
		int ret = -1;
		for (int i = 0; i < array.length; i++)
			if (array[i] != null && array[i].equals(match))
				return i;
		return ret;
	}
}
