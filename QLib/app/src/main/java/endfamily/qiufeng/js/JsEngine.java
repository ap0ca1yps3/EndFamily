package endfamily.qiufeng.js;
import endfamily.qiufeng.js.modpe.*;
import java.io.*;
import org.mozilla.javascript.*;

public class JsEngine
{
	public static Class<?>[] ModClasses={
		ModPE.class
	};
	
	public Context ctx;
	public ScriptableObject scope;
	public File file;
	
	public JsEngine(File path){
		this.file=path;
		ctx=Context.enter();
		ctx.setOptimizationLevel(-1);
		scope=ctx.initStandardObjects();
		//设置ecma6标准
		ctx.setLanguageVersion(ctx.VERSION_ES6);
	}
	public JsEngine(){
		this(null);
	}
	
	public void initModClasses(){
		Const.instance.print("Loading Mod Classes...");
		Class<?>[] argcls={
			JsEngine.class,
		};
		for (Class<?> c : ModClasses){
			try{
				Object instance=c.getConstructor(argcls).newInstance(this);
				ScriptableObject.putProperty(scope,c.getName(),Context.javaToJS(instance,scope));
			}catch(Exception e){
				Const.instance.print("Cannot load "+c.getName());
			}
		}
	}
	public void run(InputStream in,String fileName){
		try{
			ctx.evaluateReader(scope, new InputStreamReader(in), fileName, 0, null);
		}catch(IOException e){
			Const.instance.print(e.getClass().getName()+":"+e.getMessage());
			for(StackTraceElement ste : e.getStackTrace()){
				Const.instance.print(ste.toString());
			}
			Const.instance.print(fileName+": NOP.");
		}
	}
};
