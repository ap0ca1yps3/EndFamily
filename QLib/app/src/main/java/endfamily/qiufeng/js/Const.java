package endfamily.qiufeng.js;
import android.app.*;

public abstract class Const
{
	public static enum DebugLevel{
		NO(0),
		LOG(1),
		INFO(2);
		int lvl;
		public DebugLevel(int i){
			lvl=i;
		}
	}
	public static Const instance;
	public int debugLevel=0;
	public Activity cx;
	public abstract void print(String str);
	public void print(String str,int l){
		if(l<=debugLevel)
			print(str);
	}
};
