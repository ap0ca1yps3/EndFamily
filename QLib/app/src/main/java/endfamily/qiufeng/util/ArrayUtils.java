package endfamily.qiufeng.util;
import java.util.*;

public class ArrayUtils
{
	public static<T> T[] push(T[] arr,T ele){
		Arrays.copyOf(arr,ele);
		return arr;
	}
	public static byte[] push(byte[] arr,byte ele){
		return push(arr,ele);
	}
}
